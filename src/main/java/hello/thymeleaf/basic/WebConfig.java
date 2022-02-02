package hello.thymeleaf.basic;

import hello.thymeleaf.basic.itemservice.exception.filter.LogFilter;
import hello.thymeleaf.basic.itemservice.exception.interceptor.LogInterceptor;
import hello.thymeleaf.basic.itemservice.exception.resolver.MyHandlerExceptionResolver;
import hello.thymeleaf.basic.itemservice.exception.resolver.UserHandlerExceptionResolver;
import hello.thymeleaf.basic.itemservice.typeconverter.converter.IntegerToStringConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.converter.IpPortToStringConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.converter.StringToIntegerConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.converter.StringToIpPortConverter;
import hello.thymeleaf.basic.itemservice.typeconverter.formatter.MyNumberFormatter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "*.ico", "/error", "/error-page/**");//오류 페이지 경로
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new MyHandlerExceptionResolver());
        resolvers.add(new UserHandlerExceptionResolver());
    }

    //    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
        return filterFilterRegistrationBean;
    }

}
