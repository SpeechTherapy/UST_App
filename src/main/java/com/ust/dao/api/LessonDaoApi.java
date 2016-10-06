package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Lesson;

public interface LessonDaoApi {
	public abstract void persist(Lesson lesson); //save

    public abstract void attachDirty(Lesson lesson); //save and update

    public abstract void attachClean(Lesson lesson); //clean 

    public abstract void delete(Lesson lesson); //used for record del

    public abstract Lesson merge(Lesson lesson); //used for updation

    public abstract Lesson findById(int id); //search
    

    public abstract List<Lesson> findByExampleWithLike(Lesson lesson);

    public abstract List<Lesson> findAll();
    
    public abstract Lesson findLesson(int id);

}
