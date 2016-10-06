package com.ust.service.api;

import java.util.List;

import com.ust.entity.AssignedChapterTherapist;

public interface AssignedChapterTherapistServiceApi {
	 public abstract void save(AssignedChapterTherapist assignedchaptertherapist);

	    public abstract void saveOrUpdate(AssignedChapterTherapist assignedchaptertherapist);

	    public abstract void update(AssignedChapterTherapist assignedchaptertherapist);

	    public abstract void delete(AssignedChapterTherapist assignedchaptertherapist);

	    public abstract AssignedChapterTherapist findById(int id);

	    public abstract List<AssignedChapterTherapist> findByassignedChapterTherapist(AssignedChapterTherapist assignedchaptertherapist);

	    public abstract List<AssignedChapterTherapist> findAll();

}
