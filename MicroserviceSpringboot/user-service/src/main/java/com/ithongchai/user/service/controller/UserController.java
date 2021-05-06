package com.ithongchai.user.service.controller;

import com.ithongchai.user.service.VO.ResponseTemplateVO;
import com.ithongchai.user.service.entity.User;
import com.ithongchai.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User create(@RequestBody User user){
        log.info("Inside create method of UserController");
        return  userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(id);
    }
}
