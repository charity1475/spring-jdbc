package com.megasoft.springjdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SpringJdbcApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	private static final Logger logger = Logger.getLogger(SpringJdbcApplicationTests.class.getName());

	@Test
	void contextLoads() {
	}

	/**
	 * @apiNote Should return a list of customers
	 */
	@Test
	void shouldReturnAListOfCustomers() {
		ResponseEntity<String> getResponse = restTemplate.getForEntity("/api/1.0.0/customers?page=0&size=1", String.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
