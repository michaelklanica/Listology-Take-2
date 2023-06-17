package com.example.listology.controller;

import com.example.listology.model.Post;
import com.example.listology.model.User;
import com.example.listology.repository.PostRepository;
import com.example.listology.repository.UserRepository;
import com.example.listology.util.Category;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
        System.out.println("showNewPostForm method");
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "category") Category category,
            @RequestParam(name = "author") User author,
            @RequestParam(name = "createdAt") LocalDateTime createdAt,
            Authentication authentication
    ) {
        System.out.println(authentication);
        System.out.println(title);
        System.out.println(content);
        System.out.println(createdAt);
        System.out.println(author);
        if (authentication != null && authentication.isAuthenticated()) {
            // User is authenticated, proceed with creating the post
            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            post.setCategory(category);
            post.setAuthor(author);
            post.setCreatedAt(createdAt);

            postDao.save(post);

            return "redirect:/posts";
        }
        // User is not authenticated, handle accordingly
        return "error";
    }


}
