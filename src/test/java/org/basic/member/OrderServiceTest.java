package org.basic.member;

import org.assertj.core.api.Assertions;
import org.basic.member.service.MemberService;
import org.basic.member.service.MemberServiceImpl;
import org.basic.order.Order;
import org.basic.order.service.OrderService;
import org.basic.order.service.OrderServiceImpl;
import org.basic.policy.DiscountPolicy;
import org.basic.policy.FixDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

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
