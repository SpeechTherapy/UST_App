package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.InformationDaoApi;
import com.ust.entity.Information;


@Repository
@Transactional
public class InformationDaoImpl implements InformationDaoApi
{

	  private static final Log log = LogFactory.getLog(CityDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;
	@Override
	public void persist(Information information) 
	{
		log.debug("persisting Information instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(information);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(Information information) 
	{
		 log.debug("attaching dirty Information instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(information);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(Information information) 
	{
		log.debug("attaching clean Information instance");
        try {
            sessionFactory.getCurrentSession().lock(information, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Information information) 
	{
		log.debug("deleting TblInformation instance");
        try {
            sessionFactory.getCurrentSession().delete(information);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public Information merge(Information information) 
	{
		 log.debug("merging Information instance");
	        try {
	            Information result = (Information) sessionFactory
	                    .getCurrentSession().merge(information);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
	}

	@Override
	public Information findById(int id) 
	{
		String qry = "Select a from Information a where a.informationId = "+id;// entity class name hai Information table ka name nahi hai
        try {
            Information information = (Information) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return information;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<Information> findByExampleWithLike(Information information) 
	{
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Information> findAll() 
	{
		log.debug("finding All Information");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Information a");
            List<Information> results = (List<Information>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
	
}