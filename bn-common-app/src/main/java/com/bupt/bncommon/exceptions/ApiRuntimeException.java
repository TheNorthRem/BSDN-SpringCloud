package com.bupt.bncommon.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/9 下午5:49
 */
@Getter
@Setter
public class ApiRuntimeException extends RuntimeException {
    private final Integer code;
    private final String message;
    public ApiRuntimeException(String message,Integer code ,Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ApiRuntimeException(String message, Integer code) {
        this.code = code;
        this.message = message;
    }
}
