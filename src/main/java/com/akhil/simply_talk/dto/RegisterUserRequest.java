package com.akhil.simply_talk.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {

    @NotBlank(message = "Username cannot be empty")
    public String userName;

    @Email(message = "Invalid email")
    @NotBlank(message = "email cannot be empty")
    public String email;

    @Size(min = 8, max = 15, message = "password must be at least 8 characters")
    @NotBlank(message = "password cannot be empty")
    public String password;
}
