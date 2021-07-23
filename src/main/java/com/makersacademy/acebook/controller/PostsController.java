
package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;

import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Dictionary;


@RestController
public class PostsController {

    @Autowired
    PostRepository postRepository;

    //GET all
    @GetMapping("/api/posts")
    public Iterable<Post> index() {
        Iterable<Post> posts = postRepository.findAll();
        ArrayList<Post> shouty_posts = new ArrayList<Post>();
        posts.forEach(post -> {
            shouty_posts.add(
                    new Post(post.content.toUpperCase(), post.date, post.likes, post.userName, post.id)
            );
        });
        return shouty_posts;
    }

    // public Iterable<Post> index() {
    //     return postRepository.findAll();
    // }

//     // GET one
//     @GetMapping("/api/posts/{id}")
//     public Post read(@PathVariable(value="id") long id){
//    return postRepository.getPost(id);
// }

    // @PostMapping("/api/posts")
    // public Post create(@RequestBody Post post){
    //     return postRepository.save(post);
    // };

    // @PostMapping("/api/posts")
    // public void add(){
    //   Post post = new Post("Post", null);
    //   post = postRepository.save(post);
    //   repository.save(new Post(df)
    // }

    @PostMapping("/api/posts")
    // @ResponseBody
      Post newPost(@RequestBody Post newPost) {
        return postRepository.save(newPost);
      }

 //    @PostMapping("/api/posts")
 //    public Iterable<Post>create(@RequestBody Post post){
 //    {
 //     //No need for Jsonobject while using POJO springboot will convert it for you from json to POJO
 //     System.out.println(post);
 //     return postRepository.save(post);
 //   }
 // }

}


//    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
//    public Post read(@PathVariable(value="id") long id){
//        return postService.getPost(id);
 //   }

//    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
//    public String update(@PathVariable(value="id") int id){
//        return "post.update()";
//
//    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
 //   public String delete(@PathVariable(value="id") int id){
 //       return "post.delete()";
//    }






    // public Iterable<Post> index() {
    //     return postRepository.findAll();
    // }





// @RestController
// public class PostsController {
//
//     @Autowired
//     PostRepository postRepository;
//
//     @GetMapping("/api/posts")
//     public Iterable<Post> index() {
//         Iterable<Post> posts = postRepository.findAll();
//         return ContentFilter.shoutyPosts(posts);
//     }
//
//     @GetMapping("/api/shouty/posts")
//     public Iterable<Post> index() {
//         return postRepository.findAll();
//     }
//
//
// }
