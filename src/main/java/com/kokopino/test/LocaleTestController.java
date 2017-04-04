package com.kokopino.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by juha on 04/04/2017.
 */

@RestController
@Slf4j
public class LocaleTestController {

    private LocalePrinterService localePrinterService;

    @Autowired
    public LocaleTestController(LocalePrinterService localePrinterService) {
        this.localePrinterService = localePrinterService;
    }

    /**
     * This just reads the locale from accept-language, not passed to spring environment
     * @param acceptLanguage
     */

    @RequestMapping(value = "/printlocale", method = RequestMethod.GET)
    public void printLocale(@RequestHeader(name = "Accept-Language", required = true) String acceptLanguage,
                            HttpServletRequest request) {
        log.info("printlocale called with header: {}", acceptLanguage);
        localePrinterService.printLocale(request);
    }

}
