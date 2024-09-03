package com.bupt.bnuser.model.dto;

import lombok.Data;

@Data
public class LoginModelDTO {
    private String username;
    private String password;
    private Boolean rememberMe;
}
