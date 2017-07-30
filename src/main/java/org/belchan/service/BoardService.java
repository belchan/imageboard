package org.belchan.service;

import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.belchan.entity.PostPK;
import org.belchan.repository.BoardRepository;
import org.belchan.repository.PostRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    BoardRepository boardRepository;

    public BoardService() {
    }

    public List<Board> getBoards() {
        return this.boardRepository.findAll();
    }

    public Board getBoard(int id) {
        return this.boardRepository.findOne(id);
    }

    public Board getBoard(String boardName) {
        return boardRepository.findByNameIgnoreCase(boardName);
    }

    public List<Post> getPagePosts(String boardName, int page) {
        Board b = boardRepository.findByNameIgnoreCase(boardName);
        List<Post> posts = postRepository.findTop10ByPostPK_BoardidAndParentidOrderByBumpedDesc(b.getId(), 0);
        Hibernate.initialize(posts);
        return posts;
    }

    public List<Post> getPosts(String boardName, String threadId) {
        try {
            Integer thread = Integer.valueOf(threadId);
            Board board = getBoard(boardName);
            List<Post> posts = postRepository.findByPostPK_BoardidAndParentid(board.getId(),thread);
            Post mainPost = postRepository.findByPostPK(new PostPK(thread, board.getId()));
            posts.add(0,mainPost);
            return  posts;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }

    }
}
