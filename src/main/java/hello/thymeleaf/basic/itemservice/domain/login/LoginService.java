package hello.thymeleaf.basic.itemservice.domain.login;

import hello.thymeleaf.basic.itemservice.domain.member.Member;
import hello.thymeleaf.basic.itemservice.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * @param loginId
     * @param password
     * @return null이면 로그인 실패
     */
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

}
