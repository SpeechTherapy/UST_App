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

import com.ust.dao.api.SentencesDaoApi;
import com.ust.entity.Sentences;
@Repository
@Transactional
public class SentencesDaoImpl implements SentencesDaoApi{
	private static final Log log = LogFactory.getLog(SentencesDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

@Override
public void persist(Sentences sentences) {
	// TODO Auto-generated method stub
	log.debug("persisting Sentences instance");
    try { //null asakti hai toh isliye use kiya hai 
        sessionFactory.getCurrentSession().persist(sentences);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
        log.debug("persist successful");
    } catch (RuntimeException re) {
        log.error("persist failed", re);
        throw re;
    }
	
}

@Override
public void attachDirty(Sentences sentences) {
	// TODO Auto-generated method stub
	log.debug("attaching dirty Sentences instance");
    try {
        sessionFactory.getCurrentSession().saveOrUpdate(sentences);
        log.debug("attach successful");
    } catch (RuntimeException re) {
        log.error("attach failed", re);
        throw re;
    }
}

@Override
public void attachClean(Sentences sentences) {
	// TODO Auto-generated method stub
	 log.debug("attaching clean Sentences instance");
        try {
            sessionFactory.getCurrentSession().lock(sentences, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
}

@Override
public void delete(Sentences sentences) {
	// TODO Auto-generated method stub
	 log.debug("deleting TblSentences instance");
        try {
            sessionFactory.getCurrentSession().delete(sentences);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
}

@Override
public Sentences merge(Sentences sentences) {
	// TODO Auto-generated method stub
	log.debug("merging Sentences instance");
    try {
        Sentences result = (Sentences) sessionFactory
                .getCurrentSession().merge(sentences);
        log.debug("merge successful");
        return result;
    } catch (RuntimeException re) {
        log.error("merge failed", re);
        throw re;
    }
}

@Override
public Sentences findById(int id) {
	// TODO Auto-generated method stub
	String qry = "Select a from Sentences a where a.sentencesId = "+id;// entity class name hai Sentences table ka name nahi hai
    try {
        Sentences sentences = (Sentences) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
        log.debug("find by Id successful");
        if(sentences!=null)
        {
        	Hibernate.initialize(sentences.getLesson());
        	Hibernate.initialize(sentences.getMedia());
        }
        return sentences;
    } catch (RuntimeException re) {
        log.error("find by Id failed", re);
        throw re;
    }
}

@Override
public List<Sentences> findByExampleWithLike(Sentences sentences) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Sentences> findAll() {
	// TODO Auto-generated method stub
	log.debug("finding All Sentences");
    try {

        StringBuilder qry = new StringBuilder();
        qry.append("select a from Sentences a");
        List<Sentences> results = (List<Sentences>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
        log.debug("find All successful, result size: "+ results.size());
        return results;
    } catch (RuntimeException re) {
        log.error("find All failed", re);
        throw re;
    }
}

}
