package com.pip.course_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value =" /jsonPostSingle", method = RequestMethod.GET)
    @ResponseBody
    public PostModel generateJSONPostsingle(@ModelAttribute("postModel") PostModel postModel) {

        if(postModel.getPostId() == 1) {
            postModel.setTitle("post title for id 1");
        } else {
            postModel.setTitle("default post title");
        }
        return postModel;
    }

    @RequestMapping(value =" /jsonPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<PostModel> generateJSONPosts() {

        List<PostModel> list = new ArrayList<PostModel>();

        PostModel p1 = new PostModel();
        p1.setPostId(1);
        p1.setTitle("Post title 1");

        PostModel p2 = new PostModel();
        p2.setPostId(2);
        p2.setTitle("Post title 2");

        list.add(p1);
        list.add(p2);

        return list;
    }
}
