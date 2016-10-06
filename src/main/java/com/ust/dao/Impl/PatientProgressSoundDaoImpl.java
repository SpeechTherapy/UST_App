package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.PatientProgressSoundDaoApi;
import com.ust.entity.PatientProgressSound;

@Repository
@Transactional
public class PatientProgressSoundDaoImpl implements PatientProgressSoundDaoApi {	 private static final Log log = LogFactory.getLog(PatientProgressSoundDaoImpl.class);

@Autowired
private SessionFactory sessionFactory;

@Override
public void persist(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
log.debug("persisting PatientProgressSound instance");
try { //null asakti hai toh isliye use kiya hai 
    sessionFactory.getCurrentSession().persist(patientprogresssound);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
    log.debug("persist successful");
} catch (RuntimeException re) {
    log.error("persist failed", re);
    throw re;
}

}

@Override
public void attachDirty(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
log.debug("attaching dirty PatientProgressSound instance");
try {
    sessionFactory.getCurrentSession().saveOrUpdate(patientprogresssound);
    log.debug("attach successful");
} catch (RuntimeException re) {
    log.error("attach failed", re);
    throw re;
}
}

@Override
public void attachClean(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
 log.debug("attaching clean PatientProgressSound instance");
    try {
        sessionFactory.getCurrentSession().lock(patientprogresssound, LockMode.NONE);
        log.debug("attach successful");
    } catch (RuntimeException re) {
        log.error("attach failed", re);
        throw re;
    }
}

@Override
public void delete(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
 log.debug("deleting TblPatientProgressSound instance");
    try {
        sessionFactory.getCurrentSession().delete(patientprogresssound);
        log.debug("delete successful");
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        throw re;
    }
}

@Override
public PatientProgressSound merge(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
log.debug("merging PatientProgressSound instance");
try {
    PatientProgressSound result = (PatientProgressSound) sessionFactory
            .getCurrentSession().merge(patientprogresssound);
    log.debug("merge successful");
    return result;
} catch (RuntimeException re) {
    log.error("merge failed", re);
    throw re;
}
}

@Override
public PatientProgressSound findById(int id) {
// TODO Auto-generated method stub
String qry = "Select a from PatientProgressSound a where a.patientprogresssoundId = "+id;// entity class name hai PatientProgressSound table ka name nahi hai
try {
    PatientProgressSound patientprogresssound = (PatientProgressSound) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
    log.debug("find by Id successful");
    return patientprogresssound;
} catch (RuntimeException re) {
    log.error("find by Id failed", re);
    throw re;
}
}

@Override
public List<PatientProgressSound> findByExampleWithLike(PatientProgressSound patientprogresssound) {
// TODO Auto-generated method stub
return null;
}

@Override
public List<PatientProgressSound> findAll() {
// TODO Auto-generated method stub
log.debug("finding All PatientProgressSound");
try {

    StringBuilder qry = new StringBuilder();
    qry.append("select a from PatientProgressSound a");
    List<PatientProgressSound> results = (List<PatientProgressSound>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
    log.debug("find All successful, result size: "+ results.size());
    return results;
} catch (RuntimeException re) {
    log.error("find All failed", re);
    throw re;
}
}

}
