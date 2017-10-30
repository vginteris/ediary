<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <%--<script type="text/javascript" src="../../../js/captainlist.js"></script>--%>
    <link rel="stylesheet" href="css/structure.css">
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container" style="margin-top: 50px">
        <div class="row">
            <form action="/newapprentice" method="post">

                <div>
                    <h5>New apprentice</h5>
                    <input type="text" class="form-control" placeholder="Name" name="apprenticeName">
                    <input type="text" class="form-control" placeholder="surname" name="apprenticeSurname">
                    <%--<input type="text" class="form-control" placeholder="classname" name="className">--%>
                    <select name="parentid">
                        <option value="0">Choose Parent</option>
                        <c:forEach var="parent" items="${parentlist}">
                            <option value="<c:out value="${parent.getParentid()}"/>"><c:out value="${parent.getParentName()}"/></option>
                        </c:forEach>
                    </select>
                    <select name="schoolClassid">
                        <option value="0">Choose Class</option>
                        <c:forEach var="schoolclass" items="${classlist}">
                            <option value="<c:out value="${schoolclass.getSchoolClassid()}"/>"><c:out value="${schoolclass.getClassName()}"/></option>
                        </c:forEach>
                    </select>
                    <input type="text" class="form-control" placeholder="Login username" name="username">
                    <input type="text" class="form-control" placeholder="Login password" name="password">
                    <input type="text" class="form-control" placeholder="Password Confirm" name="passwordComfirm">
                    <select name="roleid">
                        <option value="0">Choose Role</option>
                        <c:forEach var="rolelist" items="${rolelist}">
                            <option value="<c:out value="${rolelist.getRoleid()}"/>"><c:out value="${rolelist.getRoleName()}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <input type="submit" name="Insert">
                </div>
            </form>
        </div>
    </div>
</section>
<jsp:include page="pagestructure/footer.jsp"/>
</body>
</html>
