<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insert page="/WEB-INF/jsp/templates/base-layout.jsp" flush="true">
    <tiles:put name="title">403</tiles:put>
    <tiles:put name="header" value="header"/>
    <tiles:put name="menu" value="menu"/>
    <tiles:put name="body" value="access.denied.403"/>
    <tiles:put name="footer" value="footer"/>
</tiles:insert>
