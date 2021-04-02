package com.iths.userservice.ui.controller;

import javax.validation.Valid;

import com.iths.userservice.api.users.service.UsersService;
import com.iths.userservice.api.users.shared.UserDto;
import com.iths.userservice.ui.model.CreateUserRequestModel;
import com.iths.userservice.ui.model.CreateUserResponsesModel;

import com.iths.userservice.ui.model.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working...." + env.getProperty("local.server.port") + " Token = " + env.getProperty("token.secret");
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponsesModel> creazteUser(
            @RequestBody @Valid CreateUserRequestModel userDetails) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto userResponse = usersService.createUser(userDto);

        CreateUserResponsesModel returnValue = modelMapper.map(userResponse, CreateUserResponsesModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) {
        UserDto userDto= usersService.getUserByUserId(userId);
        UserResponseModel returnValue = new ModelMapper().map(userDto,UserResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);

    }
}
