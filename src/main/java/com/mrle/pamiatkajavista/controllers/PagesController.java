package com.mrle.pamiatkajavista.controllers;

import com.mrle.pamiatkajavista.models.Comment;
import com.mrle.pamiatkajavista.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PagesController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable String pageName) {
        ModelAndView result = new ModelAndView(pageName);
        List<Comment> comments;

        try {
            comments = commentService.findAllByPageName(pageName);
            result.addObject("comments", comments);
        } catch (Exception e) {
            // LOGGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            e.printStackTrace();
        }

        return result;
    }
}
