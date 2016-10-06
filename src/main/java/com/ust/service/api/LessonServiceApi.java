package com.ust.service.api;

import java.util.List;

import com.ust.entity.Lesson;

public interface LessonServiceApi {

	public abstract void save(Lesson lesson);

    public void saveOrUpdate(Lesson lesson);

    public abstract void update(Lesson lesson);

    public abstract void delete(Lesson lesson);

    public abstract Lesson findById(int id);

    public abstract List<Lesson> findByLesson(Lesson lesson);

    public abstract List<Lesson> findAll();
    
    public abstract Lesson findLesson(int id);
}
