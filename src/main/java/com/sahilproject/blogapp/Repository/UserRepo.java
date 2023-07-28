package com.sahilproject.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sahilproject.blogapp.Entity.*;;
public interface UserRepo extends JpaRepository<Users,Integer>{
    
}
