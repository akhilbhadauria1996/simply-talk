package com.akhil.simply_talk.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

}