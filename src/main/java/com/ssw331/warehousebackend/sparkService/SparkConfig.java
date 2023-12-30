package com.ssw331.warehousebackend.sparkService;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .appName("Spark Application")
                .master("cc3.accr.cc:10000")
                .getOrCreate();
    }
}

