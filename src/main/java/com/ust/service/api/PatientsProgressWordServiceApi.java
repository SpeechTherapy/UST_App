package com.ust.service.api;

import java.util.List;

import com.ust.entity.PatientsProgressWord;

public interface PatientsProgressWordServiceApi
{
	 public abstract void save(PatientsProgressWord patientsprogressword);

	    public void saveOrUpdate(PatientsProgressWord patientsprogressword);

	    public abstract void update(PatientsProgressWord patientsprogressword);

	    public abstract void delete(PatientsProgressWord patientsprogressword);

	    public abstract PatientsProgressWord findById(int id);

	    public abstract List<PatientsProgressWord> findByPatientsProgressWord(PatientsProgressWord patientsprogressword);

	    public abstract List<PatientsProgressWord> findAll();
}