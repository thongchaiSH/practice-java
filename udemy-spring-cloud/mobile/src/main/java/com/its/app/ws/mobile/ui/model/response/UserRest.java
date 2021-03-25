package com.its.app.ws.mobile.ui.model.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
