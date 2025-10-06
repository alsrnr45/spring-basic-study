package org.basic.autowired;

import org.basic.common.AutoAppConfig;
import org.basic.member.Grade;
import org.basic.member.Member;
import org.basic.policy.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member("alsrnr", "mgkim", Grade.VIP);
        int fixCount = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixCount).isEqualTo(1000);

        int rateDiscount = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(rateDiscount).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        //@Autowired
        // Autowired 없어도 됨 : 생성자 하나일 경우에는 자동으로 spring에서 찾아주기 때문.
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println(policyMap);
            System.out.println(policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy policy = policyMap.get(discountCode);
            return policy.discount(member, price);
        }
    }
}
