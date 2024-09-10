package com.bupt.bnuser.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/10 上午11:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BnUserVO {
    private Long bnUserId;
    private String username;
    private String userPhone;
    private String userEmail;
    private String userAvatar;
    private String userGender;
    private String userBirthday;
    private String userAddress;
    private String userStatus;
    private String createTime;
    private String updateTime;
    private Integer userType;
}
