package com.bupt.bnuser.model.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/4 下午2:52
 */
@Data
@Builder
public class LoginResultBO {
    private Long userId;
    private String username;
    private String nickName;
}
