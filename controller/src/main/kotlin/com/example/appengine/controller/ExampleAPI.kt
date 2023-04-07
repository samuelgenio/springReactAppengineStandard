package com.example.appengine.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleAPI @Autowired constructor() {

    @RequestMapping("/api/v2/hello")
    fun hello() = "Hello";

}