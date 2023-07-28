package com.sahilproject.blogapp.services;

import java.util.List;

import com.sahilproject.blogapp.Exception.ResourceNotFoundException;
import com.sahilproject.blogapp.payload.userDTO;

public interface userservices {
    userDTO getbyID(int id) throws ResourceNotFoundException;
    userDTO getsave(userDTO userDTO);
    List<userDTO> getall();
    userDTO update(userDTO userDTO);
    void delete(int id);
}
