package org.example.userservice.controller;

import org.example.userservice.dto.ResponseDTO;
import org.example.userservice.dto.UserDTO;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.registerUser(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }

    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserDTO userDTO) {
        UserDTO userdto = userService.loginUser(userDTO);
        if (userdto != null) {
            return ResponseEntity.ok(new ResponseDTO("success", userdto));
        } else {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", "Invalid username or password"));
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
