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
        <div class="col col-md-8 col-md-offset-2">
            <form method="post" action="${path}/login" class="form-control ${error!=null ? 'show_error' :''}">
                <input name="username" type="text" placeholder="username">
                <input name="password" type="password" placeholder="password">
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <button type="submit" class="btn-danger">Login</button>
                <h4><a href="${path}/register">Create new user</a></h4>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"></script>
</body>
</html>
