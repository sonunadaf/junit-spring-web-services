package com.social.imageApp.account.dao;

import com.social.imageApp.account.entity.User;

public interface ISaveOrUpdateDao {

	public void saveOrUpdate(User user) throws Exception;
}
