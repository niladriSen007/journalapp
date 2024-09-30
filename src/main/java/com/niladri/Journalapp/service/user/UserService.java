package com.niladri.Journalapp.service.user;

import com.niladri.Journalapp.model.UserModel;
import com.niladri.Journalapp.repository.UserRepository;
import com.niladri.Journalapp.service.user.userInterface.UserInterface;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserInterface {

    private UserRepository userRepository;

    @Override
    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserByName(String name) {
        Optional<UserModel> user = Optional.of(userRepository.findByUsername(name)).orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

    @Override
    public UserModel updateUser(ObjectId id, UserModel userModel) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel user1 = user.get();
            user1.setUsername(userModel.getUsername());
            user1.setPassword(userModel.getPassword());
            return userRepository.save(user1);
        }else throw new RuntimeException("User not found");
    }


}
