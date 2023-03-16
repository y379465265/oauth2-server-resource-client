package com.izejin.exception;


import com.izejin.exception.code.BizExceptionCode;

/**
 * 描述：
 * <p>业务类型异常</p>
 * 创建时间：2019/12/30 17:23
 * 修改时间：
 *
 * @author liuxl
 */
public class BizException extends BaseException {
    private static final long serialVersionUID = 5769440760694861536L;

    public BizException(BizExceptionCode code, String msg) {
        super(code, msg);
    }

    public BizException(BizExceptionCode code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
