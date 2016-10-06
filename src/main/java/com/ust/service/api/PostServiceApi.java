/**
 * 
 */
package com.ust.service.api;

import java.util.List;

import com.ust.entity.Post;

/**
 * @author ShaNzaKhan
 *
 */
public interface PostServiceApi {
	
	public abstract void save(Post post);

    public void saveOrUpdate(Post post);

    public abstract void update(Post post);

    public abstract void delete(Post post);

    public abstract Post findById(int id);

    public abstract List<Post> findByPost(Post post);

    public abstract List<Post> findAll();

}
