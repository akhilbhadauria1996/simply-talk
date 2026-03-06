package com.akhil.simply_talk.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {
    public String userName;
    public String email;
    public String password;
}
