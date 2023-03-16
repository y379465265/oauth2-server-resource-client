package com.izejin.exception;


import com.izejin.exception.code.SysExceptionCode;

/**
 * 描述：
 * <p>系统异常</p>
 * <p>跟服务器环境、配置相关的异常</p>
 * 创建时间：2019/12/30 17:22
 * 修改时间：
 *
 * @author liuxl
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = 3074595734101593397L;

    public SysException(SysExceptionCode code, String msg) {
        super(code, msg);
    }

    public SysException(SysExceptionCode code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
