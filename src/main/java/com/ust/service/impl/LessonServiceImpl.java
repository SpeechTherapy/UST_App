package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.LessonDaoApi;
import com.ust.entity.Lesson;
import com.ust.service.api.LessonServiceApi;

@Service

public class LessonServiceImpl implements LessonServiceApi {
	
	
	@Autowired
	private LessonDaoApi lessonDaoApi;

	@Override
	public void save(Lesson lesson) {
		lessonDaoApi.persist(lesson);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Lesson lesson) {
		lessonDaoApi.attachDirty(lesson);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Lesson lesson) {
		lessonDaoApi.merge(lesson);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Lesson lesson) {
		// TODO Auto-generated method stub
		lessonDaoApi.delete(lesson);
	}

	@Override
	public Lesson findById(int id) {
		return lessonDaoApi.findById(id);
	}

	@Override
	public List<Lesson> findByLesson(Lesson lesson) {
		return lessonDaoApi.findByExampleWithLike(lesson);
	}

	@Override
	public List<Lesson> findAll() {
		return lessonDaoApi.findAll();
	}

	@Override
	public Lesson findLesson(int id) {
		// TODO Auto-generated method stub
		return lessonDaoApi.findLesson(id);
	}

}


