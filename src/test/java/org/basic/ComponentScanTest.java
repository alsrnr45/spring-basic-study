package org.basic;

import org.basic.common.AutoAppConfig;
import org.basic.member.service.MemberService;
import org.basic.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentScanTest {

    @Test
    void basicScan(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = context.getBean(MemberService.class);
        OrderService orderService = context.getBean(OrderService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
