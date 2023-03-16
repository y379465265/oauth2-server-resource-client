package com.izejin.bean;


import com.izejin.utils.BeanUtil;
import com.izejin.utils.JsonUtil;

import java.io.Serializable;

/**
 * 描述： 基础模型
 * <p>
 * 创建时间：2019/5/30 9:45
 * 修改时间：
 *
 */
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -3178795276890660732L;

    /**
     * 类型转换
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T convert(Class<T> clazz) {
        return BeanUtil.convert(this, clazz);
    }

    /**
     * 转换成json字符串
     * @return
     */
    public String toJsonString() {
        return JsonUtil.objectToJson(this);
    }
}
