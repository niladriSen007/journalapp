package com.niladri.Journalapp.controller;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.response.WeatherApiResponse;
import com.niladri.Journalapp.service.WeatherService;
import com.niladri.Journalapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    private WeatherService weatherService;


    @GetMapping("/get")
    public ResponseEntity<UserModel> getUserByName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserModel user = userService.getUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get-weather")
    public ResponseEntity<?> getWeather() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherApiResponse weather = weatherService.getWeather("Kolkata");
        return new ResponseEntity<>("Hi "+ authentication.getName()+ " current temperature is " + weather.getCurrent().getFeelslike() +"^ c", HttpStatus.OK);
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
