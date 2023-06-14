package com.socialmediaweb.socialmediaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmediaweb.socialmediaweb.entities.Post;
import com.socialmediaweb.socialmediaweb.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostService service;
	
	@PostMapping("/createpost")
	public Post createPost(@RequestBody Post post) {
		return service.savePost(post);
	}
	
	@PostMapping("/createposts")
	public List<Post> createPosts(@RequestBody List<Post> posts) {
		return service.savePosts(posts);
	}
	
	@GetMapping("/feed")
	public List<Post> getPosts() {
		return service.getPosts();
	}
	
	@GetMapping("/post/{post_id}")
	public Post findPostById(@PathVariable("post_id") Integer post_id) {
		return service.getPostById(post_id);
	}
	
	@PutMapping("/update")
	public Post updatePost(@RequestBody Post post) {
		return service.updatePost(post);
	}
	
	@DeleteMapping("/delete/{post_id}")
	public String deletePost(@PathVariable("post_id") Integer post_id) {
		return service.deletePost(post_id);
	}
}