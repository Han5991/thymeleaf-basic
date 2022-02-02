package hello.thymeleaf.basic.itemservice.typeconverter.converter;

import hello.thymeleaf.basic.itemservice.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void StringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer convert = converter.convert("100");
        assertThat(convert).isEqualTo(100);
    }

    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String convert = converter.convert(100);
        assertThat(convert).isEqualTo("100");
    }

    @Test
    void stringToIpPort() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String convert = converter.convert(source);
        assertThat(convert).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort ipPort = converter.convert(source);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}