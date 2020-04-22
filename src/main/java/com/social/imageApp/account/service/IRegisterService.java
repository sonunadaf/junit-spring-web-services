package com.social.imageApp.account.service;

import com.social.imageApp.account.model.UserRegRequestDTO;

public interface IRegisterService {

	public boolean createUser(UserRegRequestDTO requestDTO) throws Exception;
}
