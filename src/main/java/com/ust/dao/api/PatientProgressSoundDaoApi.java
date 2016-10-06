package com.ust.dao.api;

import java.util.List;

import com.ust.entity.PatientProgressSound;

public interface PatientProgressSoundDaoApi {
	public abstract void persist(PatientProgressSound patientprogresssound); //save

    public abstract void attachDirty(PatientProgressSound patientprogresssound); //save and update

    public abstract void attachClean(PatientProgressSound patientprogresssound); //clean 

    public abstract void delete(PatientProgressSound patientprogresssound); //used for record del

    public abstract PatientProgressSound merge(PatientProgressSound patientprogresssound); //used for updation

    public abstract PatientProgressSound findById(int id); //search
    
    public abstract List<PatientProgressSound> findByExampleWithLike(PatientProgressSound patientprogresssound);

    public abstract List<PatientProgressSound> findAll();

}
