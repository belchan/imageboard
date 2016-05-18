package org.belchan.mvc;

import org.belchan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PostController extends BelchanAbstractController {

    @Autowired
    PostService postService;

    @RequestMapping(
            value = {"post"},
            method = {RequestMethod.POST}
    )
    public @ResponseBody String appPost(HttpServletRequest request, HttpServletResponse response, String boardName, String threadId, String name, String email, String subj, String text, String file, String embeded, String embededType, String password, String tag, String tripCode) {
        String ip = request.getRemoteHost();
        threadId = postService.addNewPost(boardName, threadId, name, email, subj, text, file, embeded, embededType, password, tag, ip, tripCode);
        setStatus(response, boardName, threadId, "0");
        return threadId;
    }
}
