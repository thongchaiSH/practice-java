package com.its.app.ws.mobile.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.its.app.ws.mobile.shared.Utils;
import com.its.app.ws.mobile.ui.model.request.UserDetailsRequestModel;
import com.its.app.ws.mobile.ui.model.response.UserRest;
import com.its.app.ws.mobile.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users = new HashMap<>();

    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = UserRest.builder().firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName()).email(userDetails.getEmail()).build();

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        users.put(userId, returnValue);

        return returnValue;
    }

}
