package com.ComputerEngineeringDesign.Thesis.user.converters;

import com.ComputerEngineeringDesign.Thesis.user.dtos.UserResponseDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserResponseDto mapUserToUserResponseDto(User user);
    List<UserResponseDto> mapUserListToUserResponseDtoList(List<User> userList);
    User mapUserSaveRequestDtoToUser(UserSaveRequestDto userSaveRequestDto);
    User mapUserUpdateRequestDtoToUser(UserUpdateRequestDto userUpdateRequestDto);
}
