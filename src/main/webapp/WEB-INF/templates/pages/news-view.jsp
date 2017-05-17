<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insert page="/WEB-INF/templates/base-layout.jsp" flush="true">
    <%--@elvariable id="news" type="com.epam.adk.web.news.model.News"--%>
    <tiles:put name="title">${news.title}</tiles:put>
    <tiles:put name="header" value="header"/>
    <tiles:put name="menu" value="menu"/>
    <tiles:put name="body" value="news.view"/>
    <tiles:put name="footer" value="footer"/>
</tiles:insert>