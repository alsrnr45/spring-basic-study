package org.basic.member.service;

import org.basic.member.Member;
import org.basic.member.repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements  MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
