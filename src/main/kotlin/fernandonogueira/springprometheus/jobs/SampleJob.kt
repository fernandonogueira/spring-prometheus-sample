package fernandonogueira.springprometheus.jobs

import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SampleJob(private val meterRegistry: MeterRegistry) {

  val timer = meterRegistry.timer("sampleapp_sample_job_duration")

  val logger = LoggerFactory.getLogger(SampleJob::class.java)

  @Scheduled(fixedDelay = 30000)
  fun sampleJob() {
    logger.info("Starting sample job...")
    timer.record {
      Thread.sleep(12000)
    }
    logger.info("Sample job completed.")
  }
}
