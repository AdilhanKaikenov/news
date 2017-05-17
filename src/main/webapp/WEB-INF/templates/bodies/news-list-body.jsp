<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<form action="${base}/DeleteNews.do" method="post">
    <%--@elvariable id="newsList" type="java.util.List"--%>
    <c:forEach items="${newsList}" var="news">
        <%--@elvariable id="news" type="com.epam.adk.news.model.News"--%>
        <div class="news-section">
            <div class="title-section">${news.title}</div>
            <div class="date-section"><ftm:formatDate value="${news.date}"/></div>
            <div class="brief-section">${news.brief}</div>
            <div class="links-and-other-section">
                <button><a href="${base}/ViewNews.do?id=${news.id}"><bean:message key="link.label.view"/></a></button>
                <button><a href="${base}/ShowPage.do?method=showNewsForm&id=${news.id}"><bean:message key="link.label.edit"/></a></button>
                <label>
                    <input type="checkbox" name="id" value="${news.id}">
                </label>
            </div>
        </div>
    </c:forEach>
    <c:if test="${not empty newsList}">
        <div class="delete-button-section">
            <button type="submit"><bean:message key="delete.label.button.submit"/></button>
        </div>
    </c:if>
</form>