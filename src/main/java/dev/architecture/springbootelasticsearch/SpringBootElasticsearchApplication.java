package dev.architecture.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        //log.info("\n------------ Starting Spring Boot Elasticsearch Application ------------");
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }

}
