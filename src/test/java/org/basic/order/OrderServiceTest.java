package org.basic.order;

import org.assertj.core.api.Assertions;
import org.basic.common.AppConfig;
import org.basic.member.Grade;
import org.basic.member.Member;
import org.basic.member.service.MemberService;
import org.basic.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void init(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        // given
        String memberId = "alsrnr";

        Member member = new Member("alsrnr", "mg", Grade.VIP);
        memberService.join(member);

        // when
        Order newOrder = orderService.createOrder(memberId, "computer", 2000);

        // then
        Assertions.assertThat(newOrder.getDiscountPrice()).isEqualTo(1000);
    }
}
