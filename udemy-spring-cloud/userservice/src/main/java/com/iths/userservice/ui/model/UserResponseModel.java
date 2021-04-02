package com.iths.userservice.ui.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
    private String firstName;
    private String lastName;
    private String email;
    private List<AlbumResponseModel> albums;
}
