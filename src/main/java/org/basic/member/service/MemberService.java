package org.basic.member.service;

import org.basic.member.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();
    Member getMember(String id);
    Member join(Member member);
}
