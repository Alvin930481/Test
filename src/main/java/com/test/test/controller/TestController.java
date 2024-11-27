package com.test.test.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    /**
     * 測試方法
     */
    @GetMapping("/test")
    @Operation(tags = "測試方法")
    public void test(){
        log.info("測試方法執行...");
    }
}
