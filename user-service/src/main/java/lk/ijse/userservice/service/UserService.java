package lk.ijse.userservice.service;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    int updateUser(UserDTO userDTO);
    int deleteUser(int id);
    List<User> getAllUsers();
}
