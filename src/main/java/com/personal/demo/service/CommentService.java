package com.personal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.demo.entity.Comment;
import com.personal.demo.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
//    @Autowired
//    private Comment comment;
    
    public List<Comment> getByid(long id) {
	return commentRepository.findByPersonId(id);
    }
    
    public Comment put(long id,String Comment) {
	Comment comment = new Comment();
	comment.setPersonid(id);
	comment.setComment(Comment);
	return commentRepository.save(comment);
    }
}
