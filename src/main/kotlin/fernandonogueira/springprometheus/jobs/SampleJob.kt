package fernandonogueira.springprometheus.jobs

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class SampleJob(private val meterRegistry: MeterRegistry) {

  val timer = Timer.builder("sampleapp_sample_job_duration")
    .publishPercentiles(0.5, 0.95, 0.99)
    .minimumExpectedValue(Duration.ofMillis(1))
    .maximumExpectedValue(Duration.ofSeconds(11))
    .register(meterRegistry)

  val histogram = Timer.builder("sampleapp_sample_job_histogram")
    .publishPercentiles(0.5, 0.95, 0.99)
    .publishPercentileHistogram()
    .sla(Duration.ofMillis(100))
    .minimumExpectedValue(Duration.ofMillis(1))
    .maximumExpectedValue(Duration.ofSeconds(10))
    .register(meterRegistry)

  val logger: Logger = LoggerFactory.getLogger(SampleJob::class.java)

  @Scheduled(fixedDelay = 30000)
  fun sampleJob() {
    logger.info("Starting sample job...")
    histogram.record {
      timer.record {
        Thread.sleep(12000)
      }
    }
    logger.info("Sample job completed.")
  }
}
