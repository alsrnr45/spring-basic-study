package org.basic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message){
        System.out.println(uuid + " : " + requestUrl + " : " + message);
    }

    @PostConstruct
    public void init(){
        uuid = java.util.UUID.randomUUID().toString();
        System.out.println(uuid + " request bean created " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println(uuid + " request bean closed " + this);
    }

}
