package com.unsa.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CashcardApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void myFirstTest() {
		// Writing my first unit test on Spring Boot
		// Here we are checking some integer values
		assertThat(42).isEqualTo(42);
	}

}
