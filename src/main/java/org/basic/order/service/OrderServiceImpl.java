package org.basic.order.service;

import org.basic.member.Member;
import org.basic.member.repository.MemberRepository;
import org.basic.order.Order;
import org.basic.policy.DiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(String memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(
                memberId,
                itemName,
                itemPrice,
                discountPrice
        );
    }
}
