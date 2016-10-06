package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.GameDaoApi;
import com.ust.entity.Game;
import com.ust.service.api.GameServiceApi;

@Service
public class GameServiceImpl implements GameServiceApi {
	
	@Autowired
	private GameDaoApi gameDaoApi;

	@Override
	public void save(Game game) {
		gameDaoApi.persist(game);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Game game) {
		gameDaoApi.attachDirty(game);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Game game) {
		gameDaoApi.merge(game);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Game game) {
		// TODO Auto-generated method stub
		gameDaoApi.delete(game);
	}

	@Override
	public Game findById(int id) {
		return gameDaoApi.findById(id);
	}

	@Override
	public List<Game> findByGame(Game game) {
		return gameDaoApi.findByExampleWithLike(game);
	}

	@Override
	public List<Game> findAll() {
		return gameDaoApi.findAll();
	}

}