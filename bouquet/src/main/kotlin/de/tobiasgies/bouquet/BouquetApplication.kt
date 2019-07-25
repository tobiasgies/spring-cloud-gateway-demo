package de.tobiasgies.bouquet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BouquetApplication

fun main(args: Array<String>) {
	runApplication<BouquetApplication>(*args)
}
