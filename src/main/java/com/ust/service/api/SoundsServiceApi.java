package com.ust.service.api;

import java.util.List;

import com.ust.entity.Sounds;

public interface SoundsServiceApi {
	
	public abstract void save(Sounds sounds);

    public void saveOrUpdate(Sounds sounds);

    public abstract void update(Sounds sounds);

    public abstract void delete(Sounds sounds);

    public abstract Sounds findById(int id);

    public abstract List<Sounds> findBySounds(Sounds sounds);

    public abstract List<Sounds> findAll();

}
