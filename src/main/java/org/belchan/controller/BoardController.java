//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.controller;

import org.belchan.model.Board;
import org.belchan.model.Post;
import org.belchan.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
public class BoardController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BoardService boardService;

    public BoardController() {
    }

    @RequestMapping(
            value = {"board"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<Board> getBoards() {
        return this.boardService.getBoards();
    }

    @RequestMapping(
            value = {"board/{id}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public Board getBoard(@PathVariable("id") int id) {
        return this.boardService.getBoard(id);
    }

    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.GET}
    )
    public String getIndex(Model model) {
        List b = this.boardService.getBoards();
        model.addAttribute("boards", b);
        return "board-index";
    }

    @RequestMapping(
            value = {"{boardName}/res/{numThread}.html"},
            method = {RequestMethod.GET}
    )
    public String getBoard(Model model, @PathVariable("boardName") String boardName, @PathVariable("numThread") int numThread) {
        Board b = this.boardService.getBoard(boardName);
        model.addAttribute("board", b);
        List bs = this.boardService.getBoards();
        model.addAttribute("boards", bs);
        List ps = this.boardService.getThreadPosts(b, numThread);
        model.addAttribute("posts", ps);
        Iterator var7 = ps.iterator();

        while(var7.hasNext()) {
            Post p = (Post)var7.next();
            this.log.info(p.toString());
        }

        return "thread-view";
    }

    @RequestMapping(
            value = {"{boardName}"},
            method = {RequestMethod.GET}
    )
    public String getBoard(Model model, @PathVariable("boardName") String boardName) {
        Board b = this.boardService.getBoard(boardName);
        model.addAttribute("board", b);
        List bs = this.boardService.getBoards();
        model.addAttribute("boards", bs);
        List ps = this.boardService.getPagePosts(b, 0);
        model.addAttribute("posts", ps);
        Iterator var6 = ps.iterator();

        while(var6.hasNext()) {
            Post p = (Post)var6.next();
            this.log.info(p.toString());
        }

        return "board-view";
    }
}
