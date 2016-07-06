package org.belchan.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class SinglePageController extends BelchanAbstractController {

    @RequestMapping("/")
    public String main() {
        return "index.html";
    }

    @RequestMapping(
            value = {"{boardName}/res/{numThread}.html"},
            method = {RequestMethod.GET}
    )
    public String getBoard(HttpServletResponse response, @PathVariable("boardName") String boardName, @PathVariable("numThread") String numThread) {
        setStatus(response, boardName, numThread, "0");
        return "/thread.html";
    }


    //TODO rewrite it
    @RequestMapping(
            value = {"archive", "b", "bb", "bc", "bo", "by", "dt", "files", "fm", "int", "mu", "news", "t", "v", "vg", "wp", "/archive/", "/b/", "/bb/", "/bc/", "/bo/", "/by/", "/dt/", "/files/", "/fm/", "/int/", "/mu/", "/news/", "/t/", "/v/", "/vg/", "/wp/"},
            method = {RequestMethod.GET}
    )
    public String getBoard(HttpServletRequest request, HttpServletResponse response) {
        String boardName = request.getServletPath().split("/")[1];
        setStatus(response, boardName, "0", "0");
        return "board.html";
    }



    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "info")
    public String getInfo() {
        try {
            return dataSource.getConnection().toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

}
