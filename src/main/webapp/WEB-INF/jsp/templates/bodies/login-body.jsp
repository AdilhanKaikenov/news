<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>

<div class="login-box">

    <c:if test="${not empty error}">
        <div class="login-error"><bean:message key="${error}"/></div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="login-msg"><bean:message key="${msg}"/></div>
    </c:if>

    <form action="/login" method="post">

        <table>
            <tr>
                <th><bean:message key="form.label.username"/></th>
                <td><input name="username" id="username" type="text" placeholder="user login"/></td>
            </tr>
            <tr>
                <th><bean:message key="form.label.password"/></th>
                <td><input name="password" id="password" type="password" placeholder="user password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="<bean:message key="sign.in.button"/>"></td>
            </tr>
        </table>

    </form>

</div>
