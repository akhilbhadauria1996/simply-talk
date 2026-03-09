package com.akhil.simply_talk.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

}