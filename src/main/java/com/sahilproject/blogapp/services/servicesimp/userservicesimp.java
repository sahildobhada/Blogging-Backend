package com.sahilproject.blogapp.services.servicesimp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahilproject.blogapp.Entity.Users;
import com.sahilproject.blogapp.Exception.ResourceNotFoundException;
import com.sahilproject.blogapp.Repository.UserRepo;
import com.sahilproject.blogapp.payload.userDTO;
import com.sahilproject.blogapp.services.userservices;

@Service
public class userservicesimp implements userservices  {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mp;

    @Override
    public userDTO getbyID(int id) {
        
        Users user=this.userRepo.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
        
        return userTouserDto(user);    
    }

    @Override
    public userDTO getsave(userDTO userDTO) {
            userRepo.save(this.userdtoTouser(userDTO));
            return userDTO;
    }

    @Override
    public List<userDTO> getall() {
        List<userDTO> temp=new ArrayList<>();
        userRepo.findAll().forEach((n)->{
            temp.add(this.userTouserDto(n));
        });
        return temp;
    }

    @Override
    public userDTO update(userDTO userDTO) {
        Users user=userRepo.findById(userDTO.getId()).orElseThrow(()->new ResourceNotFoundException("User", "ID", userDTO.getId()));
        user.setName(userDTO.getName());
        user.setPassword(user.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        userRepo.save(user);
        return userDTO;
    }

    @Override
    public void delete(int id) {
        Users user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "ID", id));
        userRepo.deleteById(user.getId());
    }

    public Users userdtoTouser(userDTO userDto){
        Users obj=mp.map(userDto,Users.class);
        // obj.setId(userDto.getId());
        // obj.setName(userDto.getName());
        // obj.setPassword(userDto.getPassword());
        // obj.setAbout(userDto.getAbout());
        // obj.setEmail(userDto.getEmail());
        return obj;
    }

    public userDTO userTouserDto(Users user){
        userDTO u=mp.map(user,userDTO.class);
        return u;

    }

    
    
}
