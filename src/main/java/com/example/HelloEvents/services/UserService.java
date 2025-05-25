package com.example.HelloEvents.services;

import com.example.HelloEvents.dto.UserDto;
import com.example.HelloEvents.entities.User;
import com.example.HelloEvents.mapper.UserMapper;
import com.example.HelloEvents.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto SaveUser(UserDto userDto){
        return userMapper.toUserDto(userRepository.save(userMapper.toUserEntity(userDto)));
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream()
                .map(client -> userMapper.toUserDto(client)).toList();
    }

    public UserDto getUserByid(Long id){
        return userRepository.findById(id)
                .map(client -> userMapper.toUserDto(client))
                .orElseThrow(()-> new RuntimeException("Client not found"));
    }

    public UserDto modifierUser(Long id , UserDto userDto){
        User user= userRepository.findById(id).get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());

            return userMapper.toUserDto(userRepository.save(user));
    }

    public void deleteUser(Long id){
         userRepository.deleteById(id);
    }
}
