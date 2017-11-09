<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <%--<script type="text/javascript" src="../../../js/captainlist.js"></script>--%>
    <link rel="stylesheet" href="css/structure.css">
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.js"></script>
    <%--<script type="text/javascript">--%>
    <%--</script>--%>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
                <form action="/updateparent" method="post">
                    <div class="form-group">
                        <label for="parentid">id</label>
                        <input type="text" class="form-control" id="parentid"  name="parentid" value="${selectparent.getParentid()}" disabled>
                    </div>
                    <div class="form-group">
                        <label for="parentName">Name</label>
                        <input type="text" class="form-control" id="parentName"  name="parentName" value="${selectparent.getParentName()}">
                    </div>
                    <div class="form-group">
                        <label for="parentSurname">Surname</label>
                        <input type="text" class="form-control" id="parentSurname"  name="parentSurname" value="${selectparent.getParentSurname()}">
                    </div>
                    <div class="form-group">
                        <label for="personalCode">Personal Code</label>
                        <input type="text" class="form-control" id="personalCode"  name="personalCode" value="${selectparent.getPersonalCode()}">
                    </div>
                    <div class="form-group">
                        <label for="parentPhone">Phone</label>
                        <input type="text" class="form-control" id="parentPhone"  name="parentPhone" value="${selectparent.getParentPhone()}">
                    </div>
                    <div class="form-group">
                        <label for="parentEmail">Email</label>
                        <input type="text" class="form-control" id="parentEmail"  name="parentEmail" value="${selectparent.getParentEmail()}">
                    </div>
                    <div class="form-group">
                        <label for="parentAddress">Address</label>
                        <input type="text" class="form-control" id="parentAddress"  name="parentAddress" value="${selectparent.getParentAddress()}">
                    </div>
                    <label for="apprenticeid">Apprentice </label><br>
                    <select multiple class="form-control" name="apprenticeid" id="apprenticeid">
                        <c:forEach var="apprentice" items="${apprenticeList}">
                            <option value="${apprentice.getApprenticeid()}">${apprentice.getApprenticeName()} - ${apprentice.getApprenticeSurname()} </option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
    </div>
</section>
<jsp:include page="pagestructure/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
