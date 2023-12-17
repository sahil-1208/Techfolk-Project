package com.user.service;

import com.user.entity.UserEntity;
import com.user.enums.Status;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity savedUser = userRepository.save(userEntity);
        return savedUser;
    }

    @Override
    public UserEntity getUserById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        boolean isAvailable = optionalUserEntity.isPresent();
        if (isAvailable) {
            UserEntity savedUser = optionalUserEntity.get();
            return savedUser;
        }
        return null;
    }

    @Override
    public List<UserEntity> getUserByName(String name) {
        return userRepository.findUserByName(name);
        }


    @Override
    public Status updateUserDetails(Long id, UserEntity userEntity) {
        UserEntity savedUser = getUserById(id);
        if (Objects.nonNull(savedUser)){
            savedUser.setName(userEntity.getName());
            savedUser.setAge(userEntity.getAge());
            savedUser.setAddress(userEntity.getAddress());
            userRepository.save(savedUser);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

    @Override
    public Status deleteUserDetails(Long id) {
        userRepository.deleteById(id);
        return Status.SUCCESS;
    }
}
