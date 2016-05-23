package org.belchan.dao;

import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDAO extends BaseDAODeprecated<Post> {

    private static String COL_BOARD_ID = "postPK.boardid";
    private static String COL_PARENT_ID = "parentid";
    private static String COL_BUMPED = "bumped";
    private static String COL_ID = "postPK.id";


    public Post getLatestPostFromBoard(int boardId) {
        Criteria criteria = getCriteria(Post.class);
        criteria.add(Restrictions.eq(COL_BOARD_ID,boardId));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.desc(COL_ID));
        return (Post) getEntity(criteria.list());
    }

    public List<Post> getFirstPosts(Board b, int count, int page) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(PostDAO.COL_BOARD_ID, b.getId()));
        criteria.add(Restrictions.eq(PostDAO.COL_PARENT_ID, 0));
        criteria.setMaxResults(count);
        criteria.addOrder(Order.desc(PostDAO.COL_BUMPED));
        return criteria.list();
    }

    public List<Post> getPosts(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(PostDAO.COL_BOARD_ID, boardId));
        criteria.add(Restrictions.eq(PostDAO.COL_PARENT_ID, numThread));
        return criteria.list();
    }

    public Post getHeadPost(int boardId, int numThread) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(PostDAO.COL_ID, numThread));
        criteria.add(Restrictions.eq(PostDAO.COL_BOARD_ID, boardId));
        criteria.add(Restrictions.eq(PostDAO.COL_PARENT_ID, 0));
        return (Post)Post.class.cast(criteria.uniqueResult());
    }

    public Post get(int board, int id) {
        Criteria criteria = this.getCriteria(Post.class);
        criteria.add(Restrictions.eq(PostDAO.COL_BOARD_ID, board));
        criteria.add(Restrictions.eq(PostDAO.COL_ID, id));
        return (Post) criteria.uniqueResult();
    }
}
