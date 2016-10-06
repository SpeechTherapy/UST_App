package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.RecordsDaoApi;
import com.ust.entity.Records;


@Transactional
@Repository
public class RecorderDaoImpl implements RecordsDaoApi{

	private static final Log log = LogFactory.getLog(RecorderDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void persist(Records records) {
		// TODO Auto-generated method stub
		log.debug("persisting Records instance");
	    try {  
	        sessionFactory.getCurrentSession().persist(records);
	        log.debug("persist successful");
	    } catch (RuntimeException re) {
	        log.error("persist failed", re);
	        throw re;
	    }
		
	}

	@Override
	public void attachDirty(Records records) {
		// TODO Auto-generated method stub
		log.debug("attaching dirty Records instance");
	    try {
	        sessionFactory.getCurrentSession().saveOrUpdate(records);
	        log.debug("attach successful");
	    } catch (RuntimeException re) {
	        log.error("attach failed", re);
	        throw re;
	    }
	}

	@Override
	public void attachClean(Records records) {
		// TODO Auto-generated method stub
		 log.debug("attaching clean Records instance");
	        try {
	            sessionFactory.getCurrentSession().lock(records, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		
	}

	@Override
	public void delete(Records records) {
		// TODO Auto-generated method stub
		 log.debug("deleting TblRecords instance");
	        try {
	            sessionFactory.getCurrentSession().delete(records);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	}

	@Override
	public Records merge(Records records) {
		// TODO Auto-generated method stub
		log.debug("merging Records instance");
	    try {
	        Records result = (Records) sessionFactory
	                .getCurrentSession().merge(records);
	        log.debug("merge successful");
	        return result;
	    } catch (RuntimeException re) {
	        log.error("merge failed", re);
	        throw re;
	    }
	}

	@Override
	public Records findById(int id) {
		// TODO Auto-generated method stub
		String qry = "Select a from Records a where a.recordsId = "+id;
	    try {
	        Records records = (Records) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
	        log.debug("find by Id successful");
	        return records;
	    } catch (RuntimeException re) {
	        log.error("find by Id failed", re);
	        throw re;
	    }
	}

	@Override
	public List<Records> findByExampleWithLike(Records records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Records> findAll() {
		log.debug("finding All Records");
	    try {

	        StringBuilder qry = new StringBuilder();
	        qry.append("select a from Records a");
	        List<Records> results = (List<Records>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
	        log.debug("find All successful, result size: "+ results.size());
	        return results;
	    } catch (RuntimeException re) {
	        log.error("find All failed", re);
	        throw re;
	    }
	}
	}
	


