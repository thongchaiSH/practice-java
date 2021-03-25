package com.its.app.ws.mobile.ui.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.its.app.ws.mobile.exceptions.UserServiceException;
import com.its.app.ws.mobile.ui.model.request.UpdateUserDetailsModel;
import com.its.app.ws.mobile.ui.model.request.UserDetailsRequestModel;
import com.its.app.ws.mobile.ui.model.response.UserRest;
import com.its.app.ws.mobile.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    Map<String, UserRest> users = new HashMap<>();

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
            @RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {
        return "get user was called with page = " + page + " and limit = " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        // if (true) {
        // throw new UserServiceException("A User service exception is thrown");
        // }

        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }

    }

    // Create
    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    // Update
    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
            @Valid @RequestBody UpdateUserDetailsModel userDetails) {
        // return "update user was called";
        if (users.containsKey(userId)) {
            UserRest user = users.get(userId);
            user = user.toBuilder().firstName(userDetails.getFirstName()).lastName(userDetails.getLastName()).build();
            users.put(userId, user);
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
        }

    }

    // Delete
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
