package org.basic.policy;

import org.basic.member.Grade;
import org.basic.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatePolicyDiscountTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o(){
        //given
        Member member = new Member("alsrnr", "mg", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x(){
        //given
        Member member = new Member("alsrnr", "mg", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isZero();
    }
}
