package com.bupt.bncommon.handler;

import com.bupt.bncommon.exceptions.ApiRuntimeException;
import com.bupt.bncommon.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/9 下午7:14
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    // 异常处理方法：
    // 根据特定的异常返回指定的 HTTP 状态码
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(ApiRuntimeException.class)
    @ResponseBody
    public ApiResult handleValidationException(ApiRuntimeException ex) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(ex.getCode());
        apiResult.setMessage(ex.getMessage());
        return apiResult;
    }

    // 通用异常的处理，返回500
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception ex) {
        return new ApiResult(500,"系统异常");
    }

}
