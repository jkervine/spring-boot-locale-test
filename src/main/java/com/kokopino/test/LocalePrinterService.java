package com.kokopino.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by juha on 04/04/2017.
 */
@Component
@Slf4j
public class LocalePrinterService {

    private Environment environment;

    @Autowired
    public LocalePrinterService(Environment environment) {
        this.environment = environment;
    }

    public void printLocale() {
        log.info("Current language: ", LocaleContextHolder.getLocale().getDisplayLanguage());
    }

}
