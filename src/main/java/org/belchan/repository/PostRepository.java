package org.belchan.repository;

import org.belchan.entity.Post;
import org.belchan.entity.PostPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostRepository")
public interface PostRepository  extends JpaRepository<Post, Integer> {
//    public List<Post> findFirstByTimestamp(Long timestamp);
    public List<Post> findTop2ByDeletedTimestampOrderByTimestampAsc(Long deletedTimestamp);
    public List<Post> findByDeletedTimestampOrderByTimestampAsc(Long deletedTimestamp);
    public List<Post> findTop10ByPostPK_BoardidAndParentidOrderByBumpedDesc(Integer postPK_boardid, int parentid);
    public List<Post> findByPostPK_BoardidAndParentid(Integer postPK_boardid, int parentid);
    public Post findByPostPK(PostPK postPK);
    public Post findByBumped(long bumped);
}