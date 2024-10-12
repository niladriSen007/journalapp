package com.niladri.Journalapp.service;

import com.niladri.Journalapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserRepository userRepository;

	@Disabled
	@Test
	public void testGetUserByName() {
		Assertions.assertNotNull(userRepository.findByUsername("Nil"));
	}

	@ParameterizedTest
	@CsvSource({
			"1,2,3",
			"2,3,5",
			"3,4,7"
	})
	public void parameterizedTest(int a,int b,int expected){
		Assertions.assertEquals(expected,a+b);
	}
}
