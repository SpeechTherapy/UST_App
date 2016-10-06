package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.MediaDaoApi;
import com.ust.entity.Media;
import com.ust.entity.Media;

@Repository
@Transactional
 public class MediaDaoImpl implements MediaDaoApi
 {

	  private static final Log log = LogFactory.getLog(MediaDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;
	
	    @Override
		public void persist(Media media) {
			log.debug("persisting Media instance");
	        try { //null asakti hai toh isliye use kiya hai 
	            sessionFactory.getCurrentSession().persist(media);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
	            log.debug("persist successful");
	        } catch (RuntimeException re) {
	            log.error("persist failed", re);
	            throw re;
	        }
			// TODO Auto-generated method stub
			
		}
	    
	@Override
	public void attachDirty(Media media) 
	{
		log.debug("attaching dirty Media instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(media);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(Media media) 
	{
		log.debug("attaching clean Media instance");
        try {
            sessionFactory.getCurrentSession().lock(media, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Media media) 
	{
		 log.debug("deleting TblMedia instance");
	        try {
	            sessionFactory.getCurrentSession().delete(media);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public Media merge(Media media) 
	{
		 log.debug("merging Media instance");
	        try {
	            Media result = (Media) sessionFactory
	                    .getCurrentSession().merge(media);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
	}

	@Override
	public Media findById(int id) 
	{
		String qry = "Select a from Media a where a.mediaId = "+id;// entity class name hai Media table ka name nahi hai
        try {
            Media media = (Media) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return media;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<Media> findByExampleWithLike(Media media) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> findAll() 
	{
		log.debug("finding All Media");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Media a");
            List<Media> results = (List<Media>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
	
	
 }