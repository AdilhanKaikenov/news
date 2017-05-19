package com.epam.adk.web.news.action;

import com.epam.adk.web.news.form.NewsForm;
import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import com.epam.adk.web.news.util.DateUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

import static com.epam.adk.web.news.util.ConstantHolder.*;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class ShowPageAction extends DispatchAction {

    @Autowired
    private NewsService newsService;

    public ActionForward showNewsForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;

        String id = request.getParameter(ID_PARAMETER);

        if (id != null) {
            createNewsForm(request, newsForm, id);
        } else {
            newsForm.setStrDate(DateUtil.parseDateToString(new Date(), request.getLocale()));
        }

        return mapping.findForward(SHOW_ADD_OR_EDIT_SUCCESS);
    }

    public ActionForward showNewsList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<News> newsList = newsService.readAllNews();

        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(newsList);

        return mapping.findForward(SHOW_NEWS_LIST_SUCCESS);
    }

    public ActionForward showViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter(ID_PARAMETER);

        NewsForm newsForm = (NewsForm) form;
        createNewsForm(request, newsForm, id);
        return mapping.findForward(SHOW_VIEW_NEWS_SUCCESS);
    }

    private void createNewsForm(HttpServletRequest request, NewsForm newsForm, String id) {
        News news = newsService.readNews(Integer.parseInt(id));
        newsForm.setNews(news);
        newsForm.setStrDate(DateUtil.parseDateToString(news.getDate(), request.getLocale()));
        request.setAttribute(NEWS, news);
    }
}
