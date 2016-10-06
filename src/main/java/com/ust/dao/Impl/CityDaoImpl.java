package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.CityDaoApi;
import com.ust.entity.City;
import com.ust.entity.City;

@Repository
@Transactional
public class CityDaoImpl implements CityDaoApi {
	

    private static final Log log = LogFactory.getLog(CityDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public int persist(City city) {
		log.debug("persisting City instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(city);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
            return city.getCityId();
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void attachDirty(City city) {
		 log.debug("attaching dirty City instance");
	        try {
	            sessionFactory.getCurrentSession().saveOrUpdate(city);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(City city) {
		log.debug("attaching clean City instance");
        try {
            sessionFactory.getCurrentSession().lock(city, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(City city) {
		 log.debug("deleting TblCity instance");
	        try {
	            sessionFactory.getCurrentSession().delete(city);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }// TODO Auto-generated method stub
		
	}

	@Override
	public City merge(City city) {
		 log.debug("merging City instance");
	        try {
	            City result = (City) sessionFactory
	                    .getCurrentSession().merge(city);
	            log.debug("merge successful");
	            return result;
	        } catch (RuntimeException re) {
	            log.error("merge failed", re);
	            throw re;
	        }
	}

	@Override
	public City findById(int id) {
		String qry = "Select a from City a where a.cityId = "+id;// entity class name hai City table ka name nahi hai
        try {
            City city = (City) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return city;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	

	@Override
	public List<City> findByExampleWithLike(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findAll() {
		log.debug("finding All City");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from City a");
            List<City> results = (List<City>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}
}


