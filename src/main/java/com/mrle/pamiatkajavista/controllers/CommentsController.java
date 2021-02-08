package com.mrle.pamiatkajavista.controllers;

import com.mrle.pamiatkajavista.models.Comment;
import com.mrle.pamiatkajavista.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@RequestParam Comment comment) {
        Comment savedComment = new Comment();

        try {
            savedComment = commentService.save(comment);
        } catch (Exception e) {
            // LOGGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            e.printStackTrace();
        }

        return savedComment;
    }

    /*
    Just Recomment it and server ready to work with mobile apps
    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> findAllByPageName(@PathVariable int pageId){
        List<Comment> comments = new ArrayList<>();

        try {
            comments = commentService.findAllByPageName(pageId);
        } catch (Exception e) {
            // LOGGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            e.printStackTrace();
        }

        return comments;
    }
    */
}
