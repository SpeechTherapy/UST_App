package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Patient;

public interface PatientDaoApi {
	
	public abstract void persist(Patient patient);

    public abstract int attachDirty(Patient patient);

    public abstract void attachClean(Patient patient);

    public abstract void delete(Patient patient);

    public abstract Patient merge(Patient patient);

    public abstract Patient findById(int id);

    public abstract List<Patient> findByExampleWithLike(Patient patient);

    public abstract List<Patient> findAll();
    	

}
