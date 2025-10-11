package org.basic.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    @RequestMapping("log-demo")

    public String logDemo(HttpServletRequest request){
        logDemoService.logic("testId");
        return "OK";
    }
}
