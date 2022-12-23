package com.ComputerEngineeringDesign.Thesis.user.services.concretes;

import com.ComputerEngineeringDesign.Thesis.generic.exceptions.BusinessException;
import com.ComputerEngineeringDesign.Thesis.generic.exceptions.ItemNotFoundException;
import com.ComputerEngineeringDesign.Thesis.user.converters.UserMapper;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserResponseDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import com.ComputerEngineeringDesign.Thesis.user.enums.UserErrorMessage;
import com.ComputerEngineeringDesign.Thesis.user.repositories.UserDao;
import com.ComputerEngineeringDesign.Thesis.user.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList =  userDao.findAll();
        List<UserResponseDto> userResponseDtoList =  UserMapper.INSTANCE.mapUserListToUserResponseDtoList(userList);
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto getOneUser(Long id) {
        if(!checkIfUserExist(id)){
            throw new ItemNotFoundException(UserErrorMessage.USER_DOES_NOT_EXIST);
        }
        User user = userDao.getReferenceById(id);
        UserResponseDto userResponseDto = UserMapper.INSTANCE.mapUserToUserResponseDto(user);

        return userResponseDto;
    }

    @Override
    public UserResponseDto createOneUser(UserSaveRequestDto userSaveRequestDto) {
        if(checkIfUserExistWithSameValues(userSaveRequestDto)){
            throw new BusinessException(UserErrorMessage.USER_ALREADY_EXIST);
        }

        User user = UserMapper.INSTANCE.mapUserSaveRequestDtoToUser(userSaveRequestDto);
        userDao.save(user);
        UserResponseDto userResponseDto = UserMapper.INSTANCE.mapUserToUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateOneUser(Long id, UserUpdateRequestDto userUpdateRequestDto) {
        if(id == null){
            // throw
        }
        if(!checkIfUserExist(id)){
            // throw
        }
        if(id != userUpdateRequestDto.getId()){
            // throw
        }
        User user = UserMapper.INSTANCE.mapUserUpdateRequestDtoToUser(userUpdateRequestDto);
        user = userDao.save(user);
        UserResponseDto userResponseDto = UserMapper.INSTANCE.mapUserToUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public void deleteOneUser(Long id) {
        if(!checkIfUserExist(id)){
            //throw
        }
        userDao.deleteById(id);
    }
    boolean checkIfUserExist(Long id){
        Optional<User> userToCheck = userDao.findById(id);
        if(userToCheck.isPresent()) return true;
        return false;
    }
    boolean checkIfUserExistWithSameValues(UserSaveRequestDto userSaveRequestDto){
        Optional<User> userToCheck = userDao.
                                            findUserByUserFirstNameAndUserLastNameAndUserEmailAndUserPassword(
                                                    userSaveRequestDto.getUserFirstName(),
                                                    userSaveRequestDto.getUserLastName(),
                                                    userSaveRequestDto.getUserEmail(),
                                                    userSaveRequestDto.getUserPassword()
                                                    );
        if(userToCheck.isPresent()){
            return true;
        }
        return false;
    }
}
