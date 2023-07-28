package com.sahilproject.blogapp.services;

import java.util.List;

import com.sahilproject.blogapp.Entity.Post;
import com.sahilproject.blogapp.payload.PostDTO;
import com.sahilproject.blogapp.payload.Postcontent;

public interface postservice {
    Post createpost(PostDTO post,int cat_id,int user_id);
    Post updatePost(PostDTO post,int id);
    void delete(int id);
    Postcontent getallPost(int num,int size);
    Post getbyid(int id);
    List<PostDTO> getbyCategory(int cat_id);
    List<PostDTO> getbyuser(int user_id);
    List<Post> getbysearch(String search);
}
