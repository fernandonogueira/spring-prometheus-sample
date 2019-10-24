package fernandonogueira.springprometheus.controller

import fernandonogueira.springprometheus.dto.SampleDTO
import fernandonogueira.springprometheus.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sample")
class SampleController(private val sampleService: SampleService) {

  @GetMapping
  fun getSample(): SampleDTO {
    return sampleService.getSampleResult()
  }


}
