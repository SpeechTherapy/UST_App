package com.ust.service.api;

import java.util.List;

import com.ust.entity.Game;

public interface GameServiceApi {
	public abstract void save(Game game);

    public void saveOrUpdate(Game game);

    public abstract void update(Game game);

    public abstract void delete(Game game);

    public abstract Game findById(int id);

    public abstract List<Game> findByGame(Game game);

    public abstract List<Game> findAll();

}
