package com.niladri.Journalapp.service.user.userInterface;

import com.niladri.Journalapp.model.UserModel;

import java.util.List;

public interface UserInterface {
    UserModel addUser(UserModel userModel);

    List<UserModel> getAllUsers();


    UserModel updateUser(String name, UserModel userModel);

    UserModel getUserByName(String name);

	UserModel createNewAdmin(UserModel userDetails);
}
