package lk.ijse.userservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lk.ijse.userservice.enums.Status;
import lk.ijse.userservice.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

     private UUID uid;


     @NotBlank(message = "Email is required")
     private  String email;

     @NotBlank(message = "password is required")
     private  String password;

     @NotBlank(message = "username is required")
     private  String username;

     @NotNull(message = "Mobile number is required")
     private  String phoneNumber;

     @NotNull(message = "role must be required")
     @Pattern(regexp = "^(CUSTOMER|ADMIN)$", message = "Role must be either EMPLOYER or CANDIDATE")
     private String role;

     private Status status;

}




