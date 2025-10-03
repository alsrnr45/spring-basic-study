package org.basic.member.service;

import org.basic.member.Member;
import org.basic.member.repository.MemberRepository;
import org.basic.member.repository.MemberRepositoryImpl;

import java.util.List;

public class MemberServiceImpl implements  MemberService {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member join(Member member) {
        return memberRepository.save(member);
    }
}
