package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Media;

public interface MediaDaoApi
{

	public abstract void persist(Media media); //save

    public abstract void attachDirty(Media media); //save and update

    public abstract void attachClean(Media media); //clean 

    public abstract void delete(Media media); //used for record del

    public abstract Media merge(Media media); //used for updation

    public abstract Media findById(int id); //search
    

    public abstract List<Media> findByExampleWithLike(Media media);

    public abstract List<Media> findAll();
}