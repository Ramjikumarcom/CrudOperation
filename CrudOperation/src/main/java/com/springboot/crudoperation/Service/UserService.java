package com.springboot.crudoperation.Service;

import com.springboot.crudoperation.Payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserDto CreateUer(UserDto userDto);
    UserDto updateUser(UserDto userDto,int id);

    UserDto deleteUser(int id);
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
//    UserDto PatchUser(UserDto userDto,int id);

}
