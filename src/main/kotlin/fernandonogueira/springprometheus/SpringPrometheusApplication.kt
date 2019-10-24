package fernandonogueira.springprometheus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class SpringPrometheusApplication

fun main(args: Array<String>) {
  runApplication<SpringPrometheusApplication>(*args)
}
