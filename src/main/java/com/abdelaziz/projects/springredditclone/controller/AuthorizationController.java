package com.abdelaziz.projects.springredditclone.controller;


import com.abdelaziz.projects.springredditclone.dto.RegisterRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    @PostMapping("/signup")
    public void signup(@RequestBody RegisterRequestDto registerRequestDto) {

    }
}
