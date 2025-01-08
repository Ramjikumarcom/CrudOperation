package com.springboot.crudoperation.Repositiory;

import com.springboot.crudoperation.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {

}
