package com.ssw331.warehousebackend;

import com.ssw331.warehousebackend.service.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {MovieRepository.class})
@SpringBootTest(classes = WarehouseBackendApplication.class)
class WarehouseBackendApplicationTests {

	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void contextLoads() {
		System.out.println(movieRepository.findById(Integer.valueOf(String.valueOf(90))).get());
	}

}
