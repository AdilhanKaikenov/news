package com.epam.adk.web.news.action;

import com.sun.deploy.net.HttpResponse;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * TODO: Comment
 * <p>
 * Created on 5/16/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class SelectLanguageAction extends Action {

    private static final String REFERER = "referer";
    private static final String SUCCESS = "success";
    private static final String REGION_PARAMETER = "region";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String region = request.getParameter(REGION_PARAMETER);
        Locale locale = new Locale(region);
        request.getSession().setAttribute(Globals.LOCALE_KEY, locale);
        return getCurrentPage(mapping, request);
    }

    private ActionForward getCurrentPage(ActionMapping mapping, HttpServletRequest request) {
        String referer = request.getHeader(REFERER);
        ActionForward actionForward = new ActionForward(referer, true);
        if (referer == null) {
            return mapping.findForward(SUCCESS);
        }
        return actionForward;
    }
}
