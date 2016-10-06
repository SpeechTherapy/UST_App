package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.PatientProgressSentencesDaoApi;
import com.ust.entity.PatientProgressSentences;

@Repository
@Transactional
public class PatientProgressSentencesDaoImpl implements PatientProgressSentencesDaoApi {
	
	private static final Log log = LogFactory.getLog(PatientProgressSentencesDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

@Override
public void persist(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	log.debug("persisting PatientProgressSentences instance");
    try { //null asakti hai toh isliye use kiya hai 
        sessionFactory.getCurrentSession().persist(patientprogresssentences);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
        log.debug("persist successful");
    } catch (RuntimeException re) {
        log.error("persist failed", re);
        throw re;
    }
	
}

@Override
public void attachDirty(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	log.debug("attaching dirty PatientProgressSentences instance");
    try {
        sessionFactory.getCurrentSession().saveOrUpdate(patientprogresssentences);
        log.debug("attach successful");
    } catch (RuntimeException re) {
        log.error("attach failed", re);
        throw re;
    }
}

@Override
public void attachClean(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	 log.debug("attaching clean PatientProgressSentences instance");
        try {
            sessionFactory.getCurrentSession().lock(patientprogresssentences, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
}

@Override
public void delete(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	 log.debug("deleting TblPatientProgressSentences instance");
        try {
            sessionFactory.getCurrentSession().delete(patientprogresssentences);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
}

@Override
public PatientProgressSentences merge(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	log.debug("merging PatientProgressSentences instance");
    try {
        PatientProgressSentences result = (PatientProgressSentences) sessionFactory
                .getCurrentSession().merge(patientprogresssentences);
        log.debug("merge successful");
        return result;
    } catch (RuntimeException re) {
        log.error("merge failed", re);
        throw re;
    }
}

@Override
public PatientProgressSentences findById(int id) {
	// TODO Auto-generated method stub
	String qry = "Select a from PatientProgressSentences a where a.patientprogresssentencesId = "+id;// entity class name hai PatientProgressSentences table ka name nahi hai
    try {
        PatientProgressSentences patientprogresssentences = (PatientProgressSentences) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
        log.debug("find by Id successful");
        return patientprogresssentences;
    } catch (RuntimeException re) {
        log.error("find by Id failed", re);
        throw re;
    }
}

@Override
public List<PatientProgressSentences> findByExampleWithLike(PatientProgressSentences patientprogresssentences) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<PatientProgressSentences> findAll() {
	// TODO Auto-generated method stub
	log.debug("finding All PatientProgressSentences");
    try {

        StringBuilder qry = new StringBuilder();
        qry.append("select a from PatientProgressSentences a");
        List<PatientProgressSentences> results = (List<PatientProgressSentences>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
        log.debug("find All successful, result size: "+ results.size());
        return results;
    } catch (RuntimeException re) {
        log.error("find All failed", re);
        throw re;
    }
}

}



