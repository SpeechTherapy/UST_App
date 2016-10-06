package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.HospitalDaoApi;
import com.ust.entity.Hospital;
@Repository
@Transactional
public class HospitalDaoImpl implements HospitalDaoApi{
	
	 private static final Log log = LogFactory.getLog(HospitalDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public int persist(Hospital hospital) {
		// TODO Auto-generated method stub
		log.debug("persisting Hospital instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(hospital);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
            return hospital.getHospitalId();
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		
	}

	@Override
	public void attachDirty(Hospital hospital) {
		// TODO Auto-generated method stub
		log.debug("attaching dirty Hospital instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(hospital);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
	}

	@Override
	public void attachClean(Hospital hospital) {
		// TODO Auto-generated method stub
		 log.debug("attaching clean Hospital instance");
	        try {
	            sessionFactory.getCurrentSession().lock(hospital, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
	}

	@Override
	public void delete(Hospital hospital) {
		// TODO Auto-generated method stub
		 log.debug("deleting TblHospital instance");
	        try {
	            sessionFactory.getCurrentSession().delete(hospital);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	}

	@Override
	public Hospital merge(Hospital hospital) {
		// TODO Auto-generated method stub
		log.debug("merging Hospital instance");
        try {
            Hospital result = (Hospital) sessionFactory
                    .getCurrentSession().merge(hospital);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public Hospital findById(int id) {
		// TODO Auto-generated method stub
		String qry = "Select a from Hospital a where a.hospitalId = "+id;// entity class name hai Hospital table ka name nahi hai
        try {
            Hospital hospital = (Hospital) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return hospital;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<Hospital> findByExampleWithLike(Hospital hospital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding All Hospital");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Hospital a");
            List<Hospital> results = (List<Hospital>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}

}
