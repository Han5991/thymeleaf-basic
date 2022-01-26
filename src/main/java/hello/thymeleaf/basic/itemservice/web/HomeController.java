package hello.thymeleaf.basic.itemservice.web;

import hello.thymeleaf.basic.itemservice.domain.member.Member;
import hello.thymeleaf.basic.itemservice.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    //    @GetMapping("/")
    public String home() {
        return "items/home";
    }

    @GetMapping("/")
    public String loginHome(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null) {
            return "items/home";
        }

        Member id = memberRepository.findById(memberId);
        if (id == null) {
            return "items/home";
        }
        model.addAttribute("member", id);
        return "items/loginHome";
    }
}