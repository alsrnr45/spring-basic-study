package org.basic.member.service;

import lombok.RequiredArgsConstructor;
import org.basic.member.Member;
import org.basic.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService {

    private final MemberRepository memberRepository;

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
