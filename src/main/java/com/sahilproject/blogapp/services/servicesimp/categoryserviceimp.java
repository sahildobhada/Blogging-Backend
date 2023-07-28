package com.sahilproject.blogapp.services.servicesimp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahilproject.blogapp.Entity.Category;
import com.sahilproject.blogapp.Exception.ResourceNotFoundException;
import com.sahilproject.blogapp.Repository.categoryRepo;
import com.sahilproject.blogapp.payload.categoryDTO;
import com.sahilproject.blogapp.services.categoryservice;

@Service
public class categoryserviceimp implements categoryservice{
    
    @Autowired
    categoryRepo  cr;

    @Autowired
    ModelMapper mp;
    @Override
    public categoryDTO getcatagory(int id) {
        Category c=cr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","id",id));
        return this.categoryToDTO(c);
    }

    @Override
    public List<categoryDTO> getallcategory() {
            List<Category> lc=cr.findAll();
            List<categoryDTO> ls=new ArrayList<>();
            lc.forEach((x)->{
                ls.add(this.categoryToDTO(x));
            });
            return ls;
    }

    @Override
    public categoryDTO update(categoryDTO categoryDTO, int id) {
        Category c=cr.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", id));
        c.setDiscription(categoryDTO.getDiscription());
        c.setTitle(categoryDTO.getTitle());
        cr.save(c);
        return categoryDTO;
    }

    @Override
    public void delete(int id) {
        cr.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", id));
        cr.deleteById(id);
    }

     @Override
    public categoryDTO insert(categoryDTO categoryDTO) {
        System.out.println(categoryDTO.toString());
        cr.save(this.DTOtocategory(categoryDTO));
        return categoryDTO;
    }

    public Category DTOtocategory(categoryDTO categoryDTO){
        Category c=this.mp.map(categoryDTO, Category.class);
        
        return c;
    }

    public categoryDTO categoryToDTO(Category c){
        categoryDTO cd=mp.map(c,categoryDTO.class);
        return cd;
    }

   

    
}
