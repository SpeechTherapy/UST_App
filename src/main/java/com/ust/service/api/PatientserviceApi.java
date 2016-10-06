package com.ust.service.api;

import java.util.List;

import com.ust.entity.Patient;

public interface PatientserviceApi {
	public abstract void save(Patient patient);

    public int saveOrUpdate(Patient patient);

    public abstract void update(Patient patient);

    public abstract void delete(Patient patient);

    public abstract Patient findById(int id);

    public abstract List<Patient> findByPatient(Patient patient);

    public abstract List<Patient> findAll();
    


}
