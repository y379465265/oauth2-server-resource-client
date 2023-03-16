package com.izejin.exception;


import com.izejin.exception.code.BaseExceptionCode;

/**
 * 描述：
 * <p>基础异常</p>
 * 创建时间：2019/12/30 17:22
 * 修改时间：
 *
 * @author liuxl
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1163807767785798049L;

    private BaseExceptionCode code;

    public BaseException(BaseExceptionCode code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(BaseExceptionCode code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public BaseExceptionCode getCode() {
        return code;
    }

    public void setCode(BaseExceptionCode code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code=" + code +
                "} " + super.toString();
    }
}
