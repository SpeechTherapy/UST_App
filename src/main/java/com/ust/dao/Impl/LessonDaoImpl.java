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

import com.ust.controller.AssignmentController;
import com.ust.dao.api.LessonDaoApi;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Patient;
import com.ust.entity.Sentences;
import com.ust.entity.Sounds;
import com.ust.entity.Words;
import com.ust.entity.Lesson;


@Repository
@Transactional
public class LessonDaoImpl implements LessonDaoApi{

	 private static final Log log = LogFactory.getLog(LessonDaoImpl.class);

	    @Autowired
	    private SessionFactory sessionFactory;
	@Override
	public void persist(Lesson lesson) {
		// TODO Auto-generated method stub
		log.debug("persisting Lesson instance");
        try { 
            sessionFactory.getCurrentSession().persist(lesson);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		
	}

	@Override
	public void attachDirty(Lesson lesson) {
		// TODO Auto-generated method stub
		log.debug("attaching dirty Lesson instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(lesson);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
	}

	@Override
	public void attachClean(Lesson lesson) {
		// TODO Auto-generated method stub
		 log.debug("attaching clean Lesson instance");
	        try {
	            sessionFactory.getCurrentSession().lock(lesson, LockMode.NONE);
	            log.debug("attach successful");
	        } catch (RuntimeException re) {
	            log.error("attach failed", re);
	            throw re;
	        }
	}

	@Override
	public void delete(Lesson lesson) {
		// TODO Auto-generated method stub
		 log.debug("deleting TblLesson instance");
	        try {
	            sessionFactory.getCurrentSession().delete(lesson);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	}

	@Override
	public Lesson merge(Lesson lesson) {
		// TODO Auto-generated method stub
		log.debug("merging Lesson instance");
        try {
            Lesson result = (Lesson) sessionFactory
                    .getCurrentSession().merge(lesson);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
	}

	@Override
	public Lesson findById(int id) {
		// TODO Auto-generated method stub
		String qry = "Select a from Lesson a where a.lessonId = "+id;
        try {
            Lesson lesson = (Lesson) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(lesson!=null)
            {
            	Hibernate.initialize(lesson);
            	if(lesson.getSounds()!=null)
            	{
            		Set<Sounds> soundSet = lesson.getSounds();
            		for(Sounds sound: soundSet)
            		{
            			Hibernate.initialize(sound);
            			
                			Hibernate.initialize(sound.getMedia());

                		

            		}       
            	}
            	if(lesson.getWords()!=null)
            	{
            		Set<Words> wordSet = lesson.getWords();
            		for(Words word: wordSet)
            		{
            			Hibernate.initialize(word);
            			Hibernate.initialize(word.getMedia());


            		}       
            	}
            	if(lesson.getSentences()!=null)
            	{
            		Set<Sentences> sentencesSet = lesson.getSentences();
            		for(Sentences sentences: sentencesSet)
            		{
            			Hibernate.initialize(sentences);
            			Hibernate.initialize(sentences.getMedia());


            		}       
            	}
            }
            return lesson;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

	@Override
	public List<Lesson> findByExampleWithLike(Lesson lesson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding All Lesson");
        try {

            StringBuilder qry = new StringBuilder();
            qry.append("select a from Lesson a");
            List<Lesson> results = (List<Lesson>) sessionFactory.getCurrentSession().createQuery(qry.toString()).list();
            log.debug("find All successful, result size: "+ results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find All failed", re);
            throw re;
        }
	}

	@Override
	public Lesson findLesson(int id) {
		String qry = "Select a from Lesson a where a.lessonId = "+id;
        try {
            Lesson lesson = (Lesson) sessionFactory.getCurrentSession().createQuery(qry).uniqueResult();
            log.debug("find by Id successful");
            if(lesson!=null)
            {
            	Hibernate.initialize(lesson);
            	if(lesson.getAssignedChapterTherapist()!=null)
            	{
            		Set<AssignedChapterTherapist> assignedChapterTherapistSet = lesson.getAssignedChapterTherapist();
            		for(AssignedChapterTherapist assignedChapterTherapist: assignedChapterTherapistSet)
            		{
            			Hibernate.initialize(assignedChapterTherapist);

            		}       
            	}
            	
            }
            return lesson;
        } catch (RuntimeException re) {
            log.error("find by Id failed", re);
            throw re;
        }
	}

}
