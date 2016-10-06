package com.ust.service.api;

import java.util.List;

import com.ust.entity.Therapist;

public interface TherapistServiceApi {
	
	public abstract void save(Therapist therapist);

    public void saveOrUpdate(Therapist therapist);

    public abstract void update(Therapist therapist);

    public abstract void delete(Therapist therapist);

    public abstract Therapist findById(int id);

    public abstract List<Therapist> findByTherapist(Therapist therapist);

    public abstract List<Therapist> findAll();

    public abstract Therapist Report(int id);
    public abstract List<Therapist> findTherapist();


}
