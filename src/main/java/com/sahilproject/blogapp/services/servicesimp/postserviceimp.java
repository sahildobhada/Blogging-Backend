package com.sahilproject.blogapp.services.servicesimp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sahilproject.blogapp.Entity.Category;
import com.sahilproject.blogapp.Entity.Post;
import com.sahilproject.blogapp.Entity.Users;
import com.sahilproject.blogapp.Exception.ResourceNotFoundException;
import com.sahilproject.blogapp.Repository.PostRepo;
import com.sahilproject.blogapp.Repository.UserRepo;
import com.sahilproject.blogapp.Repository.categoryRepo;
import com.sahilproject.blogapp.payload.PostDTO;
import com.sahilproject.blogapp.services.postservice;
import com.sahilproject.blogapp.payload.Postcontent;

@Service
public class postserviceimp implements postservice {

    @Autowired
    userservicesimp usi;

    @Autowired
    ModelMapper mp;

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    categoryRepo categoryRepo;

    @Autowired
    categoryserviceimp categoryserviceimp;

    @Autowired
    userservicesimp userservicesimp;

    public Post dtotopost(PostDTO post){
        return mp.map(post,Post.class);
    }
    public PostDTO posttoDTO(Post post){
        return mp.map(post,PostDTO.class);
    }

    @Override
    public Post createpost(PostDTO post,int cat_id,int user_id) {
        Users u=this.userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "Id", user_id));
        Category c=this.categoryRepo.findById(cat_id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", cat_id));
   
        Post p=dtotopost(post);
        p.setCategory(c);
        p.setUser(u);
        p.setDate(new Date());
        p.setImage("default.img");
        postRepo.save(p);
        return p;
    }

    @Override
    public Post updatePost(PostDTO post, int id) {
        Post p=this.postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        p.setCategory(categoryserviceimp.DTOtocategory(post.getCategory()));
        p.setContent(post.getContent());
        p.setDate(new Date());
        p.setImage(post.getImage());
        p.setTitle(post.getTitle());
        p.setUser(userservicesimp.userdtoTouser(post.getUser()));

        postRepo.save(p);
        return p;

    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public Postcontent getallPost(int pagenumber,int pagesize) {
        Pageable p=PageRequest.of(pagenumber, pagesize);
        
        Page<Post> pp= postRepo.findAll(p);
        System.out.println(pp.toString());
        List<Post> lp=pp.getContent();
        System.out.println(lp.toString());
        List<PostDTO> ans=new ArrayList<>();
        lp.forEach((x)->{
            ans.add(posttoDTO(x));
        });
        System.out.println(ans.toString());
        Postcontent s=new Postcontent();
        s.setContent(ans);
        s.setPageNumber(pp.getNumber());
        s.setPagesize(pp.getSize());
        s.setLastpage(pp.isLast());

        return s;
    }

    @Override
    public Post getbyid(int id) {
        return postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
    }

    @Override
    public List<PostDTO> getbyCategory(int cat_id) {
        Category c=categoryRepo.findById(cat_id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", cat_id));
        List<Post> lp=postRepo.findByCategory(c);
        List<PostDTO> ll=new ArrayList<>();
        lp.forEach((x)->{
            ll.add(posttoDTO(x));
        });
        return ll;
    }

    @Override
    public List<PostDTO> getbyuser(int user_id) {
        Users u= this.userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "Id", user_id));
        List<Post> lp=postRepo.findByUser(u);
        List<PostDTO> ll=new ArrayList<>();
        lp.forEach((x)->{
            ll.add(posttoDTO(x));
        });
        return ll;
    }

    @Override
    public List<Post> getbysearch(String search) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getbysearch'");
    }
    
}
