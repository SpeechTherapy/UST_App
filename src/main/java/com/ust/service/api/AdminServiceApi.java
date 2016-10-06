package com.ust.service.api;

import java.util.List;

import com.ust.entity.Admin;

public interface AdminServiceApi {
	
	 public abstract int save(Admin admin);

	    public void saveOrUpdate(Admin admin);

	    public abstract void update(Admin admin);

	    public abstract void delete(Admin admin);

	    public abstract Admin findById(int id);


	    public abstract List<Admin> findByAdmin(Admin admin);

	    public abstract List<Admin> findAll();
	    
		public abstract void merge(Admin admin);

}
