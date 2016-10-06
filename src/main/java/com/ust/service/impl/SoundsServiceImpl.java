package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.SoundsDaoApi;
import com.ust.entity.Sounds;
import com.ust.service.api.SoundsServiceApi;
@Service
public class SoundsServiceImpl implements SoundsServiceApi{
	@Autowired
	private SoundsDaoApi soundsDaoApi;

	@Override
	public void save(Sounds sounds) {
		soundsDaoApi.persist(sounds);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Sounds sounds) {
		soundsDaoApi.attachDirty(sounds);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sounds sounds) {
		soundsDaoApi.merge(sounds);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sounds sounds) {
		// TODO Auto-generated method stub
		soundsDaoApi.delete(sounds);
	}

	@Override
	public Sounds findById(int id) {
		return soundsDaoApi.findById(id);
	}

	@Override
	public List<Sounds> findBySounds(Sounds sounds) {
		return soundsDaoApi.findByExampleWithLike(sounds);
	}

	@Override
	public List<Sounds> findAll() {
		return soundsDaoApi.findAll();
	}


}
