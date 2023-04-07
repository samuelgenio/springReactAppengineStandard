package com.example.appengine.rootproject

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.example.appengine"])
class MicroserviceTemplateApplication : CommandLineRunner {

	override fun run(vararg args: String?) {
		println("started")
	}


}

fun main(args: Array<String>) {
	SpringApplication.run(MicroserviceTemplateApplication::class.java, *args)
}
