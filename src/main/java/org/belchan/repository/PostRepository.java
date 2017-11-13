package org.belchan.repository;

import org.belchan.entity.Post;
import org.belchan.entity.PostPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostRepository")
public interface PostRepository  extends JpaRepository<Post, Integer> {
    List<Post> findTop2ByDeletedTimestampOrderByTimestampDesc(Long deletedTimestamp);

    List<Post> findByDeletedTimestampOrderByTimestampDesc(Long deletedTimestamp);

    List<Post> findTop10ByPostPK_BoardidAndParentidOrderByBumpedDesc(Integer postPK_boardid, int parentid);

    List<Post> findByPostPK_BoardidAndParentid(Integer postPK_boardid, int parentid);

    Post findByPostPK(PostPK postPK);

    Post findByBumped(long bumped);

    @Query(value = "SELECT * FROM posts ORDER BY TIMESTAMP DESC LIMIT 10", nativeQuery = true)
    List<Post> findTop10AllOrderByTimestampDesc();
}