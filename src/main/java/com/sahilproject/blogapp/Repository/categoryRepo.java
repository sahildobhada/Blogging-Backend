package com.sahilproject.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahilproject.blogapp.Entity.Category;

public interface categoryRepo extends JpaRepository<Category,Integer>{
     
}
