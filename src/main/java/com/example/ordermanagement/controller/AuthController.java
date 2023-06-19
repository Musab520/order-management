package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.CustomUserDetails;
import com.example.ordermanagement.dto.UserDto;
import com.example.ordermanagement.service.UserService;
import com.example.ordermanagement.dto.UserInsertDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ordermanagement.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody @Valid UserInsertDto userInsertDto) {
        UserDto newUser = userService.insert(userInsertDto);
        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDto userDto) {
        UserDto userFound = userService.getByUsername(userDto);
        CustomUserDetails customUserDetails = new CustomUserDetails(userDto.getUsername(), userDto.getPassword());
        if (userFound != null) {
            return new ResponseEntity<>("Authentication Successful: " + jwtUtil.generateToken(customUserDetails), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("User not Found or Access Denied, Incorrect Credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
