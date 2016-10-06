package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.AssignedChapterTherapistDaoApi;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.AssignedChapterTherapist;

@Repository
@Transactional

public class AssignedChapterTherapistDaoImpl implements AssignedChapterTherapistDaoApi {
    private static final Log log = LogFactory.getLog(AssignedChapterTherapistDaoImpl.class);

	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public void persist(AssignedChapterTherapist assignedchaptertherapist) {
		log.debug("persisting AssignedChapterTherapist instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(assignedchaptertherapist);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		
	}

	@Override
	public void attachDirty(AssignedChapterTherapist assignedchaptertherapist) {
		 log.debug("attaching dirty AssignedChapterTherapist instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(assignedchaptertherapist);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		
	}

	@Override
	public void attachClean(AssignedChapterTherapist assignedchaptertherapist) {
		 log.debug("attaching clean AssignedChapterTherapist instance");
	        try {
	            sessionFactory.getCurrentSession().lock(assignedchaptertherapist, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		
	}

	@Override
	public void delete(AssignedChapterTherapist assignedchaptertherapist) {
		  log.debug("deleting TblAssignedChapterTherapist instance");
	        try {
	            sessionFactory.getCurrentSession().delete(assignedchaptertherapist);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
		
	}

	@Override
	public AssignedChapterTherapist merge(AssignedChapterTherapist assignedchaptertherapist) {
		 log.debug("merging AssignedChapterTherapist instance");
	        try {
	            AssignedChapterTherapist result = (AssignedChapterTherapist) sessionFactory
	                    .getCurrentSession().merge(assignedchaptertherapist);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
	}

	@Override
	public AssignedChapterTherapist findById(int id) {
		String qry = "Select a from AssignedChapterTherapist a where a.assignedchapterId = "+id;
		try {
            AssignedChapterTherapist assignedchaptertherapist = (AssignedChapterTherapist) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return assignedchaptertherapist;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	

	@Override
	public List<AssignedChapterTherapist> findByExampleWithLike(AssignedChapterTherapist assignedchaptertherapist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssignedChapterTherapist> findAll() {
		log.debug("finding All AssignedChapterTherapist");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from AssignedChapterTherapist a");
            List<AssignedChapterTherapist> results = (List<AssignedChapterTherapist>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }

}
}
