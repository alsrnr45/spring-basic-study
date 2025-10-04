package org.basic.common;

import org.basic.member.repository.MemberRepository;
import org.basic.member.repository.MemberRepositoryImpl;
import org.basic.member.service.MemberService;
import org.basic.member.service.MemberServiceImpl;
import org.basic.order.service.OrderService;
import org.basic.order.service.OrderServiceImpl;
import org.basic.policy.DiscountPolicy;
import org.basic.policy.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepositoryImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
