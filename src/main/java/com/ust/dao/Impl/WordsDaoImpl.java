package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.WordsDaoApi;
import com.ust.entity.Words;


@Repository
@Transactional
public class WordsDaoImpl implements WordsDaoApi
{
	 private static final Log log = LogFactory.getLog(WordsDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;

	
	@Override
	public void persist(Words words)
	{
		log.debug("persisting Words instance");
        try {
            sessionFactory.getCurrentSession().persist(words);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(Words words) 
	{
		 log.debug("attaching dirty Words instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(words);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(Words words) 
	{
		log.debug("attaching clean Words instance");
        try {
            sessionFactory.getCurrentSession().lock(words, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Words words) 
	{
		log.debug("deleting TblWords instance");
        try {
            sessionFactory.getCurrentSession().delete(words);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public Words merge(Words words) 
	{
		 log.debug("merging Words instance");
	        try {
	            Words result = (Words) sessionFactory
	                    .getCurrentSession().merge(words);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
	}

	@Override
	public Words findById(int id) 
	{
		String qry = "Select a from Words a where a.wordsId = "+id;
        try {
            Words words = (Words) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(words!=null)
            {
            	Hibernate.initialize(words.getLesson());
            	Hibernate.initialize(words.getMedia());
            }
            return words;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
	}

	@Override
	public List<Words> findByExampleWithLike(Words words) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Words> findAll() 
	{
		log.debug("finding All Words");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Words a");
            List<Words> results = (List<Words>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
	}
	
}