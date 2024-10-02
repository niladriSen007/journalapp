package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.cache.AppCache;
import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {
	private UserService userService;

	private AppCache appCache;

	@GetMapping("/getallusers")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/addnewadmin")
	public ResponseEntity<UserModel> addNewAdmin(@RequestBody UserModel userDetails) {
		return new ResponseEntity<>(userService.createNewAdmin(userDetails), HttpStatus.OK);
	}

	@GetMapping("/clearcache")
	public ResponseEntity<String> clearAppCache() {
		appCache.initialize();
		return new ResponseEntity<>("App Cache Cleared", HttpStatus.OK);
	}
}
