package com.techtrek.customerservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Autowired
	private CustomerServiceApplication customerServiceApplication;

	@Test
	void contextLoads() {
		assertNotNull(customerServiceApplication);
	}

	@Test
	void applicationContextTest(){
		assertDoesNotThrow(() -> CustomerServiceApplication.main(new String[]{}));
	}

}
