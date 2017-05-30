package com.epam.adk.web.news.util;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO: Comment
 * <p>
 * Created on 5/30/2017.
 *
 * @author Kaikenov Adilkhan
 */
public final class Pagination {

    private static final String PAGE_PARAMETER = "page";
    private static final String PAGE_NUMBER = "pageNumber";

    private int getPagesNumber(int totalLineNumber, int linePerPageNumber) {
        int pageCount = totalLineNumber / linePerPageNumber;
        int residue = totalLineNumber % linePerPageNumber;
        if (residue > 0) {
            pageCount++;
        }
        return pageCount;
    }

    public int getPageNumber(HttpServletRequest request, int totalAmount, int linePerPage) {
        int page = 1;
        String pageParameter = request.getParameter(PAGE_PARAMETER);
        if (pageParameter != null) {
            page = Integer.parseInt(pageParameter);
        }
        int pageNumber = getPagesNumber(totalAmount, linePerPage);
        request.setAttribute(PAGE_NUMBER, pageNumber);
        return page;
    }

}
