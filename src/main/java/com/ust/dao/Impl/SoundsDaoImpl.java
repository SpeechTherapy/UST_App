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

import com.ust.dao.api.SoundsDaoApi;
import com.ust.entity.Sounds;
@Repository
@Transactional
public class SoundsDaoImpl implements SoundsDaoApi {
	private static final Log log = LogFactory.getLog(SoundsDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

@Override
public void persist(Sounds sounds) {
	// TODO Auto-generated method stub
	log.debug("persisting Sounds instance");
    try { //null asakti hai toh isliye use kiya hai 
        sessionFactory.getCurrentSession().persist(sounds);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
        log.debug("persist successful");
    } catch (RuntimeException re) {
        log.error("persist failed", re);
        throw re;
    }
	
}

@Override
public void attachDirty(Sounds sounds) {
	// TODO Auto-generated method stub
	log.debug("attaching dirty Sounds instance");
    try {
        sessionFactory.getCurrentSession().saveOrUpdate(sounds);
        log.debug("attach successful");
    } catch (RuntimeException re) {
        log.error("attach failed", re);
        throw re;
    }
}

@Override
public void attachClean(Sounds sounds) {
	// TODO Auto-generated method stub
	 log.debug("attaching clean Sounds instance");
        try {
            sessionFactory.getCurrentSession().lock(sounds, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
}

@Override
public void delete(Sounds sounds) {
	// TODO Auto-generated method stub
	 log.debug("deleting TblSounds instance");
        try {
            sessionFactory.getCurrentSession().delete(sounds);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
}

@Override
public Sounds merge(Sounds sounds) {
	// TODO Auto-generated method stub
	log.debug("merging Sounds instance");
    try {
        Sounds result = (Sounds) sessionFactory
                .getCurrentSession().merge(sounds);
        log.debug("merge successful");
        return result;
    } catch (RuntimeException re) {
        log.error("merge failed", re);
        throw re;
    }
}

@Override
public Sounds findById(int id) {
	// TODO Auto-generated method stub
	String qry = "Select a from Sounds a where a.soundsId = "+id;// entity class name hai Sounds table ka name nahi hai
    try {
        Sounds sounds = (Sounds) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
        log.debug("find by Id successful");
        if(sounds!=null)
        {
        	Hibernate.initialize(sounds.getLesson());
        	Hibernate.initialize(sounds.getMedia());
        }
        return sounds;
    } catch (RuntimeException re) {
        log.error("find by Id failed", re);
        throw re;
    }
}

@Override
public List<Sounds> findByExampleWithLike(Sounds sounds) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Sounds> findAll() {
	// TODO Auto-generated method stub
	log.debug("finding All Sounds");
    try {

        StringBuilder qry = new StringBuilder();
        qry.append("select a from Sounds a");
        List<Sounds> results = (List<Sounds>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
        log.debug("find All successful, result size: "+ results.size());
        return results;
    } catch (RuntimeException re) {
        log.error("find All failed", re);
        throw re;
    }
}

}
