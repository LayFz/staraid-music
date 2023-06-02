package com.staraid.music.core.exception;

import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;

import static com.staraid.music.core.consts.ProjectConstants.PROJECT_MODULE_NAME;

/**
 * 业务异常
 *
 * @author mine
 * @since 2023-06-02 22:58:38
 */
public class BusinessException extends ServiceException {

    public BusinessException(AbstractExceptionEnum exception, String userTip) {
        super(PROJECT_MODULE_NAME, exception.getErrorCode(), userTip);
    }

    public BusinessException(AbstractExceptionEnum exception) {
        super(PROJECT_MODULE_NAME, exception);
    }

}
