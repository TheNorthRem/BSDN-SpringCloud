package com.bupt.bnuser.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/9 下午5:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResultBO {
    private Long bnUserId;
    private String username;
    private String nickName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
