package com.parlantos.auth.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
public class AuthDto {

  private final Logger logger = LoggerFactory.getLogger(AuthDto.class);

  @Value("${snowflake.baseUrl}")
  private String snowflakeUrl;

  private final WebClient webClient = WebClient.create();

  public Mono<BigInteger> getSnowflakeId() {
    logger.info("Snowflake base url is: {}", snowflakeUrl);
    return webClient.get()
      .uri(snowflakeUrl + "/snowflake")
      .retrieve()
      .bodyToMono(BigInteger.class);
  }

}
