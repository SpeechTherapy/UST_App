package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.SentencesMediaDaoApi;
import com.ust.entity.SentencesMedia;


@Repository
@Transactional
public class SentencesMediaDaoImpl implements SentencesMediaDaoApi
{

	private static final Log log = LogFactory.getLog(SentencesMediaDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
	@Override
	public void persist(SentencesMedia sentencesmedia) 
	{
		log.debug("persisting SentencesMedia instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(sentencesmedia);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(SentencesMedia sentencesmedia) 
	{
		log.debug("attaching dirty SentencesMedia instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(sentencesmedia);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(SentencesMedia sentencesmedia) 
	{
		log.debug("attaching clean SentencesMedia instance");
        try {
            sessionFactory.getCurrentSession().lock(sentencesmedia, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SentencesMedia sentencesmedia) 
	{
		 log.debug("deleting TblSentencesMedia instance");
	        try {
	            sessionFactory.getCurrentSession().delete(sentencesmedia);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public SentencesMedia merge(SentencesMedia sentencesmedia) 
	{
		log.debug("merging SentencesMedia instance");
        try {
            SentencesMedia result = (SentencesMedia) sessionFactory
                    .getCurrentSession().merge(sentencesmedia);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public SentencesMedia findById(int id) 
	{
		String qry = "Select a from SentencesMedia a where a.sentencesmediaId = "+id;// entity class name hai SentencesMedia table ka name nahi hai
        try {
            SentencesMedia sentencesmedia = (SentencesMedia) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return sentencesmedia;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<SentencesMedia> findByExampleWithLike(SentencesMedia sentencesmedia) 
	{
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SentencesMedia> findAll() 
	{
		log.debug("finding All SentencesMedia");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from SentencesMedia a");
            List<SentencesMedia> results = (List<SentencesMedia>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
	
}