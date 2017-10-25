<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Registracijos langas</title>
    <link type="text/css" rel="stylesheet" href="${path}/resources/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">
    <div class="row">

        <form:form method="post" action="/register" modelAttribute="userForm" cssClass="formdesign">
            <div class="col col-md-8 col-md-offset-2">
                <form:input type="text" path="username" placeholder="username" autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
            <div class="col col-md-8 col-md-offset-2">
                <form:input type="password" path="password" placeholder="password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
            <div class="col col-md-8 col-md-offset-2">
                <form:input type="password" path="passwordComfirm" placeholder="passwordconfirm"></form:input>
                <form:errors path="passwordComfirm"></form:errors>
            </div>
            <form:input path="userRole" value="1"></form:input>
            <div class="col col-md-8 col-md-offset-2">
                <form:button type="submit" class="btn btn-danger" value="save">Save</form:button>
            </div>
        </form:form>
    </div>
</div>
</div>
<script type="text/javascript" src="${path}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"></script>
</body>
</html>
