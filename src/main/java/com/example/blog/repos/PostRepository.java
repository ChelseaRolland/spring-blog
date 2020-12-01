package com.example.blog.repos;

import com.example.blog.modals.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository  extends JpaRepository<Post, Long> {
}
