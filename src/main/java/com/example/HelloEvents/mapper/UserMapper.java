package com.example.HelloEvents.mapper;


import com.example.HelloEvents.dto.UserDto;
import com.example.HelloEvents.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);

}
