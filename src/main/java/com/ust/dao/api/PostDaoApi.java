/**
 * 
 */
package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Post;

/**
 * @author ShaNzaKhan
 *
 */
public interface PostDaoApi {
	
	public abstract void persist(Post post);

    public abstract void attachDirty(Post post);

    public abstract void attachClean(Post post);

    public abstract void delete(Post post);

    public abstract Post merge(Post post);

    public abstract Post findById(int id);

    public abstract List<Post> findByExampleWithLike(Post post);

    public abstract List<Post> findAll();


}
