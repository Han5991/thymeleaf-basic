package hello.thymeleaf.basic.itemservice.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class MyNumberFormatterTest {

    private MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        assertThat(formatter.parse("1,000", Locale.KOREA)).isEqualTo(1000L);
    }

    @Test
    void print() {
        assertThat(formatter.print(1000, Locale.KOREA)).isEqualTo("1,000");
    }
}