package org.basic.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class MyLoggerInterceptor implements HandlerInterceptor {

    private final MyLogger myLogger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        
        // MyLogger 빈을 가져온 뒤, setRequestUrl(uri) 처리
        myLogger.setRequestUrl(uri);

        return true; // 컨트롤러로 요청 진행
    }
}