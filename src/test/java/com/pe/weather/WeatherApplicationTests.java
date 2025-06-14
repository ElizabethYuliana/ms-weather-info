package com.pe.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.cloud.azure.keyvault.secret.property-source-enabled=false")
class WeatherApplicationTests {

	@Test
	void contextLoads() {
	}

}
