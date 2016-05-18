package org.belchan.mvc;

import org.belchan.model.Board;
import org.belchan.model.Post;
import org.belchan.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardRestController {
    @Autowired
    BoardService boardService;

    @RequestMapping(
            value = {"boards"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<Board> getBoards() {
        return this.boardService.getBoards();
    }

    @RequestMapping(
            value = {"threads"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<Post> getThreads(String boardName) {
        return boardService.getPagePosts(boardName,0);
    }


    @RequestMapping(
            value = {"posts"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<Post> getThreads(String boardName,String threadId) {
        return boardService.getPosts(boardName,threadId);
    }
}