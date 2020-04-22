package com.social.imageApp.account.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.account.dao.IGetUserDao;
import com.social.imageApp.account.entity.User;
import com.social.imageApp.account.exception.InvalidDataException;
import com.social.imageApp.account.model.UserRegRequestDTO;

@Service
public class UserValidation {

	@Autowired
	private IGetUserDao getUserDao;

	public void validate(UserRegRequestDTO requestDTO) throws Exception {
		if (requestDTO.getEmail() == null || requestDTO.getEmail().length() == 0) {
			throw new InvalidDataException("Email is required field.");
		}
		if (requestDTO.getUserName() == null || requestDTO.getEmail().length() == 0) {
			throw new InvalidDataException("User name is required field.");
		}
		if (requestDTO.getPassword() == null || requestDTO.getEmail().length() == 0) {
			throw new InvalidDataException("Password is required field.");
		}
		User user = getUserDao.getUserByUserName(requestDTO.getUserName());
		if (user != null) {
			throw new InvalidDataException("User name already exist.");
		}

		if (requestDTO.isAdmin() && getUserDao.getAdmin() != null) {
			throw new InvalidDataException("Admin already exist.");
		}

	}

}
