package com.example.appengine.application.log

interface ILogger {
    fun debug(message: String)
    fun info(message: String)
    fun warn(message: String)
    fun error(t: Throwable?, message: () -> Any?)
}