package com.personal.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    
    @NotNull
    private long personid;
    
    @NotNull
    private String comment;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonid() {
        return personid;
    }

    public void setPersonid(long personid) {
        this.personid = personid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
}
