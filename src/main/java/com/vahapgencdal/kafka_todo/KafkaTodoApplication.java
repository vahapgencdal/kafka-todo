package com.vahapgencdal.kafka_todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KafkaTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTodoApplication.class, args);
	}

}
