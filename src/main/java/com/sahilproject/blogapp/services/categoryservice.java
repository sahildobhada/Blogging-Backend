package com.sahilproject.blogapp.services;

import java.util.List;

import com.sahilproject.blogapp.payload.categoryDTO;

public interface categoryservice {
    categoryDTO getcatagory(int id);
    categoryDTO insert(categoryDTO categoryDTO);
    List<categoryDTO> getallcategory();
    categoryDTO update(categoryDTO categoryDTO,int id);
    void delete(int id);
}
