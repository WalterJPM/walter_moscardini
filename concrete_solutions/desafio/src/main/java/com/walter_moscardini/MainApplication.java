package com.walter_moscardini;

import com.walter_moscardini.Model.Phone;
import com.walter_moscardini.Model.User;
import com.walter_moscardini.Service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class MainApplication implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    public static void main(String[] args){

        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        context.getBean(UserService.class).createUser(
                new User("Walter",
                        "walter.jpm@gmail.com",
                        "walterPass",
                        Stream.of(
                                new Phone("11112222",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

        context.getBean(UserService.class).createUser(
                new User("Francisco",
                        "francisco@concrete.com",
                        "franciscoPass",
                        Stream.of(
                                new Phone("33334444",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

        context.getBean(UserService.class).createUser(
                new User("Helena",
                        "helena@concrete.com",
                        "helenaPass",
                        Stream.of(
                                new Phone("55556666",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

    }

}
