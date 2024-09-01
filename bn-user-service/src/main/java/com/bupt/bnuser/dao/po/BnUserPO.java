package com.bupt.bnuser.dao.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户表
 * @TableName bn-user
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("bn-user")
public class BnUserPO {

    private Integer bnUserId;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer status;

}
