package com.bupt.bnuser.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/4 下午2:52
 */
@Data
@Builder
public class LoginResultDTO {
    private Long userId;
    private String token;
    private String username;
    private String nickName;
}
