package com.sahilproject.blogapp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class userDTO {
    
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}
