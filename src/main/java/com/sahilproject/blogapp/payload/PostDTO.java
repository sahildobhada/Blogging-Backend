package com.sahilproject.blogapp.payload;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO {
    
   
    private String title;
   
    private String content;
  
    private String image;
  
    private Date date;
  
    private categoryDTO category;
 
    private userDTO user;
}
