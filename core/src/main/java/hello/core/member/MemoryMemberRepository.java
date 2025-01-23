package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 메모리 회원 저장소 구현체
// 데이터베이스가 아직 확정이 되지 않았다. 개발을 진행해야 하니, 가장 단순한, 메모리 회원 저장소를 구현해서 우선적으로 개발 진행
public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        System.out.println("Saving Member: " + member); // 저장되는 데이터 확인
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
