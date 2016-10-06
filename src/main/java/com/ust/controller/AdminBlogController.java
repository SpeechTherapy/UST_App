package com.ust.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.entity.Patient;
import com.ust.entity.Post;
import com.ust.entity.User;
import com.ust.service.api.PostServiceApi;

@Controller

public class AdminBlogController
{
	
	@Autowired PostServiceApi postServiceApi;
	@RequestMapping(value = "AdminBlog")
	public ModelAndView AdminBlog(Model model) {
		ModelAndView modelAndView = new ModelAndView("AdminBlog");

		List<Post> postList= postServiceApi.findAll();

		System.out.println(" Post List::"+postList.size());

		if(postList.size()>0)
		{
			model.addAttribute("postList",postList);

			for(Post post:postList)
			{

System.out.println("Therapist Name"+post.getTherapist().getTherapistName());
System.out.println("Status Of Blog :: "+post.getStatus());
System.out.println("Blog Id :: "+post.getPostId());
			}
		}
		
		
		return modelAndView;
}
	
	@RequestMapping(value="Button", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> Deactivate(@RequestBody Map<String,Object> map)
	{
		Map<String,Object> result = new HashMap<String, Object>();
        Map<String,Object> header = new HashMap<String, Object>();


        if(map.containsKey("postId")) {
            System.out.println("Blog Id:: "+map.get("postId"));
            System.out.println("BlogIsActive:: "+map.get("isActive"));


            int id=Integer.valueOf((String)map.get("postId"));
            Post post= postServiceApi.findById((id));

            if (post == null) {
            	System.out.println("UserName not found");
                    header.put("message", "Username doesnot exist");
                    header.put("status",200);
            } else {
            	
            	post.setStatus((int)map.get("isActive"));
            	postServiceApi.saveOrUpdate(post);
                header.put("message", "The requested blog is activated/deactivated... Thanks !!");
                header.put("status",404);
            }
        }else{
            header.put("message","please select the Blog first");
        }

        result.put("header",header);

        return result;
		
	}
@RequestMapping(value="ViewCompleteBlog")
public ModelAndView ViewCompleteBlog(Model model){
	ModelAndView modelAndView=new ModelAndView("ViewCompleteBlog");
	return modelAndView;
}
	
}