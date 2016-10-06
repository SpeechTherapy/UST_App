package com.ust.dao.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.entity.User;

public interface UserDaoApi {
	
	public abstract int persist(User user); //save

    public abstract void attachDirty(User user); //save and update

    public abstract void attachClean(User user); //clean 

    public abstract void delete(User user); //used for record del

    public abstract User merge(User user); //used for updation

    public abstract User findById(int id); //search
    
    public abstract User LoginUser(String userName, String userPassword); //requirment

    public abstract List<User> findByExampleWithLike(User user);

    public abstract List<User> findAll();

    public abstract User findByEmail(String email);

}
