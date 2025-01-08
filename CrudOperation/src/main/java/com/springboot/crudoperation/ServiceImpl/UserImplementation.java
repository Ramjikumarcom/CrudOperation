package com.springboot.crudoperation.ServiceImpl;

import com.springboot.crudoperation.Entities.User;
import com.springboot.crudoperation.ExceptionHandler.ResourceNotfounException;
import com.springboot.crudoperation.Payload.UserDto;
import com.springboot.crudoperation.Repositiory.UserRepository;
import com.springboot.crudoperation.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImplementation implements UserService {
  @Autowired
   private UserRepository userRepository;
  @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto CreateUer(UserDto userDto) {
        User user=modelMapper.map(userDto, User.class);
         userRepository.save(user);
         userDto=modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotfounException("user id","User",id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAbout(userDto.getAbout());
        user.setAddress(userDto.getAddress());

       userRepository.save(user);
    userDto=modelMapper.map(user, UserDto.class);

       return  userDto;
    }

    @Override
    public UserDto deleteUser(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotfounException("user id", "User", id));
        userRepository.delete(user);

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return userDtos;
    }


    @Override
    public UserDto getUserById(int id) {
        User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotfounException("user id","Not Found",id));
        UserDto userDto=modelMapper.map(user, UserDto.class);

        return userDto;
    }

//    @Override
//    public UserDto PatchUser(UserDto userDto, int id) {
//        User user=userRepository.findById(id).orElse(null);
//        user=modelMapper.map(userDto, User.class);
//        userRepository.save(user);
//        userDto=modelMapper.map(user, UserDto.class);
//        return userDto;
//    }
}
