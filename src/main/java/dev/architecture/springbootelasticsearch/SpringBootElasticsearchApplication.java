package dev.architecture.springbootelasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        log.info("---- Starting Spring Boot Elasticsearch Application ----");
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }

}
