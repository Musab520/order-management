package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.CustomUserDetails;
import com.example.ordermanagement.dto.UserDto;
import com.example.ordermanagement.dto.UserInsertDto;
import com.example.ordermanagement.entity.Users;
import com.example.ordermanagement.repository.UserRepository;
import com.example.ordermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto getById(String id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDto getByEmail(UserDto userDto) {
        Optional<Users> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDto getByUsername(UserDto userDto) {
        Users user = userRepository.findByUsername(userDto.getUsername());
        if (user != null) {
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDto insert(UserInsertDto userInsertDto) {
        Users user = modelMapper.map(userInsertDto, Users.class);
        Users newUsers = userRepository.save(user);
        return modelMapper.map(newUsers, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Create and return a UserDetails implementation based on your user model
        return new CustomUserDetails(users.getUsername(), users.getPassword());
    }
}