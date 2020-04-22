package com.social.imageApp.account.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.social.imageApp.account.controllers.RegisterServiceTest;

public class MainRunner {

	private static Logger logger = Logger.getLogger(MainRunner.class);

	@Test
	public void runAllTestCases() {
		Result result = JUnitCore.runClasses(RegisterServiceTest.class);
		List<Failure> failureList = result.getFailures();
		for (Failure failure : failureList) {
			logger.error(failure);
		}
		logger.info(result.wasSuccessful());
	}

}
