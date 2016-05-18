package org.belchan.mvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class BelchanAbstractController {

    protected void setStatus(HttpServletResponse response, String board, String thread, String page) {
        response.addCookie(new Cookie("board",board));
        response.addCookie(new Cookie("thread",thread));
        response.addCookie(new Cookie("page",page));
    }
}
