package com.its.app.ws.mobile.userservice;

import com.its.app.ws.mobile.ui.model.request.UserDetailsRequestModel;
import com.its.app.ws.mobile.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
