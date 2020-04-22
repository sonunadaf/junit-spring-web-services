package com.social.imageApp.account.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.account.exception.InvalidDataException;
import com.social.imageApp.account.model.UserRegRequestDTO;
import com.social.imageApp.account.service.IRegisterService;

@RestController
public class RegisterController {
	@Autowired
	private IRegisterService registerService;
	private static Logger logger = Logger.getLogger(RegisterController.class);

	public RegisterController() {
		logger.info("Created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(UserRegRequestDTO requestDTO, HttpServletRequest request) {
		try {
			registerService.createUser(requestDTO);
			return new ResponseEntity<String>("User created successfully", HttpStatus.OK);
		} catch (InvalidDataException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
