package com.ust.dao.api;

import java.util.List;

import com.ust.entity.PatientProgressSentences;

public interface PatientProgressSentencesDaoApi {
	
	public abstract void persist(PatientProgressSentences patientprogresssentences); //save

    public abstract void attachDirty(PatientProgressSentences patientprogresssentences); //save and update

    public abstract void attachClean(PatientProgressSentences patientprogresssentences); //clean 

    public abstract void delete(PatientProgressSentences patientprogresssentences); //used for record del

    public abstract PatientProgressSentences merge(PatientProgressSentences patientprogresssentences); //used for updation

    public abstract PatientProgressSentences findById(int id); //search
    

    public abstract List<PatientProgressSentences> findByExampleWithLike(PatientProgressSentences patientprogresssentences);

    public abstract List<PatientProgressSentences> findAll();


}
