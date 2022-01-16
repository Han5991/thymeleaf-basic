package hello.thymeleaf.basic.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void helloMessage() {
        String message = messageSource.getMessage("hello", null, null);
        assertThat(message).isEqualTo("안녕");
    }

    @Test
    void notFoundMessageCode(){
        assertThatThrownBy(() ->messageSource.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void basicFoundMessageCode(){
        String message = messageSource.getMessage("no_code", null,"기본 메시지",null);
        assertThat(message).isEqualTo("기본 메시지");
    }

    @Test
    void argumentMessage(){
        String message = messageSource.getMessage("hello.name", new Object[]{"한상욱"}, null);
        assertThat(message).isEqualTo("안녕 한상욱");
    }

    @Test
    void defaultLang(){
        assertThat(messageSource.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(messageSource.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
