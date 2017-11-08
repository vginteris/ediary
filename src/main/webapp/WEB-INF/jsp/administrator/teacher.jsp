<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <%--<script type="text/javascript" src="../../../js/captainlist.js"></script>--%>
    <link rel="stylesheet" href="css/structure.css">
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.js"></script>
    <script type="text/javascript">
        function delete_teacher(teacherid) {
            document.getElementById("row_teacher"+teacherid).outerHTML = "";

            var postgres
            var url = "/deleteteacher";
            var parameter ="teacherid="+teacherid;

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
        function update_teacher(teacherid) {


            var id = $('#id_row_teacher' + teacherid).text();
            var name = $('#name_row_teacher' + teacherid).text();
            var surname = $('#surname_row_teacher' + teacherid).text();
            var phone = $('#phone_row_teacher' + teacherid).text();
            var email = $('#email_row_teacher' + teacherid).text();
            var prCode = $('#personalcode_row_teacher' + teacherid).text();

            $.post("/updateteacher",
                {
                    teacherid: teacherid,
                    teacherName: name,
                    teacherSurname: surname,
                    teacherPhone: phone,
                    teacherEmail: email,
                    personalCode: prCode
                },
                function (data, status) {
                    alert("Update to DB success")
                }
            );

        }
    </script>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
        <button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#exampleModal">
            Add new teacher
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Teacher information</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <%--private String teacherName;--%>
                        <%--private String teacherSurname;--%>
                        <%--private String teacherPhone;--%>
                        <%--private String teacherEmail;--%>
                        <%--private List<SchoolSubject> subjects;--%>
                        <%--private SchoolClass schoolClass;--%>
                        <%--private LoginUser loginUser;--%>
                        <form method="post" action="/newapteacher" id="saveclass">
                            <input type="text" class="form-control" id="teacherName" name="teacherName" placeholder="Name">
                            <input type="text" class="form-control" id="teacherSurname" name="teacherSurname" placeholder="Surname">
                            <input type="text" class="form-control" id="personalCode" name="personalCode" placeholder="Personal Code">
                            <input type="text" class="form-control" id="teacherPhone" name="teacherPhone" placeholder="Phone">
                            <input type="text" class="form-control" id="teacherEmail" name="teacherEmail" placeholder="Email">
                            <input type="text" class="form-control" id="className" name="className" placeholder="New or exist class">
                            <input type="hidden" value="2" name="roleid" id="roleid">
                            <%--<input type="text" class="form-control" placeholder="Login username" name="username">--%>
                            <br>
                            <label for="subject">Subject </label><br>
                            <select multiple class="form-control" name="subject" id="subject">
                                <c:forEach var="subject" items="${subjectList}">
                                    <option value="${subject}">${subject}</option>
                                </c:forEach>
                            </select>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="document.forms['saveclass'].submit()">Save</button>
                    </div>
                </div>
            </div>
        </div>
        <table id="tableList" class="table table-striped table-inverse">
            <thead>
            <tr>
                <input class="border border-primary" type="text" id="myInput" onkeyup="myFunction()"
                       placeholder="Looking by surname...">
            </tr>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Personal Code</th>
                <th>Subjects</th>
                <th>School class</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="teacher" items="${teacherList}">
                <tr id="row_teacher${teacher.getTeacherid()}">
                    <td id="id_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getTeacherid()}"/></td>
                    <td id="name_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getTeacherName()}"/></td>
                    <td id="surname_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getTeacherSurname()}"/></td>
                    <td id="phone_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getTeacherPhone()}"/></td>
                    <td id="email_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getTeacherEmail()}"/></td>
                    <td id="personalcode_row_teacher${teacher.getTeacherid()}" contenteditable="true"><c:out value="${teacher.getPersonalCode()}"/></td>
                    <td>
                        <c:forEach var="subjects" items="${teacher.subjects}">
                            <c:out value="${subjects.getSubjectName()}"/>
                            <br>
                        </c:forEach>
                    </td>
                    <td id="schoolclass_row_teacher${teacher.getTeacherid()}"><c:out value="${teacher.schoolClass.getClassName()}"/></td>
                    <td >
                        <input type="button" id="update_apprentice${teacher.getTeacherid()}" value="UPDATE"
                               onclick="update_teacher(${teacher.getTeacherid()})">
                        <input type="button" id="delete_teacher${teacher.getTeacherid()}" value="DELETE"
                               onclick="delete_teacher(${teacher.getTeacherid()})">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<jsp:include page="pagestructure/footer.jsp"/>
<script type="text/javascript">
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
<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
