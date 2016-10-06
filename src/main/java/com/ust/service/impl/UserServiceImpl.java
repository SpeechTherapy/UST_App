package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.UserDaoApi;
import com.ust.entity.User;
import com.ust.service.api.UserServiceApi;

@Service 
public class UserServiceImpl implements UserServiceApi {
	
	@Autowired
	private UserDaoApi userDaoApi;

	public int save(User user) {
		return userDaoApi.persist(user);
	}

	public void saveOrUpdate(User user) {

		userDaoApi.attachDirty(user);
	}

	public void update(User user) {

		userDaoApi.merge(user);
	}

	public void delete(User user) {

		userDaoApi.delete(user);
	}

	public User findById(int id) {
		return userDaoApi.findById(id);
	}

	public List<User> findByUser(User user) {
		// TODO Auto-generated method stub
		return userDaoApi.findByExampleWithLike(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDaoApi.findAll();
	}

	@Override
	public User LoginUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userDaoApi.LoginUser(userName, userPassword);
	}


	public void merge(User user)
	{
		userDaoApi.merge(user);
	}
	public User findByEmail(String email) 
	{
		return userDaoApi.findByEmail(email);
	}


}
