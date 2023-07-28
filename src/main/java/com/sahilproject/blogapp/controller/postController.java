package com.sahilproject.blogapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahilproject.blogapp.Entity.Post;
import com.sahilproject.blogapp.payload.PostDTO;
import com.sahilproject.blogapp.payload.Postcontent;
import com.sahilproject.blogapp.services.servicesimp.postserviceimp;

@RestController
@RequestMapping("/api")
public class postController {

    @Autowired
    postserviceimp psi;

    @PostMapping("/user/{user_id}/category/{cat_id}")
    public ResponseEntity<PostDTO> createuser(@RequestBody PostDTO pd, @PathVariable int user_id,
            @PathVariable int cat_id) {
        Post p = psi.createpost(pd, cat_id, user_id);
        return new ResponseEntity<PostDTO>(psi.posttoDTO(p), HttpStatus.OK);
    }

    @GetMapping("/user/users/{user_id}/post")
    public ResponseEntity<List<PostDTO>> getpostbyuser(@PathVariable int user_id) {
        List<PostDTO> ll = psi.getbyuser(user_id);
        return new ResponseEntity<>(ll, HttpStatus.OK);
    }

    @GetMapping("/user/category/{cat_id}/post")
    public ResponseEntity<List<PostDTO>> getpostbyCategory(@PathVariable int cat_id) {
        List<PostDTO> ll = psi.getbyCategory(cat_id);
        return new ResponseEntity<List<PostDTO>>(ll, HttpStatus.OK);
    }

    @GetMapping("/user/post/{post_id}")
    public ResponseEntity<PostDTO> getpostbyid(@PathVariable int id) {
        Post p = psi.getbyid(id);
        PostDTO ps = psi.posttoDTO(p);
        return new ResponseEntity<>(ps, HttpStatus.OK);
    }

    @GetMapping("/user/post")
    public ResponseEntity<Postcontent> getallEntity(
            @RequestParam(value = "pagenumber", defaultValue = "0", required = false) int pagenumber,
            @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        Postcontent lp = psi.getallPost(pagenumber, size);
        return new ResponseEntity<Postcontent>(lp, HttpStatus.OK);

    }

    @PutMapping("/user/post/{post_id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable int post_id) {
        Post p = psi.updatePost(postDTO, post_id);
        PostDTO pd = psi.posttoDTO(p);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }

    @DeleteMapping("/user/post/{post_id}")
    public void delete(@PathVariable int id) {
        psi.delete(id);
    }

}
