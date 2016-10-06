package com.ust.dao.api;

import java.util.List;

import com.ust.entity.SoundsMedia;


public interface SoundsMediaDaoApi
{
	public abstract void persist(SoundsMedia soundsmedia); //save

    public abstract void attachDirty(SoundsMedia soundsmedia); //save and update

    public abstract void attachClean(SoundsMedia soundsmedia); //clean 

    public abstract void delete(SoundsMedia soundsmedia); //used for record del

    public abstract SoundsMedia merge(SoundsMedia soundsmedia); //used for updation

    public abstract SoundsMedia findById(int id); //search
    

    public abstract List<SoundsMedia> findByExampleWithLike(SoundsMedia soundsmedia);

    public abstract List<SoundsMedia> findAll();
}