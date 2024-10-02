package com.niladri.Journalapp.service.user;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.UserRepository;
import com.niladri.Journalapp.service.user.userInterface.UserInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserInterface {

    private UserRepository userRepository;

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserModel addUser(UserModel userModel) {
        userModel.setUsername(userModel.getUsername());
        userModel.setPassword((passwordEncoder.encode(userModel.getPassword())));
        userModel.setRoles(List.of("USER"));
        log.debug("User added successfully");
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserByName(String name) {
        UserModel user = userRepository.findByUsername(name);
        return user;
    }

    @Override
    public UserModel createNewAdmin(UserModel userDetails) {
        userDetails.setUsername(userDetails.getUsername());
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setRoles(List.of("ADMIN","USER"));
        return userRepository.save(userDetails);
    }

    @Override
    public UserModel updateUser(String name, UserModel userModel) {
//        Optional<UserModel> user = userRepository.findByUsername(name);
//        if (user.isPresent()) {
//            UserModel user1 = user.get();
//            user1.setUsername(userModel.getUsername());
//            user1.setPassword(userModel.getPassword());
//            return userRepository.save(user1);
//        } else throw new RuntimeException("User not found");


        UserModel user = userRepository.findByUsername(name);
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        return addUser(user);
    }

    public UserModel deleteUser(String username) {
        return userRepository.deleteByUsername(username);
    }


}
