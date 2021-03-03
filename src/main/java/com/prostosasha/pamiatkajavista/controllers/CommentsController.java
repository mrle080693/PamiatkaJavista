package com.prostosasha.pamiatkajavista.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prostosasha.pamiatkajavista.models.Comment;
import com.prostosasha.pamiatkajavista.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestParam String pageName, @RequestParam String userName, @RequestParam String comment) {
        try {
            Comment objComment = new Comment(pageName, userName, comment);
            commentService.save(objComment);
        } catch (Exception e) {
            // LOGGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            e.printStackTrace();
        }

        return "redirect:/" + pageName;
    }
}
