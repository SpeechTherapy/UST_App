package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.PatientsProgressWordDaoApi;
import com.ust.entity.PatientsProgressWord;


@Repository
@Transactional
public class PatientsProgressWordDaoImpl implements PatientsProgressWordDaoApi
{
	  private static final Log log = LogFactory.getLog(CityDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;
	
	@Override
	public void persist(PatientsProgressWord patientsprogressword) 
	{
		log.debug("persisting PatientsProgressWord instance");
        try { 
            sessionFactory.getCurrentSession().persist(patientsprogressword);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(PatientsProgressWord patientsprogressword) 
	{
		log.debug("attaching dirty PatientsProgressWord instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(patientsprogressword);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(PatientsProgressWord patientsprogressword) 
	{
		log.debug("attaching clean PatientsProgressWord instance");
        try {
            sessionFactory.getCurrentSession().lock(patientsprogressword, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PatientsProgressWord patientsprogressword) 
	{
		log.debug("deleting TblPatientsProgressWord instance");
        try {
            sessionFactory.getCurrentSession().delete(patientsprogressword);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientsProgressWord merge(PatientsProgressWord patientsprogressword) 
	{
		log.debug("merging PatientsProgressWord instance");
        try {
            PatientsProgressWord result = (PatientsProgressWord) sessionFactory
                    .getCurrentSession().merge(patientsprogressword);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;}
	}

	@Override
	public PatientsProgressWord findById(int id) 
	{
		String qry = "Select a from PatientsProgressWord a where a.patientsprogresswordId = "+id;// entity class name hai PatientsProgressWord table ka name nahi hai
        try {
            PatientsProgressWord patientsprogressword = (PatientsProgressWord) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return patientsprogressword;
        } catch (RuntimeException re) 
        {
            log.error("find by Id failed", re);
            throw re;
        }
		
	}

	@Override
	public List<PatientsProgressWord> findByExampleWithLike(PatientsProgressWord patientsprogressword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientsProgressWord> findAll() 
	{
		log.debug("finding All PatientsProgressWord");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from PatientsProgressWord a");
            List<PatientsProgressWord> results = (List<PatientsProgressWord>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
	
}