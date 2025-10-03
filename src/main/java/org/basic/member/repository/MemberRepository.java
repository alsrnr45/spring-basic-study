package org.basic.member.repository;

import org.basic.member.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findById(String id);
    Member save(Member member);
}
