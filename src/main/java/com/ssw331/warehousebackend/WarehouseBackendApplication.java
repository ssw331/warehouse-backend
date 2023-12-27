package com.ssw331.warehousebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssw331.warehousebackend.mapper")
public class WarehouseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseBackendApplication.class, args);
	}

}
