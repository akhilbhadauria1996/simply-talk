package com.akhil.simply_talk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RegisterUserResponse {
    public UUID id;
    public String userName;
    public String email;
}
