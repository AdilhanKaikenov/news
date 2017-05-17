package com.epam.adk.web.news.action;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO: Comment
 * <p>
 * Created on 5/16/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class ViewNewsAction extends Action {

    private static final String ID_PARAMETER = "id";
    private static final String NEWS = "news";
    private static final String SUCCESS = "success";

    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter(ID_PARAMETER);
        News news = newsService.readNews(Integer.parseInt(id));
        request.setAttribute(NEWS, news);

        return mapping.findForward(SUCCESS);
    }
}
