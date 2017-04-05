package com.kokopino.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocaletestApplicationTests {

	@Autowired
	LocalePrinterService localePrinterService;

	@Autowired
    LocaleTestController localeTestController;

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;
	MockHttpServletRequestBuilder mockRequestBuilder;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockRequestBuilder = MockMvcRequestBuilders.get("/printlocale");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLocaleChangeInService() {
		MockHttpServletRequest testRequest = mockRequestBuilder.header("Accept-Language", "fi-FI")
                .buildRequest(context.getServletContext());
		localePrinterService.printLocale(testRequest);
	}

	@Test
    public void testLocaleChangeInController() {
        MockHttpServletRequest testRequest = mockRequestBuilder.header("Accept-Language", "fi-FI")
                .buildRequest(context.getServletContext());
        localeTestController.printLocale("fi-FI", testRequest);
    }

}
