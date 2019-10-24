package fernandonogueira.springprometheus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringPrometheusApplication

fun main(args: Array<String>) {
  runApplication<SpringPrometheusApplication>(*args)
}
