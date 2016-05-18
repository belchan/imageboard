package org.belchan.dao;

import org.belchan.model.Post;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface PostRepository  extends BaseRepository<Post>{

}