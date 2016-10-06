package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Admin;

public interface AdminDaoApi {

	public abstract int persist(Admin admin); //save

    public abstract void attachDirty(Admin admin); //save and update

    public abstract void attachClean(Admin admin); //clean 

    public abstract void delete(Admin admin); //used for record del

    public abstract Admin merge(Admin admin); //used for updation

    public abstract Admin findById(int id); //search
    
    public abstract List<Admin> findByExampleWithLike(Admin admin);

    public abstract List<Admin> findAll();
}
