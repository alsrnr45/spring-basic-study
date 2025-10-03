package org.basic.policy;

import org.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
