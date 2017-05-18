package com.epam.adk.web.news.action;

import com.epam.adk.web.news.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.adk.web.news.util.ConstantHolder.*;

/**
 * TODO: Comment
 * <p>
 * Created on 5/16/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class DeleteNewsAction extends Action {

    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String[] ids = request.getParameterValues(ID_PARAMETER);

        if (ids != null) {
            for (String id : ids) {
                newsService.deleteNews(Integer.parseInt(id));
            }
        }
        return mapping.findForward(SUCCESS);
    }
}
