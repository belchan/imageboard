//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.dao;

import org.belchan.entity.Board;
import org.springframework.stereotype.Service;

@Service
public class BoardDAO extends BaseDAODeprecated<Board> {

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
