package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.AssignedChapterTherapistDaoApi;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.service.api.AssignedChapterTherapistServiceApi;
@Service
public class AssignedChapterTherapistServiceImpl implements AssignedChapterTherapistServiceApi{
	@Autowired
	private AssignedChapterTherapistDaoApi assignedchaptertherapistDaoApi;

	@Override
	public void save(AssignedChapterTherapist assignedchaptertherapist) {
		assignedchaptertherapistDaoApi.persist(assignedchaptertherapist);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(AssignedChapterTherapist assignedchaptertherapist) {
		assignedchaptertherapistDaoApi.attachDirty(assignedchaptertherapist);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AssignedChapterTherapist assignedchaptertherapist) {
		assignedchaptertherapistDaoApi.merge(assignedchaptertherapist);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AssignedChapterTherapist assignedchaptertherapist) {
		// TODO Auto-generated method stub
		assignedchaptertherapistDaoApi.delete(assignedchaptertherapist);
	}

	@Override
	public AssignedChapterTherapist findById(int id) {
		return assignedchaptertherapistDaoApi.findById(id);
	}

	@Override
	public List<AssignedChapterTherapist> findAll() {
		return assignedchaptertherapistDaoApi.findAll();
	}

	@Override
	public List<AssignedChapterTherapist> findByassignedChapterTherapist(
			AssignedChapterTherapist assignedchaptertherapist) {
		// TODO Auto-generated method stub
		return null;
	}

}


