package com.ust.service.api;

import java.util.List;

import com.ust.entity.SoundsMedia;

public interface SoundsMediaServiceApi
{
	 public abstract void save(SoundsMedia soundsmedia);

	    public void saveOrUpdate(SoundsMedia soundsmedia);

	    public abstract void update(SoundsMedia soundsmedia);

	    public abstract void delete(SoundsMedia soundsmedia);

	    public abstract SoundsMedia findById(int id);

	    public abstract List<SoundsMedia> findBySoundsMedia(SoundsMedia soundsmedia);

	    public abstract List<SoundsMedia> findAll();
}