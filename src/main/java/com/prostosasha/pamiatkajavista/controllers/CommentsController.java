package com.prostosasha.pamiatkajavista.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prostosasha.pamiatkajavista.models.Comment;
import com.prostosasha.pamiatkajavista.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@RequestParam String commentJson) {
        Comment savedComment = new Comment();

        System.out.println(commentJson);               // Костыль !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        try {
            Comment comment = objectMapper.readValue(commentJson, Comment.class);
            savedComment = commentService.save(comment);
            System.out.println(savedComment.toString());               // Костыль !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        } catch (Exception e) {
            // LOGGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            e.printStackTrace();
        }

        return savedComment;
    }

    /*
    Just Recomment it and server ready to work with mobile apps
    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> findAllByPageName(@PathVariable String pageName){
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
