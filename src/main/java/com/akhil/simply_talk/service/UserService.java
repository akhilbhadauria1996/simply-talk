package com.akhil.simply_talk.service;

import com.akhil.simply_talk.dto.RegisterUserRequest;
import com.akhil.simply_talk.dto.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public RegisterUserResponse registerUser(RegisterUserRequest request) ;

}
