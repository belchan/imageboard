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

/*







    @RequestMapping(
            value = {"board/{id}"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public Board getBoard(@PathVariable("id") int id) {
        return this.boardService.getBoard(id);
    }

    */

//
//
//
//        if ((boardName == null) || (boardName.isEmpty()) || boardName.equalsIgnoreCase("index")) {
//            List b = this.boardService.getBoards();
//            model.addAttribute("boards", b);
//            return new ModelAndView("board-index",model.asMap());
//        }
//        Board b = this.boardService.getBoard(boardName);
//        model.addAttribute("board", b);
//        List bs = this.boardService.getBoards();
//        model.addAttribute("boards", bs);
//        List ps = this.boardService.getPagePosts(b, 0);
//        model.addAttribute("posts", ps);
//
//
//        for (Object p1 : ps) {
//            Post p = (Post) p1;
//            this.log.info(p.toString());
//        }
//
//        return new ModelAndView("board-view");