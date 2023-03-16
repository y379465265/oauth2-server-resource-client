package com.izejin.exception.code;

/**
 * 描述：
 * <p>业务类型异常码，必须为6位数字，以4开头</p>
 * <p>返回到前端时，会除以1000，具体的返回码参考</p>
 * 创建时间：2020/01/06 17:33
 * 修改时间：
 *
 * @author liuxl
 */
public enum BizExceptionCode implements BaseExceptionCode {
    /**
     * 用户错误
     */
    USER_ERROR(400000),
    /**
     * 用户验证码错误
     */
    USER_CAPTCHA_ERROR(400001),
    /**
     * 用户IP锁定
     */
    USER_IP_LOCK(400002),
    /**
     * 用户错误次数达到阈值
     */
    USER_ERROR_COUNT_ERROR(400003),
    /**
     * 用户IP错误
     */
    USER_IP_ERROR(400004),
    /**
     * 用户状态错误
     */
    USER_STATE_ERROR(400005),
    /**
     * 用户手机验证码错误
     */
    USER_MOBILE_CAPTCHA_ERROR(400006),
    /**
     * 用户登录随机码错误
     */
    USER_LOGIN_RANDOM_ERROR(400007),
    /**
     * 用户密码解密错误
     */
    USER_PWD_DECRYPT_ERROR(400008),
    /**
     * 参数错误
     */
    PARAM_ERROR(400010),
    /**
     * excel导出错误
     */
    EXCEL_EXPORT_ERROR(400020),
    /**
     * excel读取错误
     */
    EXCEL_READ_ERROR(400021),
    /**
     * 文件操作错误
     */
    FILE_ERROR(400030),
    /**
     * 图片格式错误
     */
    PIC_FORMAT_ERROR(400031),

    /**
     * 短信模板不存在
     */
    MESSAGE_TEMPLATE_NOT_FOUND(400040),

    /**
     * 消息中参数缺失
     */
    MESSAGE_TEMPLATE_PARAMS_LOSE(400041),

    /**
     * 短信发送频繁
     */
    MESSAGE_SENT_TOO_MANY(400042),

    /**
     * 导入异常
     */
    IMPORT_ERROR(400050),
    /**
     * 数据异常
     */
    DATA_ERROR(400051),

    /**
     * 数据库操作异常
     */
    DEAL_ERROR(400052),

    /**
     * 数据库异常
     */
    DATABASE_ERROR(400053),

    /**
     * 企业错误
     */
    ENT_ERROR(400060),

    /**
     * 业务数据异常
     */
    BUSINESS_ERROR(400300),

    /**
     * 签章企业错误
     */
    SEAL_ENT_ERROR(400061),

    /**
     * 签章证件类型错误
     */
    SEAL_IDENTITY_TYPE_ERROR(400062),

    /**
     * 签章未开通错误
     */
    SEAL_NOT_OPEN_ERROR(400063),

    /**
     * 签章未绑定错误
     */
    SEAL_NOT_BIND_ERROR(400064),

    /**
     * 签章短信发送频繁
     */
    SEAL_MSG_SEND_TO_MANY(400065),

    /**
     * 签章项目编号错误
     */
    SEAL_PROJECT_CODE_ERROR(400066),

    /**
     * 签章协议错误
     */
    SEAL_PROTOCOL_ERROR(400067),

    /**
     * 签章生成合同错误
     */
    SEAL_GENERATE_CONTRACT_ERROR(400068),

    /**
     * 签章响应报文包含错误
     */
    SEAL_RESPONSE_ERROR(400069),
    /**
     * 企业名已被使用
     */
    ENT_NAME_EXIT(400070),
    /**
     * 用户名已被使用
     */
    USER_LOGIN_NAME_EXIT(400071),
    /**
     * 企业编码序号已被锁
     */
    ENT_CODE_LOCKED(400072),
    /**
     * 票据已到期
     */
    BILL_EXPIRE_ERROR(400073),
    /**
     * 票据查询为空
     */
    BILL_NULL_ERROR(400074),
    /**
     * 银行错误
     */
    BANK_ERROR(400075),

    /**
     * 凭证错误
     */
    VOUCHER_ERROR(400080),

    /**
     * 用户权限错误
     */
    AUTH_ERROR(401000);

    private int code;

    BizExceptionCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
