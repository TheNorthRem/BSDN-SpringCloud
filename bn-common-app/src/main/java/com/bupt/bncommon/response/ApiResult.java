package com.bupt.bncommon.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/9 下午7:18
 */
@Getter
@Setter
public class ApiResult <T>{
    private Integer status;
    private String message;
    private T data;

    public ApiResult() {
        this.status = 200;
    }

    public ApiResult(T data) {
        this.status = 200;
        this.data = data;
    }

    public ApiResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
