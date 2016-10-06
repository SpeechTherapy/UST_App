package com.ust.service.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.entity.User;

public interface UserServiceApi {
	
    public abstract int save(User user);

    public void saveOrUpdate(User user);

    public abstract void update(User user);

    public abstract void delete(User user);

    public abstract User findById(int id);

    public abstract User LoginUser(String userName, String userPassword);

    public abstract List<User> findByUser(User user);

    public abstract List<User> findAll();
    
    public abstract User findByEmail(String email);

	public abstract void merge(User user);

}
