package com.ust.dao.Impl;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.WordsMediaDaoApi;
import com.ust.entity.WordsMedia;





@Repository
@Transactional

public class WordsMediaDaoImpl implements WordsMediaDaoApi
{
	private static final Log log = LogFactory.getLog(WordsMediaDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


@Override
public void persist(WordsMedia wordsmedia)
{
	log.debug("persisting WordsMedia instance");
    try {
        sessionFactory.getCurrentSession().persist(wordsmedia);
        log.debug("persist successful");
    } catch (RuntimeException re) {
        log.error("persist failed", re);
        throw re;
    }
	// TODO Auto-generated method stub
	
}

@Override
public void attachDirty(WordsMedia wordsmedia) 
{
	 log.debug("attaching dirty WordsMedia instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(wordsmedia);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
	// TODO Auto-generated method stub
	
}

@Override
public void attachClean(WordsMedia wordsmedia) 
{
	log.debug("attaching clean WordsMedia instance");
    try {
        sessionFactory.getCurrentSession().lock(wordsmedia, LockMode.NONE);
        log.debug("attach successful");
    } catch (RuntimeException re) {
        log.error("attach failed", re);
        throw re;
    }
	// TODO Auto-generated method stub
	
}

@Override
public void delete(WordsMedia wordsmedia) 
{
	log.debug("deleting TblWordsMedia instance");
    try {
        sessionFactory.getCurrentSession().delete(wordsmedia);
        log.debug("delete successful");
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        throw re;
    }
	// TODO Auto-generated method stub
	
}

@Override
public WordsMedia merge(WordsMedia wordsmedia) 
{
	 log.debug("merging WordsMedia instance");
        try {
            WordsMedia result = (WordsMedia) sessionFactory
                    .getCurrentSession().merge(wordsmedia);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	// TODO Auto-generated method stub
}

@Override
public WordsMedia findById(int id) 
{
	String qry = "Select a from WordsMedia a where a.wordsmediaId = "+id;
    try {
        WordsMedia wordsmedia = (WordsMedia) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
        log.debug("find by Id successful");
        return wordsmedia;
    } catch (RuntimeException re) {
        log.error("find by Id failed", re);
        throw re;
    }
	// TODO Auto-generated method stub
}

@Override
public List<WordsMedia> findByExampleWithLike(WordsMedia wordsmedia) 
{
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<WordsMedia> findAll() 
{
	log.debug("finding All WordsMedia");
    try {

        StringBuilder qry = new StringBuilder();
        qry.append("select a from WordsMedia a");
        List<WordsMedia> results = (List<WordsMedia>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
        log.debug("find All successful, result size: "+ results.size());
        return results;
    } catch (RuntimeException re) {
        log.error("find All failed", re);
        throw re;
    }
	// TODO Auto-generated method stub
}

	 

	
}