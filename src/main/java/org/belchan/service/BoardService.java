package org.belchan.service;

import org.belchan.dao.BoardDAO;
import org.belchan.dao.PostDAO;
import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDAO boardDAO;

    @Autowired
    PostDAO postDAO;

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

    public List<Post> getPagePosts(String boardName, int page) {
        Board b = boardDAO.get(boardName);
        List<Post> posts = postDAO.getFirstPosts(b, 10, page);
        Hibernate.initialize(posts);
        return posts;
    }

    public List<Post> getThreadPosts(Board b, int numThread) {
        List<Post> l = this.postDAO.getPosts(b.getId(), numThread);
        Post p = this.postDAO.getHeadPost(b.getId(), numThread);
        l.add(0, p);
        return l;
    }

    public List<Post> getPosts(String boardName, String threadId) {
        try {
            Integer thread = Integer.valueOf(threadId);
            Board board = boardDAO.get(boardName);
            List<Post> posts = postDAO.getPosts(board.getId(),thread);
            Post mainPost = postDAO.get(board.getId(),thread);
            posts.add(0,mainPost);
            return  posts;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }

    }
}
