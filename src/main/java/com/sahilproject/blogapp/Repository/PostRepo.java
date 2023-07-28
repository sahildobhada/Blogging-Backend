package com.sahilproject.blogapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahilproject.blogapp.Entity.Category;
import com.sahilproject.blogapp.Entity.Post;
import com.sahilproject.blogapp.Entity.Users;

public interface PostRepo extends JpaRepository<Post,Integer>{
    List<Post> findByUser(Users user);
    List<Post> findByCategory(Category cat);
    
}
