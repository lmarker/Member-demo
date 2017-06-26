package com.personal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.demo.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("from Comment as c where c.personid=:id order by c.id desc")
    List<Comment> findByPersonId(@Param("id") long id);
   
}
