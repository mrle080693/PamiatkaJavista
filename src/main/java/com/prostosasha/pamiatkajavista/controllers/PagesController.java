package com.prostosasha.pamiatkajavista.controllers;

import com.prostosasha.pamiatkajavista.models.Comment;
import com.prostosasha.pamiatkajavista.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class PagesController {
    @Autowired
    private CommentService commentService;

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
