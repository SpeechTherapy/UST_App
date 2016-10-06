/**
 * 
 */
package com.ust.dao.Impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.PostDaoApi;
import com.ust.entity.Patient;
import com.ust.entity.Post;
import com.ust.entity.Therapist;

/**
 * @author ShaNzaKhan
 *
 */

@Repository
@Transactional
public class PostDaoImpl implements PostDaoApi {
	

    private static final Log log = LogFactory.getLog(PostDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void persist(Post post) {
		
		 log.debug("persisting Post instance");
	        try {
	            sessionFactory.getCurrentSession().persist(post);
	            log.debug("persist successful");
	        } catch (RuntimeException re) {
	            log.error("persist failed", re);
	            throw re;
	        }
		
	}

    @Override
    public void attachDirty(Post post) {
        log.debug("attaching dirty Post instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(post);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void attachClean(Post post) {
        log.debug("attaching clean Post instance");
        try {
            sessionFactory.getCurrentSession().lock(post, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void delete(Post post) {
        log.debug("deleting TblPost instance");
        try {
            sessionFactory.getCurrentSession().delete(post);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    @Override
    public Post merge(Post detachedInstance) {
        log.debug("merging Post instance");
        try {
            Post result = (Post) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
	public List<Post> findByExampleWithLike(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public List<Post> findAll() {
		 log.debug("finding All Post");
	        try {

	            StringBuilder qry = new StringBuilder();
	            qry.append("select a from Post a");
	            List<Post> results = (List<Post>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
	            log.debug("find All successful, result size: "+ results.size());
	            if(results.size() > 0){
	            	for(Post post : results){
	            		Hibernate.initialize(post.getTherapist());
	            	}

	            	}
	            return results;
	        } catch (RuntimeException re) {
	            log.error("find All failed", re);
	            throw re;
	        }
	}
   
    @Override
    public Post findById(int id) {
    	String qry = "Select a from Post a where a.postId = "+id;
       
            Post post = (Post) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            
            return post;
        
    }
    

}
