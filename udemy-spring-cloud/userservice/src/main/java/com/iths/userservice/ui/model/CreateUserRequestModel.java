package com.iths.userservice.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateUserRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "Fitstname must not lessthan 2 char")
    private String firstName;

    @NotNull(message = "Lasname cannot be null")
    @Size(min = 2, message = "Fitstname must not lessthan 2 char")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be eautl or grater than 8 char and less than 16 char")
    private String password;

    private String userId;
}
