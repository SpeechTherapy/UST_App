package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Game;

public interface GameDaoApi {
	public abstract void persist(Game game); //save

    public abstract void attachDirty(Game game); //save and update

    public abstract void attachClean(Game game); //clean 

    public abstract void delete(Game game); //used for record del

    public abstract Game merge(Game game); //used for updation

    public abstract Game findById(int id); //search
    

    public abstract List<Game> findByExampleWithLike(Game game);

    public abstract List<Game> findAll();

}
