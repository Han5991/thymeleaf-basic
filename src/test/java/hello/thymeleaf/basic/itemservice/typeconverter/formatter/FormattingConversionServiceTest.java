package hello.thymeleaf.basic.itemservice.typeconverter.formatter;

import hello.thymeleaf.basic.itemservice.typeconverter.converter.IpPortToStringConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.converter.StringToIpPortConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService service = new DefaultFormattingConversionService();

        //컨버터 등록
        service.addConverter(new StringToIpPortConverter());
        service.addConverter(new IpPortToStringConverter());

        //포맷터 등록
        service.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        assertThat(service.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1", 8080));

        //포맷터 사용
        assertThat(service.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(service.convert("1,000", Long.class)).isEqualTo(1000L);
    }
}
