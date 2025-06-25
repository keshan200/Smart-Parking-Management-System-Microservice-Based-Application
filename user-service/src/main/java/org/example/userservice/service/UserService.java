package org.example.userservice.service;

import org.example.userservice.dto.ResponseDTO;
import org.example.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    ResponseDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
