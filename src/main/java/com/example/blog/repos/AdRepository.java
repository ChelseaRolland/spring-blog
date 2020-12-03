package com.example.blog.repos;

import com.example.blog.modals.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    // Query methods
    Ad findByDescription(String desc); // mysql> select * from ads where description = ?;
    List<Ad> findAllByTitleIsLike(String term);
}
