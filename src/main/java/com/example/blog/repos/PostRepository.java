package com.example.blog.repos;

import com.example.blog.modals.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
    List<Post> findAllByTitleIsLike(String term);
    Post findByTitle(String title);
}
