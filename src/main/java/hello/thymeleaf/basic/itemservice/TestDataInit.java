package hello.thymeleaf.basic.itemservice;

import hello.thymeleaf.basic.itemservice.domain.item.Item;
import hello.thymeleaf.basic.itemservice.domain.item.ItemRepository;
import hello.thymeleaf.basic.itemservice.domain.member.Member;
import hello.thymeleaf.basic.itemservice.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
//    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("0");
        member.setPassword("0000");
        member.setName("tester");

        memberRepository.save(member);
    }

}