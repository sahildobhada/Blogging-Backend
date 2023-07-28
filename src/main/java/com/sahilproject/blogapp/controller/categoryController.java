package com.sahilproject.blogapp.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.sahilproject.blogapp.payload.categoryDTO;
import com.sahilproject.blogapp.services.servicesimp.categoryserviceimp;

@RestController
@RequestMapping("api/category")
public class categoryController {
    
    @Autowired
    categoryserviceimp categoryserviceimp;

    @GetMapping("/{id}")
    public ResponseEntity<categoryDTO> get(@PathVariable int id){
            categoryDTO cd= categoryserviceimp.getcatagory(id);
            return new ResponseEntity<categoryDTO>(cd, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<categoryDTO>> getall(){
        List<categoryDTO> ls= categoryserviceimp.getallcategory();
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<categoryDTO> insert(@RequestBody  categoryDTO categoryDTO){
        System.out.println("In-controller " +categoryDTO.toString());
        categoryserviceimp.insert(categoryDTO);
        return new ResponseEntity<categoryDTO>(categoryDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoryDTO> updated(@RequestBody categoryDTO categoryDTO,@PathVariable int id){
        categoryserviceimp.update(categoryDTO, id);
        return new ResponseEntity<categoryDTO>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryserviceimp.delete(id);
    }


    
}
