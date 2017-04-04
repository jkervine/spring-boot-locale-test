package com.kokopino.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by juha on 04/04/2017.
 */
@Configuration
@EnableWebMvc
@Slf4j
public class LocaleTestConfiguration {

    @Bean
    public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver() {
        return new AcceptHeaderLocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                return super.resolveLocale(request);
                // Own implementation, which seems equivalent to super impl...:
                /*
                Locale res = Locale.forLanguageTag(request.getHeader("Accept-Language"));
                log.info("res has now language: "+res.getLanguage());
                log.info("res has not country: "+res.getCountry());
                return res;
                */
            }
        };
    }
}
