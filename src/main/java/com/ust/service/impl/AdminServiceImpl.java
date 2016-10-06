package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.AdminDaoApi;
import com.ust.entity.Admin;
import com.ust.entity.Admin;
import com.ust.service.api.AdminServiceApi;

@Service
public class AdminServiceImpl implements AdminServiceApi  {

	@Autowired
	private AdminDaoApi adminDaoApi;
	public int save(Admin admin) {
		return adminDaoApi.persist(admin);
	}

	public void saveOrUpdate(Admin admin) {

		adminDaoApi.attachDirty(admin);
	}

	public void update(Admin admin) {

		adminDaoApi.merge(admin);
	}

	public void delete(Admin admin) {

		adminDaoApi.delete(admin);
	}

	public Admin findById(int id) {
		return adminDaoApi.findById(id);
	}

	public List<Admin> findByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDaoApi.findByExampleWithLike(admin);
	}

	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDaoApi.findAll();
	}

	


	public void merge(Admin admin)
	{
		adminDaoApi.merge(admin);
	}
	
}
