package org.belchan.repository;

import org.belchan.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface PostRepository  extends JpaRepository<Post, Integer> {

}