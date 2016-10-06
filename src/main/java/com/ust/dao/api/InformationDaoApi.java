package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Information;

public interface InformationDaoApi
{
	public abstract void persist(Information information); //save

    public abstract void attachDirty(Information information); //save and update

    public abstract void attachClean(Information information); //clean 

    public abstract void delete(Information information); //used for record del

    public abstract Information merge(Information information); //used for updation

    public abstract Information findById(int id); //search
    

    public abstract List<Information> findByExampleWithLike(Information information);

    public abstract List<Information> findAll();
}