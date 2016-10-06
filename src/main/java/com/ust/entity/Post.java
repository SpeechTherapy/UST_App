package com.ust.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="post")
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Post_id",nullable = false)
	private int postId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Therapist_writer",nullable = false) 
	private Therapist therapist;
	
	@Column(name="Blog_Heading", nullable = false)
	private String blogHeading;
	
	@Column(name="Blog_Pic", nullable = true)
	private String blogpic;
	
	@Column(name="Blog_Body", nullable = false)
	private String blogBody;

	@Column(name="Status", nullable = false)
	private int status;
	
	
	
	public String getBlogpic() {
		return blogpic;
	}

	public void setBlogpic(String blogpic) {
		this.blogpic = blogpic;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}


	

	public Therapist getTherapist() {
		return therapist;
	}

	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
	}

	public String getBlogHeading() {
		return blogHeading;
	}

	public void setBlogHeading(String blogHeading) {
		this.blogHeading = blogHeading;
	}

	public String getBlogBody() {
		return blogBody;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}
	
	
	
	
}
