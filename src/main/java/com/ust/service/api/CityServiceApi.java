package com.ust.service.api;

import java.util.List;

import com.ust.entity.City;

public interface CityServiceApi {
	 public abstract int save(City city);

	    public void saveOrUpdate(City city);

	    public abstract void update(City city);

	    public abstract void delete(City city);

	    public abstract City findById(int id);

	    public abstract List<City> findByCity(City city);

	    public abstract List<City> findAll();

}
