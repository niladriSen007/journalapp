package com.niladri.Journalapp.service.user.userInterface;

import com.niladri.Journalapp.model.UserModel;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    UserModel addUser(UserModel userModel);

    List<UserModel> getAllUsers();


    UserModel updateUser(ObjectId id, UserModel userModel);

    Optional<UserModel> getUserByName(String name);
}
