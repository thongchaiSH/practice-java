package com.is.reg.service;

import com.is.reg.model.CustomerRequest;
import com.is.reg.model.base.BaseResponse;

public interface FriendReferralService {
    public BaseResponse searchPolicy(CustomerRequest request) throws Exception;
}
