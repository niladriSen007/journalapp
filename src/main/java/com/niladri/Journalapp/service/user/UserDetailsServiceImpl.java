package com.niladri.Journalapp.service.user;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRoles().toArray(new String[0]))
				.build();
	}
}
