package com.ust.dao.api;

import java.util.List;

import com.ust.entity.City;

public interface CityDaoApi {
	public abstract int persist(City city); //save

    public abstract void attachDirty(City city); //save and update

    public abstract void attachClean(City city); //clean 

    public abstract void delete(City city); //used for record del

    public abstract City merge(City city); //used for updation

    public abstract City findById(int id); //search
    

    public abstract List<City> findByExampleWithLike(City city);

    public abstract List<City> findAll();

}
