<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<div class="news-list-filter">

    <form action="${base}/news/filtered" method="post">
        Title: <input type="text" name="title"/>
        Date From: <input type="date" name="from"/>
        Date To:<input type="date" name="to"/>
        <input type="submit" value="Filter">
    </form>

</div>

<div align="center">
    <%--@elvariable id="pageNumber" type="java.lang.Integer"--%>
    <c:if test="${pageNumber != 1}">
        <c:forEach var="i" begin="${1}" end="${pageNumber}">
            <a href="${base}/ShowPage.do?method=showNewsList&page=${i}">${i}</a>
        </c:forEach>
    </c:if>
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
                <a href="${base}/user/news/view?id=${news.id}" class="general-button"><bean:message
                        key="link.label.view"/></a>/
                <a href="${base}/admin/news/edit?id=${news.id}" class="general-button"><bean:message
                        key="link.label.edit"/></a>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <html:multibox property="selectedNewsIds" value="${news.id}"/>
                </sec:authorize>
            </div>
        </div>

    </logic:iterate>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="delete-button-section">
        <logic:notEmpty name="NewsForm" property="newsList">
            <html:submit styleClass="general-button" onclick="return deleteNewsList()"><bean:message
                    key="delete.label.button.submit"/></html:submit>
        </logic:notEmpty>
    </sec:authorize>

    <script type="text/javascript">
        function deleteNewsList() {
            return window.confirm('<bean:message key="confirm.message.delete.newslist"/>');
        }
    </script>
    </div>
</html:form>