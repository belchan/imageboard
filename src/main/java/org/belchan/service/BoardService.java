//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.service;

import org.belchan.dao.BoardDAO;
import org.belchan.model.Board;
import org.belchan.model.Post;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardDAO boardDAO;

    public BoardService() {
    }

    public List<Board> getBoards() {
        return this.boardDAO.getEntitys(Board.class);
    }

    public Board getBoard(int id) {
        return this.boardDAO.get(id);
    }

    public Board getBoard(String boardName) {
        return boardDAO.get(boardName);
    }

    public List<Post> getPagePosts(Board b, int page) {
        List<Post> posts = boardDAO.getFirstPosts(b, 10, page);
        Hibernate.initialize(posts);
        return posts;
    }

    public List<Post> getThreadPosts(Board b, int numThread) {
        List<Post> l = this.boardDAO.getPosts(b.getId(), numThread);
        Post p = this.boardDAO.getHeadPost(b.getId(), numThread);
        l.add(0, p);
        return l;
    }
}
