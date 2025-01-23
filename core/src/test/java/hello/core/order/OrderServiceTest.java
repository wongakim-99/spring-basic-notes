package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

        System.out.println("Testing with MemberService: " + memberService);
        System.out.println("Testing with OrderService: " + orderService);

        // 테스트 데이터 저장
        // memberService.join(new Member(1L, "memberA", Grade.VIP));
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //System.out.println("memberRepository: " + memberRepository);
        // System.out.println("Order price: " + order.getPrice());
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
