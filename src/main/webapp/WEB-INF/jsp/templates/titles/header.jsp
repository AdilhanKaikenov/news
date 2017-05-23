<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<div class="header">
    <div class="header-inscription">
        News Management
    </div>
    <div class="header-languages-ref">
        <a href="${base}/SelectLanguage.do?region=en"><bean:message key="link.label.english"/></a>
        <a href="${base}/SelectLanguage.do?region=ru"><bean:message key="link.label.russian"/></a>
    </div>
</div>