package com.kokopino.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by juha on 04/04/2017.
 */
@Component
@Slf4j
public class LocalePrinterService {

    private Environment environment;
    private AcceptHeaderLocaleResolver localeResolver;

    @Autowired
    public LocalePrinterService(Environment environment, AcceptHeaderLocaleResolver localeResolver) {
        this.environment = environment;
        this.localeResolver = localeResolver;
    }

    public void printLocale(HttpServletRequest request) {
        // Output with autowired localeresolver
        Locale resolved = localeResolver.resolveLocale(request);
        log.info("Language resolved through AcceptHeaderLocaleResolver: "+resolved.getLanguage());
        log.info("Country resolved through AcceptHeaderLocaleResolver: "+resolved.getCountry());
        // Output with locale directly from the request
        Locale resolved2 = request.getLocale();
        log.info("Language resolved through request: "+resolved2.getLanguage());
        log.info("Country resolved through request: "+resolved2.getCountry());
        // Output with localeresolver from RequestContextUtils
        LocaleResolver resolverFromRequest = RequestContextUtils.getLocaleResolver(request);
        try {
            Locale resolved3 = resolverFromRequest.resolveLocale(request);
            log.info("Language resolved through request: "+resolved3.getLanguage());
            log.info("Country resolved through request: "+resolved3.getCountry());
        } catch (NullPointerException e) {
            log.error("Cannot obtain localeResolver from the request (it's null)");
        }
    }

}
