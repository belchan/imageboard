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
    public BoardDAO() {
    }

    public Board get(int id) {
        return (Board)this.getEntity(Board.class, id);
    }

    public Board get(String boardName) {
        return (Board)this.getEntity(this.getListEntity(Board.class, new Object[]{"name", boardName}));
    }

    public List<Post> getFirstPosts(Board b, int count, int page) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, Integer.valueOf(b.getId())));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, Integer.valueOf(0)));
        criteria.setMaxResults(count);
        criteria.addOrder(Order.desc(Post.COL_BUMPED));
        return criteria.list();
    }

    public List<Post> getPosts(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, Integer.valueOf(boardId)));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, Integer.valueOf(numThread)));
        return criteria.list();
    }

    public Post getHeadPost(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(Post.COL_ID, Integer.valueOf(numThread)));
        criteria.add(Restrictions.eq(Post.COL_BOARD_ID, Integer.valueOf(boardId)));
        criteria.add(Restrictions.eq(Post.COL_PARENT_ID, Integer.valueOf(0)));
        return (Post)Post.class.cast(criteria.uniqueResult());
    }
}
