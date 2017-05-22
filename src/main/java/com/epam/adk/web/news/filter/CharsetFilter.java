package com.epam.adk.web.news.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * TODO: Comment
 * <p>
 * Created on 5/22/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class CharsetFilter implements Filter {

    private static final String ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
