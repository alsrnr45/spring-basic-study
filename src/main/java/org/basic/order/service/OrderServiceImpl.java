package org.basic.order.service;

import org.basic.member.Member;
import org.basic.member.repository.MemberRepository;
import org.basic.member.repository.MemberRepositoryImpl;
import org.basic.order.Order;
import org.basic.order.Product;
import org.basic.policy.DiscountPolicy;
import org.basic.policy.FixDiscountPolicy;

import java.util.HashMap;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
