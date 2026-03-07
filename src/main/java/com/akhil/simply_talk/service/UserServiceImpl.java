package com.akhil.simply_talk.service;

import com.akhil.simply_talk.dto.RegisterUserRequest;
import com.akhil.simply_talk.dto.RegisterUserResponse;
import com.akhil.simply_talk.entity.User;
import com.akhil.simply_talk.entity.UserStatus;
import com.akhil.simply_talk.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if(userRepo.existsByUserName(request.getUserName())){
            throw new RuntimeException("Username already exists");
        }
        if(userRepo.existsByEmail(request.getEmail())){
            throw new RuntimeException("email already exists");
        }
        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(UserStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User newUser = userRepo.save(user);

        return new RegisterUserResponse(newUser.getId(), newUser.getUserName(), newUser.getEmail());
    }
}
