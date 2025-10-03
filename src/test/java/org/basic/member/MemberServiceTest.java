package org.basic.member;

import com.sun.source.tree.AssertTree;
import org.assertj.core.api.Assertions;
import org.basic.member.service.MemberService;
import org.basic.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

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
