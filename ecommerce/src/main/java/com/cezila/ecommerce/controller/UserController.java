package com.cezila.ecommerce.controller;

import com.cezila.ecommerce.dto.UserDTO;
import com.cezila.ecommerce.dto.UserResponse;
import com.cezila.ecommerce.mapper.UserMapper;
import com.cezila.ecommerce.model.UserEntity;
import com.cezila.ecommerce.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    UserEntity createUser(@RequestBody UserDTO userDTO) {
        return repository.save(UserMapper.toModel(userDTO));
    }

    @GetMapping
    List<UserResponse> getAllUsers() {
        List<UserResponse> response = new ArrayList<>();
        List<UserEntity> userEntities = repository.findAll();

        userEntities.forEach(userEntity -> response.add(modelMapper.map(userEntity, UserResponse.class)));

        return response;
    }

}
