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
    <script type="text/javascript">
        function delete_apprentice(apprenticeid) {
            document.getElementById("row_apprentice" + apprenticeid).outerHTML = "";

            var postgres
            var url = "/deleteapprentice";
            var parameter = "apprenticeid=" + apprenticeid;

            postgres = window.XMLHttpRequest ? new XMLHttpRequest() :
                new ActiveXObject("Microsoft.XMLHTTP");

            postgres.onreadystatechange = function () {
                if (postgres.readyState == 4 && postgres.status == 200) {
                    var responseText = postgres.responseText;
                }
            };
            postgres.open("POST", url + "?" + parameter, true);
            postgres.send();

        }

        function update_apprentice(apprenticeid) {

            var id = $('#id_row_apprentice' + apprenticeid).text();
            var name = $('#name_row_apprentice' + apprenticeid).text();
            var surname = $('#surname_row_apprentice' + apprenticeid).text();
            var schoolClass = $('#class_row_apprentice' + apprenticeid).text();
            var parent = $('#parent_row_apprentice' + apprenticeid).text();
            var loginuser = $('#loginuser_row_apprentice' + apprenticeid).text();
            alert(name);
            console.log(name);
            console.log(surname);

            $.post("/updateapprentice",
                {
                    apprenticeid: apprenticeid,
                    apprenticeName: name,
                    apprenticeSurname: surname,
                    className: schoolClass,
                    parentName: parent,
                    username: loginuser

                },
                function (data, status) {
                    alert("Update to DB success")
                }
            );

        }

        function myFunction() {
            var input, filter, table, tr, td, i;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[2];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
        <table id="myTable" class="table table-striped table-inverse">
            <thead>
            <tr>
                <input class="border border-primary" type="text" id="myInput" onkeyup="myFunction()"
                       placeholder="Looking by surname...">
                <div>
                    <form action="/uploadapprentices" method="post" enctype="multipart/form-data">
                        <div class="form-control">
                            <label for="fileap">Insert apprentice from CSV</label>
                        <input type="file" id="fileap" name="fileap" placeholder="Inesrt apprentice file">
                        <input type="submit" name="submit" placeholder="submit">
                        </div>
                    </form>
                </div>
            </tr>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Class name</th>
                <th>Parent</th>
                <th>Login name</th>
                <th>Action</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="apprentice" items="${apprenticeList}">
                <tr id="row_apprentice${apprentice.getApprenticeid()}">
                    <td id="id_row_apprentice${apprentice.getApprenticeid()}"><c:out
                            value="${apprentice.getApprenticeid()}"/></td>
                    <td id="name_row_apprentice${apprentice.getApprenticeid()}" contenteditable="true"><c:out
                            value="${apprentice.getApprenticeName()}"/></td>
                    <td id="surname_row_apprentice${apprentice.getApprenticeid()}" contenteditable="true"><c:out
                            value="${apprentice.getApprenticeSurname()}"/></td>
                    <td id="class_row_apprentice${apprentice.getApprenticeid()}"><c:out
                            value="${apprentice.getSchoolClass().getClassName()}"/></td>
                    <td id="parent_row_apprentice${apprentice.getApprenticeid()}"><c:out
                            value="${apprentice.getApprentieParent().getParentName()}"/></td>
                    <td id="loginuser_row_apprentice${apprentice.getApprenticeid()}"><c:out
                            value="${apprentice.getLoginUser().getUsername()}"/></td>
                    <td>
                        <input type="button" id="update_apprentice${apprentice.getApprenticeid()}" value="UPDATE"
                               onclick="update_apprentice(${apprentice.getApprenticeid()})">
                        <input type="button" id="delete_apprentice${apprentice.getApprenticeid()}" value="DELETE"
                               onclick="delete_apprentice(${apprentice.getApprenticeid()})">
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
