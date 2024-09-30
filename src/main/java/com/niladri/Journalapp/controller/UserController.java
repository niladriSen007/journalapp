package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        UserModel user = userService.addUser(userModel);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<UserModel> getUserByName(@PathVariable String name) {
        Optional<UserModel> user = userService.getUserByName(name);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable ObjectId id, @RequestBody UserModel userModel) {
        UserModel user = userService.updateUser(id, userModel);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
