package xyz.bengel.hompsi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.security.KeyPairGenerator
import java.security.MessageDigest

@SpringBootApplication
class HompsiApplication

fun main(args: Array<String>) {
	runApplication<HompsiApplication>(*args)
}
