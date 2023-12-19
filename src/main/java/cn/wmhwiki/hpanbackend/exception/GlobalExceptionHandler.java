package cn.wmhwiki.hpanbackend.exception;

import cn.wmhwiki.hpanbackend.common.BaseResponse;
import cn.wmhwiki.hpanbackend.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException e) {
        log.error("BusinessException: {}", e.getDescription());
        return ResultUtils.error(e.getCode(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: {}", e.getMessage());
        return ResultUtils.error("系统异常");
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return ResultUtils.error("系统异常");
    }
}
