package hello.thymeleaf.basic.itemservice.typeconverter.controller;

import hello.thymeleaf.basic.itemservice.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");//문자 타입 조회
        Integer intValue = Integer.valueOf(data);
        return "ok : " + intValue;
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        return "ok : " + data;
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        log.info("ipIp = " + ipPort.getIp());
        log.info("ipPort = " + ipPort.getPort());
        return "ok";
    }
}
