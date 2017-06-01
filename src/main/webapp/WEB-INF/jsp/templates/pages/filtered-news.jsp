<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<html>
<head>
    <title>Filtered News List</title>
</head>
<body>

<%--@elvariable id="newsList" type="java.util.List"--%>
<c:forEach var="news" items="${newsList}">
    <%--@elvariable id="news" type="com.epam.adk.web.news.model.News"--%>
    <div class="news-section">
        <div class="title-section">${news.title}</div>
        <div class="date-section"><ftm:formatDate value="${news.date}"/></div>
        <div class="brief-section">${news.brief}</div>
        <div class="links-and-other-section">
            <a href="${base}/user/news/view/${news.id}" class="general-button"><bean:message
                    key="link.label.view"/></a>/
            <a href="${base}/admin/news/${news.id}" class="general-button"><bean:message
                    key="link.label.edit"/></a>
        </div>
    </div>
</c:forEach>
</body>
</html>
