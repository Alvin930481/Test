package com.test.test.filtler;


import com.test.test.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全域異常處理器，處理拋出的異常
 */
@RestControllerAdvice(basePackages="com.test.test.controller")
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕獲服務異常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception ex, HttpServletRequest request) throws Exception {


       String path = request.getRequestURI();

        // 如果是 Swagger 或 OpenAPI 的請求，直接返回原始異常
        if (path.startsWith("/api-docs") || path.contains("/swagger-ui")) {
            log.error("捕捉到swag直接放行");
            throw null; // 不處理，交由 Springdoc 自行處理
        }
        log.error("異常訊息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
}
