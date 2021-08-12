package com.ryanhuber.hzdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.ryanhuber.hzdemo"])
class HazelcastDemoApplication

fun main(args: Array<String>) {
	runApplication<HazelcastDemoApplication>(*args)
}
