package hello.thymeleaf.basic.itemservice.exception.api;

import hello.thymeleaf.basic.itemservice.exception.execption.UserException;
import hello.thymeleaf.basic.itemservice.exception.exhandler.ErrorResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api2")
public class ApiExceptionControllerV2 {


    @GetMapping("/members/{id}")
    public ApiExceptionController.MemberDto getMember(@PathVariable String id) {
        switch (id) {
            case "ex":
                throw new RuntimeException("잘 못 된 사용자");
            case "bad":
                throw new IllegalArgumentException("잘 못 된 입력값");
            case "user-ex":
                throw new UserException("사용자 오류");
        }

        return new ApiExceptionController.MemberDto(id, "hello " + id);
    }
}
