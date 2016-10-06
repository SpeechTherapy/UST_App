package com.ust.service.api;

import java.util.List;

import com.ust.entity.Information;;

public interface InformationServiceApi
{
	public abstract void save(Information information);

    public void saveOrUpdate(Information information);

    public abstract void update(Information information);

    public abstract void delete(Information information);

    public abstract Information findById(int id);

    public abstract List<Information> findByInformation(Information information);

    public abstract List<Information> findAll();
}