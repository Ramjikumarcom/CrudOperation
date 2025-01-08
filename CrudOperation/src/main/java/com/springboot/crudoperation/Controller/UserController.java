package com.springboot.crudoperation.Controller;

import com.springboot.crudoperation.Payload.ApiResponse;
import com.springboot.crudoperation.Payload.UserDto;
import com.springboot.crudoperation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> getUser() {
      List< UserDto> userDto= userService.getAllUsers();
      return ResponseEntity.ok(userDto);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto= userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }
    @PostMapping(path = "/post")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
         userDto=userService.CreateUer(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        userDto=userService.updateUser(userDto,id);
//        ResponseEntity.ok(userDto);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Updated Succesfully",true),HttpStatus.OK);

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {
       UserDto userDto= userService.deleteUser(id);
//       ResponseEntity.ok(userDto);
       return  new ResponseEntity<ApiResponse>(new ApiResponse("user deleted Succesfully",true),HttpStatus.OK);
    }
}
