package org.basic.member;

import org.assertj.core.api.Assertions;
import org.basic.common.AppConfig;
import org.basic.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void init(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){

        // given
        Member member = new Member("alsrnr", "mg", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.getMember(member.getId());

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
