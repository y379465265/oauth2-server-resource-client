package com.izejin.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izejin.exception.SysException;
import com.izejin.exception.code.SysExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 描述： Json工具类
 * <p>
 * 创建时间：2019/5/22 20:41
 * 修改时间：
 *
 */
public final class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
    }

    private enum ObjectMapperHolder {
        /**
         * 单例
         */
        INSTANCE;

        private ObjectMapper objectMapper;

        ObjectMapperHolder() {
            //json转换器
            this.objectMapper = new ObjectMapper();
            //不序列化null字段
            this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //反序列化，未知字段不报错
            this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        public ObjectMapper getObjectMapper() {
            return objectMapper;
        }
    }

    /**
     * json转object
     *
     * @param json  json字符串
     * @param clazz 转换类型的Class对象
     * @param <T>   转换类型
     * @return java对象
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T obj = null;
        try {
            obj = ObjectMapperHolder.INSTANCE.getObjectMapper().readValue(json, clazz);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new SysException(SysExceptionCode.JSON_TO_OBJECT_ERROR, "JSON转换对象异常");
        }
        return obj;
    }

    /**
     * json转object
     *
     * @param json          json字符串
     * @param typeReference 转换类型的TypeReference对象
     * @param <T>           转换类型
     * @return java对象
     */
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        T obj = null;
        try {
            obj = ObjectMapperHolder.INSTANCE.getObjectMapper().readValue(json, typeReference);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new SysException(SysExceptionCode.JSON_TO_OBJECT_ERROR, "JSON转换对象异常");
        }
        return obj;
    }

    /**
     * json转object
     *
     * @param json     json字符串
     * @param javaType 转换类型的JavaType对象
     * @param <T>      转换类型
     * @return java对象
     */
    public static <T> T jsonToObject(String json, JavaType javaType) {
        T obj = null;
        try {
            obj = ObjectMapperHolder.INSTANCE.getObjectMapper().readValue(json, javaType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new SysException(SysExceptionCode.JSON_TO_OBJECT_ERROR, "JSON转换对象异常");
        }
        return obj;
    }

    /**
     * object转json
     *
     * @param object java对象
     * @return json字符串
     */
    public static String objectToJson(Object object) {
        String result = null;
        try {
            result = ObjectMapperHolder.INSTANCE.getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            throw new SysException(SysExceptionCode.OBJECT_TO_JSON_ERROR, "对象转换JSON异常");
        }
        return result;
    }

    /**
     * object转json
     *
     * @param object java对象
     * @return json字符串
     */
    public static String objectToJsonPretty(Object object) {
        String result = null;
        try {
            result = ObjectMapperHolder.INSTANCE.getObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            throw new SysException(SysExceptionCode.OBJECT_TO_JSON_ERROR, "对象转换JSON异常");
        }
        return result;
    }
}
