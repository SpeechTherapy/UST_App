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

import com.ust.dao.api.TherapistDaoApi;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Hospital;
import com.ust.entity.Patient;
import com.ust.entity.PatientProgressSentences;
import com.ust.entity.PatientProgressSound;
import com.ust.entity.PatientsProgressWord;
import com.ust.entity.Post;
import com.ust.entity.Records;
import com.ust.entity.Therapist;
import com.ust.entity.User;

@Repository
@Transactional
public class TherapistDaoImpl implements TherapistDaoApi{
	
	
    private static final Log log = LogFactory.getLog(TherapistDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void persist(Therapist therapist) {
		
		 log.debug("persisting Therapist instance");
	        try {
	            sessionFactory.getCurrentSession().persist(therapist);
	            log.debug("persist successful");
	        } catch (RuntimeException re) {
	            log.error("persist failed", re);
	            throw re;
	        }
		
	}

    @Override
    public void attachDirty(Therapist therapist) {
        log.debug("attaching dirty Therapist instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(therapist);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void attachClean(Therapist therapist) {
        log.debug("attaching clean Therapist instance");
        try {
            sessionFactory.getCurrentSession().lock(therapist, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void delete(Therapist therapist) {
        log.debug("deleting TblTherapist instance");
        try {
            sessionFactory.getCurrentSession().delete(therapist);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    @Override
    public Therapist merge(Therapist detachedInstance) {
        log.debug("merging Therapist instance");
        try {
            Therapist result = (Therapist) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
	public List<Therapist> findByExampleWithLike(Therapist therapist) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public List<Therapist> findAll() {   
		 log.debug("finding All Therapist");
	        try {

	            StringBuilder qry = new StringBuilder();
	            qry.append("select a from Therapist a");
	            List<Therapist> results = (List<Therapist>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
	            if(results.size() > 0){
	            	for(Therapist therapist : results){
	            		Hibernate.initialize(therapist.getUser());
	            		Hibernate.initialize(therapist.getHospital());
	            		Hibernate.initialize(therapist.getHospital().getCity());
	            		Hibernate.initialize(therapist.getPost());

	            	}
	            }
	            log.debug("find All successful, result size: "+ results.size());
	            return results;
	        } catch (RuntimeException re) {
	            log.error("find All failed", re);
	            throw re;
	        }
	}
    
    
    @Override
	public List<Therapist> findTherapist() {   
		 log.debug("finding All Therapist");
	        try {

	            StringBuilder qry = new StringBuilder();
	            qry.append("select a from Therapist a");
	            List<Therapist> results = (List<Therapist>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
	            if(results.size() > 0){
	            	for(Therapist therapist : results){
	            		Hibernate.initialize(therapist.getUser());
	            		Hibernate.initialize(therapist.getHospital());

	            	}
	            }
	            log.debug("find All successful, result size: "+ results.size());
	            return results;
	        } catch (RuntimeException re) {
	            log.error("find All failed", re);
	            throw re;
	        }
	}
    
    
   
    @Override
    public Therapist findUserById(int id) {
    	String qry = "Select a from User a where a.UserId = "+id;
        try {
            Therapist therapist = (Therapist) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(therapist!=null)
            {
            	Hibernate.initialize(therapist);
            	Hibernate.initialize(therapist.getUser());
        		Hibernate.initialize(therapist.getHospital());
        	}
            
            return therapist;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
    }
    
    @Override
    public Therapist findById(int id) {
    	String qry = "Select a from Therapist a where a.therapistId = "+id;
        try {
            Therapist therapist = (Therapist) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(therapist!=null)
            {
            	Hibernate.initialize(therapist.getUser());
            	Hibernate.initialize(therapist.getHospital());
            	Hibernate.initialize(therapist.getHospital().getCity());
            	
            	
            	if(therapist.getPatient()!=null)
            	{
            		Set<Patient> patientSet = therapist.getPatient();
            		for(Patient patient: patientSet)
            		{
            			Hibernate.initialize(patient);
                    	Set<AssignedChapterTherapist> abc = patient.getAssignedchapterTherapist();
            			for(AssignedChapterTherapist assignedChapterTherapist : abc)
                    	{
                    		Hibernate.initialize(assignedChapterTherapist.getLesson());
                    	}

            		}
            		
            		
            	}
            	
            }
            return therapist;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
    }
    
    @Override
    public Therapist Report(int id)
    {
    	String qry = "Select a from Therapist a where a.therapistId = "+id;
        try {
            Therapist therapist = (Therapist) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(therapist!=null)
            {
            	Hibernate.initialize(therapist);
            	Hibernate.initialize(therapist.getUser());
            	Hibernate.initialize(therapist.getHospital());
            	Hibernate.initialize(therapist.getHospital().getCity());
            	
            	if(therapist.getPatient()!=null)
            	{
                	Set<Patient> patientSet = therapist.getPatient();
                	for(Patient patient :patientSet)
                	{
                		Hibernate.initialize(patient);
                		//if(patient.getAssignedchapterTherapist()!=null)
                    	//{
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
                    	//}
                    	if(patient.getRecordedAudio()!=null)
                    	{
                    		Set<Records> recordedAudioSet =patient.getRecordedAudio();
                    		for(Records recordedAudio: recordedAudioSet)
                    		{
                    			Hibernate.initialize(recordedAudio);
                    			
                    		}
                    	}
                	}

            	}
            }
            return therapist;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
    }

	


}
