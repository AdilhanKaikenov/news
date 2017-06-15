package com.epam.adk.web.news.action;

import com.epam.adk.web.news.form.NewsForm;
import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import com.epam.adk.web.news.util.DateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.adk.web.news.util.ConstantHolder.NEWS;
import static com.epam.adk.web.news.util.ConstantHolder.SUCCESS;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class AddEditAction extends Action {

    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;

        News news = newsForm.getNews();
        String strDate = newsForm.getStrDate();
        news.setDate(DateUtil.parseStringToDate(strDate));

        newsService.saveOrEditNews(news);

        request.setAttribute(NEWS, news);

        return mapping.findForward(SUCCESS);
    }
}
