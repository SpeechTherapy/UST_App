package com.ust.dao.api;

import java.util.List;

import com.ust.entity.AssignedChapterTherapist;

public interface AssignedChapterTherapistDaoApi {
	public abstract void persist(AssignedChapterTherapist assihnedchaptertherapist); //save

    public abstract void attachDirty(AssignedChapterTherapist assihnedchaptertherapist); //save and update

    public abstract void attachClean(AssignedChapterTherapist assihnedchaptertherapist); //clean 

    public abstract void delete(AssignedChapterTherapist assihnedchaptertherapist); //used for record del

    public abstract AssignedChapterTherapist merge(AssignedChapterTherapist assihnedchaptertherapist); //used for updation

    public abstract AssignedChapterTherapist findById(int id); //search
    
    public abstract List<AssignedChapterTherapist> findByExampleWithLike(AssignedChapterTherapist assihnedchaptertherapist);

    public abstract List<AssignedChapterTherapist> findAll();

}
