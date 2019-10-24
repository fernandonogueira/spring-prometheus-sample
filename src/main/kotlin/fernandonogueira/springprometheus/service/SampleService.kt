package fernandonogueira.springprometheus.service

import fernandonogueira.springprometheus.dto.SampleDTO
import io.micrometer.core.annotation.Timed
import org.springframework.stereotype.Service

@Service
class SampleService {

  @Timed("sampleapp_sample_result", percentiles = [0.50, 0.95, 0.99])
  fun getSampleResult(): SampleDTO {
    return SampleDTO(sampleResult = "someResult")
  }
}
