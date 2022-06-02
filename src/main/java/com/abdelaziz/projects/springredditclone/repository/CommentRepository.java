package com.abdelaziz.projects.springredditclone.repository;

import com.abdelaziz.projects.springredditclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
