package com.bupt.bncommon.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.bupt.bncommon.enums.HttpEnums;
import com.bupt.bncommon.exceptions.ApiRuntimeException;

import java.util.Collection;
import java.util.Objects;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/9 下午5:55
 */

public class AssertUtils {
    public static void isTrue(boolean expression, String message, HttpEnums httpStatus) {
        if (!expression) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }

    public static void notNull(Object object, String message, HttpEnums httpStatus) {
        if (object == null) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }

    public static void notBlank(String str, String message, HttpEnums httpStatus) {
        if (StrUtil.isBlank(str)) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }

    public static void notEmpty(Collection<?> collection, String message, HttpEnums httpStatus) {
        if (CollectionUtil.isEmpty(collection)) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }

    public static void isEquals(Object a, Object b, String message, HttpEnums httpStatus) {
        if (!Objects.equals(a, b)) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }

    public static void notEquals(Object a, Object b, String message, HttpEnums httpStatus) {
        if (Objects.equals(a, b)) {
            throw new ApiRuntimeException(message, httpStatus.getCode());
        }
    }
}
