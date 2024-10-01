package com.niladri.Journalapp.controller.publicController;


import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public/user")
@AllArgsConstructor
public class PublicController {

	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
		UserModel user = userService.addUser(userModel);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
