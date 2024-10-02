package com.niladri.Journalapp.service;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.UserRepository;
import com.niladri.Journalapp.service.user.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class UserDetailsServiceTests {

	@InjectMocks
	private UserDetailsServiceImpl userDetailsService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setupDependencies() {
		//By using this line all the dependencies will be initialized and will be injected to the class automatically
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void loadUserByUsernameTests() {
		when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(UserModel.builder().username("Nil").password("password").roles(new ArrayList<>()).build());
		UserDetails userDetails = userDetailsService.loadUserByUsername("Nil");
		Assertions.assertNotNull(userDetails);
	}
}
