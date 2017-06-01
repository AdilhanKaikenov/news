<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<div class="menu-section">
    <div class="menu-header">
        <bean:message key="menu.header.title"/>
    </div>

    <div class="menu_references">
        <br><a href="${base}/admin/news/"><bean:message key="link.menu.label.addnews"/></a>
        <br><a href="${base}/ShowPage.do?method=showNewsList"><bean:message key="link.menu.label.newslist"/></a>
        <sec:authorize access="isAnonymous()">
            <br><a href="${base}/login"><bean:message key="link.label.menu.login"/></a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <br><a href="${base}/logout"><bean:message key="link.label.menu.logout"/></a>
        </sec:authorize>
    </div>
</div>
