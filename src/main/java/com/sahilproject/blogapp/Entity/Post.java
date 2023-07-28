package com.sahilproject.blogapp.Entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    @Column(length = 100)
    private String title;
    @Column
    private String content;
    @Column
    private String image;
    @Column
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;

}
