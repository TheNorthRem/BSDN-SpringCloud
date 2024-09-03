package com.bupt.bnuser.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {

    FROZEN(1,"冻结"),
    NORMAL(0,"正常");

    private Integer code;
    private String state;

    UserStatusEnum(Integer code,String state){
        this.code=code;
        this.state=state;
    }

}
