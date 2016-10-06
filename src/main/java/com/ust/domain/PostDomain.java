package com.ust.domain;

public class PostDomain {

	private int postId;
	private int therapist;
	private String blogHeading;
	private String blogBody;
	private int status;
	private String blogpic;
	
	
	
	
	public String getBlogpic() {
		return blogpic;
	}
	public void setBlogpic(String blogpic) {
		this.blogpic = blogpic;
	}
	public int getTherapist() {
		return therapist;
	}
	public void setTherapist(int therapist) {
		this.therapist = therapist;
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
