package com.iths.userservice.api.users.service;

import com.iths.userservice.api.users.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
