//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.dao;

import org.belchan.model.Board;
import org.belchan.model.Post;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDAO extends BaseDAO<Board> {

    private static final String COL_NAME = "name";

    public BoardDAO() {
    }

    public Board get(int id) {
        return (Board)this.getEntity(Board.class, id);
    }

    public Board get(String boardName) {
        return getEntity(getListEntity(Board.class, COL_NAME, boardName));
    }

    public List<Post> getFirstPosts(Board b, int count, int page) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, b.getId()));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, 0));
        criteria.setMaxResults(count);
        criteria.addOrder(Order.desc(Post.COL_BUMPED));
        return criteria.list();
    }

    public List<Post> getPosts(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, boardId));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, numThread));
        return criteria.list();
    }

    public Post getHeadPost(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_ID, numThread));
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, boardId));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, 0));
        return (Post)Post.class.cast(criteria.uniqueResult());
    }
}
