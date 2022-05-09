package com.abdelaziz.projects.springredditclone.model;

import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;


@Data
@Entity

public class Post {
    
   private Long id;
   private  String name;
   private   String description;
   @ManyToOne(fetch = FetchType.LAZY)
   private  String subReddit;
   @ManyToOne(fetch = FetchType.LAZY)
   private Long userId;
   private  Instant createdOn;
}
