package hello.core;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    // MemoryMemberRepository를 하나로 관리
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public MemberService memberService() {
        System.out.println("Initializing MemberService with: " + memberRepository); // 확인 로그 추가
        return new MemberServiceImpl(memberRepository);
    }

    public OrderService orderService() {
        System.out.println("Initializing OrderService with: " + memberRepository); // 확인 로그 추가
        return new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
    }

    // DiscountPolicy 구현체 반환
    public DisCountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
