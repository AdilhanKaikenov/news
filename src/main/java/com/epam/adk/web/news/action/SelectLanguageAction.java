package com.epam.adk.web.news.action;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static com.epam.adk.web.news.util.ConstantHolder.*;

/**
 * TODO: Comment
 * <p>
 * Created on 5/16/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class SelectLanguageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String region = request.getParameter(REGION_PARAMETER);
        Locale locale = new Locale(region);
        request.getSession().setAttribute(Globals.LOCALE_KEY, locale);
        return getCurrentPage(mapping, request);
    }

    private ActionForward getCurrentPage(ActionMapping mapping, HttpServletRequest request) {
        String referer = request.getHeader(REFERER);
        boolean isRedirect = true;
        ActionForward actionForward = new ActionForward(referer, isRedirect);
        if (referer == null) {
            return mapping.findForward(SUCCESS);
        }
        return actionForward;
    }
}
