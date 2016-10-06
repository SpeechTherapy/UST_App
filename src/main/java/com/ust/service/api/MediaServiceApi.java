package com.ust.service.api;

import java.util.List;

import com.ust.entity.Media;

public interface MediaServiceApi
{
	 public abstract void save(Media media);

	    public void saveOrUpdate(Media media);

	    public abstract void update(Media media);

	    public abstract void delete(Media media);

	    public abstract Media findById(int id);

	    public abstract List<Media> findByMedia(Media media);

	    public abstract List<Media> findAll();	
}