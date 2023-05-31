package com.example.listology.controller;

import com.example.listology.model.Post;
import com.example.listology.model.User;
import com.example.listology.repository.PostRepository;
import com.example.listology.util.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class PostController {
    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model){
        model.addAttribute("id", id);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String showNewPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public void createNewPost(@ModelAttribute("post") Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postDao.save(post);
    }
}
