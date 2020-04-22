package com.social.imageApp.account.controllers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.social.imageApp.account.config.TestBeanConfig;
import com.social.imageApp.account.model.UserRegRequestDTO;
import com.social.imageApp.account.service.IRegisterService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class RegisterServiceTest {

	@Autowired
	private IRegisterService registerService;
	private static Logger logger = Logger.getLogger(RegisterServiceTest.class);

	@Test
	public void registerUser() throws Exception {
		logger.info("Started Execution Test case1");
		UserRegRequestDTO request = new UserRegRequestDTO("uman", "nadaf", "nf.sonu007@gmail.com", true);
		boolean createdStatus = registerService.createUser(request);
		assertEquals(true, createdStatus);
		logger.info("Finished Execution Test case1");
	}

	@Test
	public void authenticate() {
		logger.info("Started Execution Test case2 authenticate");

		logger.info("Started Execution Test case2 authenticate");
	}

	@Test
	public void userAdminAlreadyExist() {

		logger.info("Started Execution Test case3");
	}

}
