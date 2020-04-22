package com.social.imageApp.account.dao;

import com.social.imageApp.account.entity.User;

public interface IGetUserDao {

	public User getUserByUserName(String userName);

	public User getAdmin() throws Exception;
}
