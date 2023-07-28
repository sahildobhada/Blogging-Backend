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

import com.sahilproject.blogapp.payload.userDTO;
import com.sahilproject.blogapp.services.userservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class usercontroller {
    
        @Autowired
        userservices userservices;

        @PostMapping("/")
        public ResponseEntity<userDTO> save(@RequestBody userDTO user){
            System.out.println(user);
            userservices.getsave(user);
            return new ResponseEntity<userDTO>(user, HttpStatus.ACCEPTED);
        }

        @GetMapping("/")
        public ResponseEntity<List<userDTO>> get(){
            List<userDTO> temp=userservices.getall();
            return new ResponseEntity<List<userDTO>>(temp, HttpStatus.ACCEPTED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<userDTO> getuser(@PathVariable int id){
            userDTO user=userservices.getbyID(id);
            return new ResponseEntity<userDTO>(user, HttpStatus.ACCEPTED);
        }
        
        @PutMapping("/")
        public ResponseEntity<userDTO> updateuser(@Valid @RequestBody userDTO user){
            userDTO users=userservices.update(user);
            return new ResponseEntity<userDTO>(users, HttpStatus.ACCEPTED);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable int id){
            userservices.delete(id);
        }

        
}
