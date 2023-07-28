package com.sahilproject.blogapp.Exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String user,String value,int id){
        super(String.format("%S not found with %s = %d ",user,value,id));
    }
}
