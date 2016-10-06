package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Therapist;

public interface TherapistDaoApi {
	
	public abstract void persist(Therapist therapist);

    public abstract void attachDirty(Therapist therapist);

    public abstract void attachClean(Therapist therapist);

    public abstract void delete(Therapist therapist);

    public abstract Therapist merge(Therapist therapist);

    public abstract Therapist findById(int id);

    public abstract List<Therapist> findByExampleWithLike(Therapist therapist);

    public abstract List<Therapist> findAll();
    public abstract List<Therapist> findTherapist();


    public abstract Therapist Report(int id);
    
    public abstract Therapist findUserById(int id);
}
