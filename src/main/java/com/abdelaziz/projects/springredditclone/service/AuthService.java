package com.abdelaziz.projects.springredditclone.service;

import com.abdelaziz.projects.springredditclone.dto.RegisterRequestDto;
import com.abdelaziz.projects.springredditclone.model.User;
import com.abdelaziz.projects.springredditclone.model.VerificationToken;
import com.abdelaziz.projects.springredditclone.repository.UserRepository;
import com.abdelaziz.projects.springredditclone.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final VerificationTokenRepository verificationTokenRepo;


    @Transactional
    public void signup(@RequestBody RegisterRequestDto registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setCreatedOn(Instant.now());
        user.setEnabled(false);

        User savedUser = userRepo.save(user);

        String token = generateVerificationToken(savedUser);
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepo.save(verificationToken);

        return token;
    }
}
