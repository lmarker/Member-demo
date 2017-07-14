package com.personal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.demo.entity.UserAdmin;

@Repository
public interface AdminRepository extends JpaRepository<UserAdmin, String>{

    @Query("from UserAdmin as u where u.username=:username and u.password=:password")
    UserAdmin login(@Param("username")String username,@Param("password")String password);

    UserAdmin findByUsername(String loginName);
    
}
