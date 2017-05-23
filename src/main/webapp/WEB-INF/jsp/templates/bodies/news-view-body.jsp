<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<html:form action="/DeleteNews.do" method="post">

    <html:hidden property="selectedNewsIds" value="${news.id}"/>
    <html:hidden property="news.title" value="pass_validation"/>
    <html:hidden property="news.brief" value="pass_validation"/>
    <html:hidden property="news.content" value="pass_validation"/>

    <table class="news-view-table" cellspacing="20px">
        <tr>
            <th><bean:message key="news.label.title"/></th>
            <td><bean:write name="NewsForm" property="news.title"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.date"/></th>
            <td><bean:write name="NewsForm" property="strDate" format="dd/MM/yyyy/"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.brief"/></th>
            <td><bean:write name="NewsForm" property="news.brief"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.content"/></th>
            <td><bean:write name="NewsForm" property="news.content"/></td>
        </tr>
    </table>
    <div class="view-button-section">
            <%--@elvariable id="news" type="com.epam.adk.web.news.model.News"--%>
            <html:link styleClass="general-button" action="/ShowPage.do?method=showNewsForm&id=${news.id}"><bean:message
                    key="link.label.edit"/></html:link>
        <html:submit styleClass="general-button" onclick="return deleteNewsList()"><bean:message
                key="delete.label.button.submit"/></html:submit>

        <script type="text/javascript">
            function deleteNewsList() {
                return window.confirm('<bean:message key="confirm.message.delete.newslist"/>');
            }
        </script>
    </div>

</html:form>



