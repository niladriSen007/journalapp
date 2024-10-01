package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;



    @GetMapping("/get")
    public ResponseEntity<UserModel> getUserByName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserModel user = userService.getUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel> updateUser( @RequestBody UserModel userModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserModel user = userService.updateUser(name, userModel);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<UserModel> deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserModel user = userService.deleteUser(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
