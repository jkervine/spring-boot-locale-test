package com.kokopino.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @RequestMapping(value = "/printlocale", method = RequestMethod.GET)
    public void printLocale() {
        log.info("printlocale called");
        localePrinterService.printLocale();
    }

}
