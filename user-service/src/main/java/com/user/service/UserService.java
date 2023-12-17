package com.user.service;

import com.user.entity.UserEntity;
import com.user.enums.Status;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity userEntity);

    UserEntity getUserById(Long id);

    List<UserEntity> getUserByName(String name);

    Status updateUserDetails(Long id, UserEntity userEntity);

    Status deleteUserDetails(Long id);


}
