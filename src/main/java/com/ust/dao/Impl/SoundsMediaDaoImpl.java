package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.SoundsMediaDaoApi;
import com.ust.entity.SoundsMedia;

@Repository
@Transactional
public class SoundsMediaDaoImpl implements SoundsMediaDaoApi
{

	 private static final Log log = LogFactory.getLog(SoundsMediaDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;
	@Override
	public void persist(SoundsMedia soundsmedia) 
	{
		log.debug("persisting SoundsMedia instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(soundsmedia);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(SoundsMedia soundsmedia) 
	{
		log.debug("attaching dirty SoundsMedia instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(soundsmedia);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(SoundsMedia soundsmedia) 
	{
		log.debug("attaching clean SoundsMedia instance");
        try {
            sessionFactory.getCurrentSession().lock(soundsmedia, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SoundsMedia soundsmedia) 
	{
		 log.debug("deleting TblSoundsMedia instance");
	        try {
	            sessionFactory.getCurrentSession().delete(soundsmedia);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public SoundsMedia merge(SoundsMedia soundsmedia) 
	{
		log.debug("merging SoundsMedia instance");
        try {
            SoundsMedia result = (SoundsMedia) sessionFactory
                    .getCurrentSession().merge(soundsmedia);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public SoundsMedia findById(int id) 
	{
		String qry = "Select a from SoundsMedia a where a.soundsmediaId = "+id;// entity class name hai SoundsMedia table ka name nahi hai
        try {
            SoundsMedia soundsmedia = (SoundsMedia) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return soundsmedia;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<SoundsMedia> findByExampleWithLike(SoundsMedia soundsmedia) 
	{
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SoundsMedia> findAll() 
	{
		log.debug("finding All SoundsMedia");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from SoundsMedia a");
            List<SoundsMedia> results = (List<SoundsMedia>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
 
}