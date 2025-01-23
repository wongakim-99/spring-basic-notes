package hello.core.order;

import hello.core.discount.DisCountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;

        System.out.println("memberRepository: " + memberRepository);
        System.out.println("disCountPolicy: " + disCountPolicy);
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        System.out.println("Fetched Member: " + member); // 확인
        int discountPrice = disCountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
