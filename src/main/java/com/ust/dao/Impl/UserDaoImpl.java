package com.ust.dao.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.UserDaoApi;
import com.ust.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDaoApi {
	
    private static final Log log = LogFactory.getLog(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int persist(User user) {//return void krta hai but use
		
		 log.debug("persisting User instance");
	        try { 
	            sessionFactory.getCurrentSession().persist(user); 
	            sessionFactory.getCurrentSession().flush();
	            
	            log.debug("persist successful");

	            return user.getUserId();
	        } catch (RuntimeException re) {
	            log.error("persist failed", re);
	            throw re;
	        }
		
	}

    @Override
    public void attachDirty(User user) { 
        log.debug("attaching dirty User instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(user);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void attachClean(User user) {
        log.debug("attaching clean User instance");
        try {
            sessionFactory.getCurrentSession().lock(user, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    @Override
    public void delete(User user) {
        log.debug("deleting TblUser instance");
        try {
            sessionFactory.getCurrentSession().delete(user);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    @Override
    public User merge(User detachedInstance) {
        log.debug("merging User instance");
        try {
            User result = (User) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public User findById(int id) { 
    	String qry = "Select a from User a where a.userId = "+id;
        try {
            User user = (User) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            if(user!=null){
            	Hibernate.initialize (user.getTherapist());
            	Hibernate.initialize( user.getPatient());
            	Hibernate.initialize(user.getAdmin());
            }
            log.debug("find by Id successful");
            
            return user;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
    }


    @Override
	public List<User> findByExampleWithLike(User user) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public List<User> findAll() {
		 log.debug("finding All User");
	        try {

	            StringBuilder qry = new StringBuilder();
	            qry.append("select a from User a");
	            List<User> results = (List<User>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
	            log.debug("find All successful, result size: "+ results.size());
	            return results;
	        } catch (RuntimeException re) {
	            log.error("find All failed", re);
	            throw re;
	        }
	}

	@Override
	public User LoginUser(String username,String password) {
		StringBuilder qry = new StringBuilder();
		qry.append("select a from User a where ");
		qry.append("a.userName = '"+username+"'");
		//qry.append(" or ");
		//qry.append("a.email = '"+username+"'");


		qry.append(" and ");
		qry.append("a.userPassword = '"+password+"'");
		
		System.out.println("User name  in Dao "+username+"Password"+password);
		
		try {
            User user = (User) sessionFactory.getCurrentSession().createQuery(qry.toString()).uniqueResult();
            if(user!=null){
            	Hibernate.initialize (user.getTherapist());
            	Hibernate.initialize( user.getPatient());
            	Hibernate.initialize(user.getAdmin());
            }
            log.debug("find by Id successful");
            return user;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }		
	}
	
	@Override
    public User findByEmail(String email) { //yaha query lagi hai isliye kyu k yeh hm ny khud banaya hai for customization result
    	String str = "Select a from User a where a.email = :email";// entity class name hai User table ka name nahi hai
    	Query query = sessionFactory.getCurrentSession().createQuery(str);
        query.setParameter("email",email);
    	try {
            User user = (User) query.uniqueResult();
            log.debug("find by Email successful");
            return user;
        } catch (RuntimeException re) {
            log.error("find by Email failed", re);
            throw re;
        }
    }
	
	

	
}
