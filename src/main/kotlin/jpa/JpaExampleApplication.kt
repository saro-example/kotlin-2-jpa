package jpa

import jpa.misc.logger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaExampleApplication: CommandLineRunner {
	var log = logger<JpaExampleApplication>()
	companion object {
		@JvmStatic fun main(args: Array<String>) {
			runApplication<JpaExampleApplication>(*args)
		}
	}
	override fun run(vararg args: String) {
		log.info("start server")
	}
}

