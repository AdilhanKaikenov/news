<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<ftm:setBundle basename="i18n"/>

<%--@elvariable id="news" type="com.epam.adk.news.model.News"--%>
<form action="${base}/DeleteNews.do" method="post">
    <input type="hidden" name="id" value="${news.id}">

    <table class="news-view-table" cellspacing="20px">
        <tr>
            <th><bean:message key="news.label.title"/></th>
            <td>${news.title}</td>
        </tr>
        <tr>
            <th><bean:message key="news.label.date"/></th>
            <td><ftm:formatDate value="${news.date}"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.brief"/></th>
            <td>${news.brief}</td>
        </tr>
        <tr>
            <th><bean:message key="news.label.content"/></th>
            <td>${news.content}</td>
        </tr>
    </table>
    <div class="view-button-section">
        <button><a href="${base}/ShowPage.do?method=showNewsForm&id=${news.id}"><bean:message
                key="link.label.edit"/></a></button>
        <button type="submit" onclick="return confirm('<bean:message key="confirm.message.delete.news"/>')"><bean:message
                key="delete.label.button.submit"/></button>
    </div>
</form>




