package com.ust.dao.api;

import java.util.List;

import com.ust.entity.PatientsProgressWord;


public interface PatientsProgressWordDaoApi
{
	public abstract void persist(PatientsProgressWord patientsprogressword); //save

    public abstract void attachDirty(PatientsProgressWord patientsprogressword); //save and update

    public abstract void attachClean(PatientsProgressWord patientsprogressword); //clean 

    public abstract void delete(PatientsProgressWord patientsprogressword); //used for record del

    public abstract PatientsProgressWord merge(PatientsProgressWord patientsprogressword); //used for updation

    public abstract PatientsProgressWord findById(int id); //search
    

    public abstract List<PatientsProgressWord> findByExampleWithLike(PatientsProgressWord patientsprogressword);

    public abstract List<PatientsProgressWord> findAll();
}