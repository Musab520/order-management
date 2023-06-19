package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.UserDto;
import com.example.ordermanagement.dto.UserInsertDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    public UserDto getById(String id);
    public UserDto getByEmail(UserDto userDto);
    public UserDto getByUsername(UserDto userDto);
    public UserDto insert(UserInsertDto userInsertDto);
    public UserDetails loadUserByUsername(String username);
}
