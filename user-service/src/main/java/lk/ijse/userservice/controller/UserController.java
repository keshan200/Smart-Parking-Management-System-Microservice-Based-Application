package lk.ijse.userservice.controller;


import jakarta.validation.Valid;
import lk.ijse.userservice.dto.AuthDTO;
import lk.ijse.userservice.dto.ResponseDTO;
import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.JwtUtil;
import lk.ijse.userservice.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {


        try {
            int res = userService.saveUser(userDTO);

            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    String refreshToken = jwtUtil.generateRefreshToken(userDTO);


                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    authDTO.setRefreshToken(refreshToken);

                    System.out.println("Refresh Token: " + refreshToken);


                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", authDTO));

                }

                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }

                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Error", null));
        }

    }

}
