package com.ust.dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.api.GameDaoApi;
import com.ust.entity.Game;

@Repository
@Transactional

public class GameDaoImpl implements GameDaoApi{
	
	 private static final Log log = LogFactory.getLog(GameDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public void persist(Game game) {
		// TODO Auto-generated method stub
		log.debug("persisting Game instance");
        try { //null asakti hai toh isliye use kiya hai 
            sessionFactory.getCurrentSession().persist(game);//yeh hibernate ko call krrhe hai insert ki query is k andr hai 
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		
	}

	@Override
	public void attachDirty(Game game) {
		// TODO Auto-generated method stub
		log.debug("attaching dirty Game instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(game);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
		
	}

	@Override
	public void attachClean(Game game) {
		// TODO Auto-generated method stub
		 log.debug("attaching clean Game instance");
	        try {
	            sessionFactory.getCurrentSession().lock(game, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
		
	}

	@Override
	public void delete(Game game) {
		// TODO Auto-generated method stub
		 log.debug("deleting TblGame instance");
	        try {
	            sessionFactory.getCurrentSession().delete(game);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
		
	}

	@Override
	public Game merge(Game game) {
		// TODO Auto-generated method stub
		log.debug("merging Game instance");
        try {
            Game result = (Game) sessionFactory
                    .getCurrentSession().merge(game);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public Game findById(int id) {
		String qry = "Select a from Game a where a.gameId = "+id;// entity class name hai Game table ka name nahi hai
        try {
            Game game = (Game) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            return game;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }

	}

	@Override
	public List<Game> findByExampleWithLike(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> findAll() {
		// TODO Auto-generated method stub
				log.debug("finding All Game");
		        try {

		            StringBuilder qry = new StringBuilder();
		            qry.append("select a from Game a");
		            List<Game> results = (List<Game>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
		            log.debug("find All successful, result size: "+ results.size());
		            return results;
		        } catch (RuntimeException re) {
		            log.error("find All failed", re);
		            throw re;
		        }
			}

	}


