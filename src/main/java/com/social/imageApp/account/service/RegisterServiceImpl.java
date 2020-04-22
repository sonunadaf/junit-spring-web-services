package com.social.imageApp.account.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.account.dao.ISaveOrUpdateDao;
import com.social.imageApp.account.entity.User;
import com.social.imageApp.account.entity.UserType;
import com.social.imageApp.account.model.UserRegRequestDTO;
import com.social.imageApp.account.validation.UserValidation;

@Service
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private ISaveOrUpdateDao saveOrUpdate;
	@Autowired
	private UserValidation userValidation;

	private static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public RegisterServiceImpl() {
		logger.info("Created : " + this.getClass().getSimpleName());
	}

	public boolean createUser(UserRegRequestDTO requestDTO) throws Exception {
		userValidation.validate(requestDTO);
		User user = convertDtoToDomain(requestDTO);
		saveOrUpdate.saveOrUpdate(user);
		return true;

	}

	private User convertDtoToDomain(UserRegRequestDTO requestDTO) {
		User user = new User();
		user.setUserName(requestDTO.getUserName());
		user.setPassword(requestDTO.getPassword());
		user.setEmail(requestDTO.getEmail());
		if (requestDTO.isAdmin()) {
			user.setUserRole(UserType.ADMIN.toString());
		}
		return user;
	}
}
