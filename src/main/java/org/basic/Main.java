package org.basic;

import org.basic.member.Grade;
import org.basic.member.Member;
import org.basic.member.service.MemberService;
import org.basic.member.service.MemberServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         MemberService memberService = new MemberServiceImpl();
         Member member = new Member("alsrnr", "mg", Grade.VIP);
         memberService.join(member);

         Member findMember = memberService.getMember(member.getId());
         System.out.println("id : %s, name : %s , " + findMember.getId() + " " + findMember.getName() + " " + findMember.getGrade());

    }
}