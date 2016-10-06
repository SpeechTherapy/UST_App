package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.AdminDaoApi;
import com.ust.entity.Admin;
import com.ust.entity.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDaoApi{

	

    private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
	
	
	
	@Override
	public int persist(Admin admin) {
		log.debug("persisting Admin instance");
        try { 
            sessionFactory.getCurrentSession().persist(admin);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            sessionFactory.getCurrentSession().flush();
            
            log.debug("persist successful");

            return admin.getAdminId();
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
	}

	@Override
	public void attachDirty(Admin admin) {
		// TODO Auto-generated method stub
		  log.debug("attaching dirty Admin instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(admin);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
	}

	@Override
	public void attachClean(Admin admin) {
		// TODO Auto-generated method stub
		 log.debug("attaching clean Admin instance");
	        try {
	            sessionFactory.getCurrentSession().lock(admin, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		 log.debug("deleting TblAdmin instance");
	        try {
	            sessionFactory.getCurrentSession().delete(admin);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	}

	@Override
	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
        try {
            Admin result = (Admin) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public Admin findById(int id) {
		String qry = "Select a from Admin a where a.adminId = "+id;
        try {
            Admin admin = (Admin) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            
            return admin;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<Admin> findByExampleWithLike(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		log.debug("finding All Admin");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Admin a");
            List<Admin> results = (List<Admin>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}

}
