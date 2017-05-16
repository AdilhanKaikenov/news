package com.epam.adk.web.news.action;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/16/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class ShowNewsListAction extends Action {

    private static final String SUCCESS = "success";
    private static final String NEWS_LIST = "newsList";

    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<News> newsList = newsService.readAllNews();
        request.setAttribute(NEWS_LIST, newsList);
        return mapping.findForward(SUCCESS);
    }
}
