package com.sahilproject.blogapp.Exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class userError {
    private int status;
    private String message;

    public userError(int status,String message){
        this.status=status;
        this.message=message;
      
    }



}
