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


}
