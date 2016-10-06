package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Sounds;

public interface SoundsDaoApi {
	public abstract void persist(Sounds sounds); //save

    public abstract void attachDirty(Sounds sounds); //save and update

    public abstract void attachClean(Sounds sounds); //clean 

    public abstract void delete(Sounds sounds); //used for record del

    public abstract Sounds merge(Sounds sounds); //used for updation

    public abstract Sounds findById(int id); //search
    

    public abstract List<Sounds> findByExampleWithLike(Sounds sounds);

    public abstract List<Sounds> findAll();

}
