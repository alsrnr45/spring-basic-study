package org.basic.member.repository;

import org.basic.member.Member;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepositoryImpl implements MemberRepository {

    private static Map<String, Member> memberTb = new ConcurrentHashMap<String, Member>();

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public Member findById(String id) {
        return memberTb.get(id);
    }

    @Override
    public Member save(Member member) {
        return memberTb.put(member.getId(), member);
    }
}
