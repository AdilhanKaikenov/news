<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>

<c:set value="${pageContext.request.contextPath}" var="base"/>

<html:form action="/AddEditNews">
    <div class="form-error-section">
        <html:errors/>
    </div>
    <html:hidden property="news.id"/>
    <table class="news-view-table" cellspacing="20px">
        <tr>
            <th><bean:message key="news.label.title"/></th>
            <td><html:text property="news.title"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.date"/></th>
            <td><html:text property="strDate" readonly="true"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.brief"/></th>
            <td><html:textarea property="news.brief" cols="100" rows="4"/></td>
        </tr>
        <tr>
            <th><bean:message key="news.label.content"/></th>
            <td><html:textarea property="news.content" cols="100" rows="6"/></td>
        </tr>
    </table>
    <div class="view-button-section">
        <html:submit><bean:message key="add.edit.label.save.button.submit"/></html:submit>
        <button property="news" onclick="history.back()">
            <bean:message key="add.edit.label.cancel.button"/>
        </button>
    </div>
</html:form>


