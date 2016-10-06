package com.ust.dao.Impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.PatientDaoApi;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Patient;
import com.ust.entity.PatientProgressSentences;
import com.ust.entity.PatientProgressSound;
import com.ust.entity.PatientsProgressWord;
import com.ust.entity.Records;
import com.ust.entity.Therapist;


@Repository
@Transactional
public class PatientDaoImpl implements PatientDaoApi {
	
	  private static final Log log = LogFactory.getLog(PatientDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public void persist(Patient patient) {
		log.debug("persisting Patient instance");
        try {
            sessionFactory.getCurrentSession().persist(patient);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public int attachDirty(Patient patient) {
		 log.debug("attaching dirty Patient instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(patient);
	            log.debug("attach successful");
	            return patient.getPatientId();
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
			
		
	}

	@Override
	public void attachClean(Patient patient) {
		log.debug("attaching clean Patient instance");
        try {
            sessionFactory.getCurrentSession().lock(patient, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Patient patient) {
		// TODO Auto-generated method stub
		log.debug("deleting TblPatient instance");
        try {
            sessionFactory.getCurrentSession().delete(patient);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
		
	}

	@Override
	public Patient merge(Patient patient) {
		 log.debug("merging Patient instance");
	        try {
	            Patient result = (Patient) sessionFactory
	                    .getCurrentSession().merge(patient);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findById(int id) {
		String qry = "Select a from Patient a where a.patientId = "+id;
        try {
            Patient patient = (Patient) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");//here we have define multilevel initialization
            if(patient!=null)
            {
            	
            	Hibernate.initialize(patient.getUser());
            	Hibernate.initialize(patient.getTherapist());
            	Hibernate.initialize(patient.getTherapist().getUser());
            	Hibernate.initialize(patient.getTherapist().getHospital());


            	if(patient.getAssignedchapterTherapist()!=null)
            	{
            	Set<AssignedChapterTherapist> abc = patient.getAssignedchapterTherapist();
            	for(AssignedChapterTherapist assignedChapterTherapist : abc)
            	{
            		Hibernate.initialize(assignedChapterTherapist.getLesson());
            		Set<PatientProgressSentences> patientProgressSentenceSet = assignedChapterTherapist.getPatientProgressSentences();
            		for(PatientProgressSentences patientProgressSentences : patientProgressSentenceSet)
            		{
            			Hibernate.initialize(patientProgressSentences);
            			
            		}
            		Set<PatientProgressSound> patientProgressSoundSet = assignedChapterTherapist.getPatientProgressSound();
        			for(PatientProgressSound patientProgressSound : patientProgressSoundSet)
        			{
        				Hibernate.initialize(patientProgressSound);
        				
        			}
        			Set<PatientsProgressWord> patientsProgressWordSet =assignedChapterTherapist.getPatientsProgressWord();
        			for(PatientsProgressWord patientsProgressWord : patientsProgressWordSet)
        			{
        				Hibernate.initialize(patientsProgressWord);
        			}
        			
            	} 	
            	}
            	if(patient.getRecordedAudio()!=null)
            	{
            		Set<Records> recordedAudioSet =patient.getRecordedAudio();
            		for(Records recordedAudio: recordedAudioSet)
            		{
            			Hibernate.initialize(recordedAudio);
            			
            		}
            	}
        	
            	else{
            		System.out.println("Do it again ");
            	}
            }
            return patient;
        } catch (RuntimeException re) {
        	
            log.error("find by Id failed", re);
            re.printStackTrace();
            throw re;
        }
	}
	
	@Override
	public List<Patient> findByExampleWithLike(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAll() {
		log.debug("finding All Patient");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Patient a");
            List<Patient> results = (List<Patient>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            if(results.size() > 0){
            	for(Patient patient : results){
            		Hibernate.initialize(patient.getUser());
            		if(patient.getAssignedchapterTherapist()!=null)
                	{
                	Set<AssignedChapterTherapist> abc = patient.getAssignedchapterTherapist();
                	for(AssignedChapterTherapist assignedChapterTherapist : abc)
                	{
                		Hibernate.initialize(assignedChapterTherapist.getLesson());
                	}
                	}
            	}
            }
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
}
	


}
