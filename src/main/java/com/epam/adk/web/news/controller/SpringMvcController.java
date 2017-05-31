package com.epam.adk.web.news.controller;

import com.epam.adk.web.news.exception.DateParsingException;
import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import com.epam.adk.web.news.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/29/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Controller
public class SpringMvcController {

    private static final String DATE_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news/filtered", method = RequestMethod.POST)
    public ModelAndView filter(HttpServletRequest request) {

        String title = request.getParameter("title");
        Date from = null;
        Date to = null;
        try {
            from = DateUtil.parseStringToDate(request.getParameter("from"), DATE_PATTERN_YYYY_MM_DD);
            to = DateUtil.parseStringToDate(request.getParameter("to"), DATE_PATTERN_YYYY_MM_DD);
        } catch (DateParsingException e) {
                System.out.println(MessageFormat.format("Error: {0}", e));
        }
        List<News> newsList = newsService.readAllNewsByParameters(title, from, to);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newsList", newsList);
        modelAndView.setViewName("templates/pages/filtered-news");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/news/edit")
    public ModelAndView editNews(HttpServletRequest request) {
        String id = request.getParameter("id");
        return new ModelAndView("redirect:/ShowPage.do?method=showNewsForm&id=" + id);
    }

    @RequestMapping(value = "/user/news/view")
    public ModelAndView viewNews(HttpServletRequest request) {
        String id = request.getParameter("id");
        return new ModelAndView("redirect:/ShowPage.do?method=showViewNews&id=" + id);
    }

}
