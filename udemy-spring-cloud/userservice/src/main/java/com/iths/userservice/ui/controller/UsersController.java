package com.iths.userservice.ui.controller;

import javax.validation.Valid;

import com.iths.userservice.api.users.service.UsersService;
import com.iths.userservice.api.users.shared.UserDto;
import com.iths.userservice.ui.model.CreateUserRequestModel;
import com.iths.userservice.ui.model.CreateUserResponsesModel;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping("/status/check")
    public String status() {
        return "Working...." + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponsesModel> creazteUser(
            @RequestBody @Valid CreateUserRequestModel userDetails) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto userResponse = usersService.createUser(userDto);

        CreateUserResponsesModel returnValue = modelMapper.map(userResponse, CreateUserResponsesModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
