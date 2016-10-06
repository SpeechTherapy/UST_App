package com.ust.service.api;

import java.util.List;

import com.ust.entity.PatientProgressSentences;

public interface PatientProgressSentencesServiceApi {
	public abstract void save(PatientProgressSentences patientprogresssentences);

    public void saveOrUpdate(PatientProgressSentences patientprogresssentences);

    public abstract void update(PatientProgressSentences patientprogresssentences);

    public abstract void delete(PatientProgressSentences patientprogresssentences);

    public abstract PatientProgressSentences findById(int id);

    public abstract List<PatientProgressSentences> findByPatientProgressSentences(PatientProgressSentences patientprogresssentences);

    public abstract List<PatientProgressSentences> findAll();

}
