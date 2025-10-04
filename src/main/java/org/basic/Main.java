package org.basic;

import org.basic.common.AppConfig;
import org.basic.member.Grade;
import org.basic.member.Member;
import org.basic.member.service.MemberService;
import org.basic.order.Order;
import org.basic.order.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean(MemberService.class);
        OrderService orderService = context.getBean(OrderService.class);

        Member member = new Member("alsrnr", "mg", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.getMember(member.getId());
        String memberId = findMember.getId();

        Order order = orderService.createOrder(memberId, "computer", 2000);

        System.out.println(String.format("id : %s, name : %s , grade : %s", memberId, member.getName(), member.getGrade()));
        System.out.println(String.format("order : %s", order));

    }
}