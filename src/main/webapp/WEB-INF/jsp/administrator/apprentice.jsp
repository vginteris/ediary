<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <%--<script type="text/javascript" src="../../../js/captainlist.js"></script>--%>
    <link rel="stylesheet" href="css/structure.css">
    <script type="text/javascript">
        function delete_captain(apprenticeid) {
            document.getElementById("row_captain"+apprenticeid).outerHTML = "";

            var postgres
            var url = "/deleteapprentice";
            var parameter ="apprenticeid="+apprenticeid;

            postgres = window.XMLHttpRequest? new XMLHttpRequest():
                new ActiveXObject("Microsoft.XMLHTTP");

            postgres.onreadystatechange = function () {
                if (postgres.readyState == 4 && postgres.status == 200){
                    var responseText = postgres.responseText;
                }
            };
            postgres.open("POST", url+"?"+parameter, true);
            postgres.send();

        }
    </script>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
        <table id="tableList" class="table table-striped table-inverse">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="captain" items="${apprenticeList}">
                <tr id="row_captain${captain.getApprenticeid()}">
                    <td id="id_row_captain${captain.getApprenticeid()}"><c:out value="${captain.getApprenticeid()}"/></td>
                    <td id="name_row_captain${captain.getApprenticeName()}"><c:out value="${captain.getApprenticeName()}"/></td>
                    <td id="surname_row_captain${captain.getApprenticeSurname()}"><c:out value="${captain.getApprenticeSurname()}"/></td>
                    <td >
                        <input type="button" id="delete_captain${captain.getApprenticeid()}" value="DELETE"
                           onclick="delete_captain(${captain.getApprenticeid()})">
                    </td>
                </tr>
            </c:forEach>
            </tbody>


        </table>


    </div>
</section>
<jsp:include page="pagestructure/footer.jsp"/>
</body>
</html>
