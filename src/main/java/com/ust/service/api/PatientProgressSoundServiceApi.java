package com.ust.service.api;

import java.util.List;


import com.ust.entity.PatientProgressSound;

public interface PatientProgressSoundServiceApi {
	public abstract void save(PatientProgressSound patientprogresssound);

    public void saveOrUpdate(PatientProgressSound patientprogresssound);

    public abstract void update(PatientProgressSound patientprogresssound);

    public abstract void delete(PatientProgressSound patientprogresssound);

    public abstract PatientProgressSound findById(int id);

    public abstract List<PatientProgressSound> findByPateintProgressSound(PatientProgressSound patientprogresssound);

    public abstract List<PatientProgressSound> findAll();

}
