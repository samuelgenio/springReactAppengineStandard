import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.google.cloud.tools:appengine-gradle-plugin:2.4.4")
    }

}

apply {
    plugin("com.google.cloud.tools.appengine")
}

plugins {
    java
    war
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.example.appengine"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    //	LOG4J
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation(project(":controller"))
    implementation(project(":application"))
    implementation(project(":domain"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.register<Copy>("frontendInstall") {
    val frontendOrigin = "../frontend/build"
    val frontendTarget = "resources/main/static/."
    from(layout.projectDirectory.dir(frontendOrigin))
    include("**")
    into(layout.buildDirectory.dir(frontendTarget))
}

configure<AppEngineAppYamlExtension> {
    println("task name - $name")
    stage {
        setArtifact(tasks.bootJar.map { j -> j.archiveFile.get().asFile })
    }
    deploy {
        projectId = "my-project-id"
        version = "spring-react"
        promote = false
    }
}

/*
    ORDER TO EXECUTE TASKS
*/

tasks.compileJava {
    dependsOn(tasks.getByName("frontendInstall"))
}

tasks.getByName("appengineStage") {
    dependsOn(tasks.bootJar)
}
