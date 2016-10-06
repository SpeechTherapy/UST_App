package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.PostDaoApi;
import com.ust.dao.api.PostDaoApi;
import com.ust.entity.Post;
import com.ust.entity.Post;
import com.ust.service.api.PostServiceApi;
@Service
public class PostServiceImpl implements PostServiceApi {
	
	@Autowired
	private PostDaoApi postDaoApi;

	@Override
	public void save(Post post) {

		postDaoApi.persist(post);
	}

	@Override
	public void saveOrUpdate(Post post) {

		postDaoApi.attachDirty(post);
		
	}

	@Override
	public void update(Post post) {

		postDaoApi.merge(post);
	}

	@Override
	public void delete(Post post) {

		postDaoApi.delete(post);
	}

	@Override
	public Post findById(int id) {

		return postDaoApi.findById(id);
	}

	@Override
	public List<Post> findByPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postDaoApi.findAll();
	}
	
	


}
