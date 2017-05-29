<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<div class="news-list-filter">

    <form action="${base}/filter" method="post">
        Title: <input type="text" name="title"/>
        Date From: <input type="date" name="from"/>
        Date To:<input type="date" name="to"/>
        <input type="submit" value="Filter">
    </form>

</div>

<html:form action="/DeleteNews.do" method="post">
    <div class="form-error-section">
        <html:errors/>
    </div>
    <html:hidden property="news.id"/>
    <html:hidden property="news.title" value="pass_validation"/>
    <html:hidden property="news.brief" value="pass_validation"/>
    <html:hidden property="news.content" value="pass_validation"/>

    <logic:iterate id="news" name="NewsForm" property="newsList">

        <div class="news-section">
            <div class="title-section">${news.title}</div>
            <div class="date-section"><ftm:formatDate value="${news.date}"/></div>
            <div class="brief-section">${news.brief}</div>
            <div class="links-and-other-section">
                <html:link styleClass="general-button" action="/ShowPage.do?method=showViewNews&id=${news.id}"><bean:message
                        key="link.label.view"/></html:link> /
                <html:link styleClass="general-button" action="/ShowPage.do?method=showNewsForm&id=${news.id}"><bean:message
                        key="link.label.edit"/></html:link>
                <html:multibox property="selectedNewsIds" value="${news.id}"/>
            </div>
        </div>

    </logic:iterate>
    <div class="delete-button-section">

        <logic:notEmpty name="NewsForm" property="newsList">
            <html:submit styleClass="general-button" onclick="return deleteNewsList()"><bean:message key="delete.label.button.submit"/></html:submit>
        </logic:notEmpty>

        <script type="text/javascript">
            function deleteNewsList() {
                return window.confirm('<bean:message key="confirm.message.delete.newslist"/>');
            }
        </script>
    </div>
</html:form>