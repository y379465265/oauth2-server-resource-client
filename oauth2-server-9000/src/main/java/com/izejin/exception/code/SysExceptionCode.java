package com.izejin.exception.code;

/**
 * 描述：
 * <p>系统类型异常码，必须为6位数字，以5开头</p>
 * <p>返回到前端时，会除以1000</p>
 * 创建时间：2020/01/06 17:33
 * 修改时间：
 *
 * @author liuxl
 */
public enum SysExceptionCode implements BaseExceptionCode{

    /**
     * 数据库错误
     */
    DB_ERROR(500000),
    /**
     * 验证码生成错误
     */
    CAPTCHA_GENERATE_ERROR(500001),
    /**
     * 对象转换json错误
     */
    OBJECT_TO_JSON_ERROR(500002),
    /**
     * json转换对象错误
     */
    JSON_TO_OBJECT_ERROR(500003),
    /**
     * 消息发送类型不存在
     */
    MESSAGE_SEND_TYPE_NOT_FOUND(500004),
    /**
     * 邮件发送失败
     */
    EMAIL_SEND_FAIL(500005),
    /**
     * 不支持的短信发送渠道
     */
    MESSAGE_SEND_CHANNEL_NOT_SUPPORT(500006),
    /**
     * 短信发送失败
     */
    SHORT_MESSAGE_SEND_FAIL(500007),
    /**
     * 参数错误
     */
    PARAMS_ERROR(500008),
    /**
     * SFTP错误
     */
    SFTP_ERROR(500009),
    /**
     * OSS错误
     */
    OSS_ERROR(500010),
    /**
     * 安心签错误
     */
    ANXINSIGN_ERROR(500011),
    /**
     * 安心签请求签名错误
     */
    ANXINSIGN_REQ_SIGN_ERROR(500012),
    /**
     * 创建临时文件错误
     */
    CREATE_TEMP_FILE_ERROR(500013),
    /**
     * http错误
     */
    HTTP_ERROR(500014),
    /**
     * 系统参数未配置
     */
    SYS_PARAM_EMPTY_ERROR(500015),
    /**
     * 状态机参数错误
     */
    STATE_MACHINE_PARAM_ERROR(500016),
    /**
     * 状态机错误
     */
    STATE_MACHINE_ERROR(500017),
    /**
     * 锁异常
     */
    LOCK_ERROR(500018);
    private int code;

    SysExceptionCode(int code){
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
