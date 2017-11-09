<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/structure.css">
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.js"></script>
    <script type="text/javascript">
        function delete_subject(subjectid) {
            document.getElementById("row_subject" + subjectid).outerHTML = "";

            var postgres
            var url = "/removesubject";
            var parameter = "subjectid=" + subjectid;

            postgres = window.XMLHttpRequest ? new XMLHttpRequest() :
                new ActiveXObject("Microsoft.XMLHTTP");

            postgres.onreadystatechange = function () {
                if (postgres.readyState == 4 && postgres.status == 200) {
                    var responseText = postgres.responseText;
                }
            };
            postgres.open("DELETE", url + "?" + parameter, true);
            postgres.send();

        }

        function deleteTeacherFromSubject(subjectid) {
            var postgres
            var url = "/subteacher";
            var parameter = "subjectid=" + subjectid;

            postgres = window.XMLHttpRequest ? new XMLHttpRequest() :
                new ActiveXObject("Microsoft.XMLHTTP");

            postgres.onreadystatechange = function () {
                if (postgres.readyState == 4 && postgres.status == 200) {
                    var responseText = postgres.responseText;
                }
            };
            postgres.open("DELETE", url + "?" + parameter, true);
            postgres.send();

        }
        function update_subject(subjectid) {

            var id = $('#id_row_apprentice' + subjectid).text();
            var name = $('#name_row_subject' + subjectid).text();
            var type = $('#type_row_subject' + subjectid).text();

            $.post("/updatesubject",
                {
                    subjectid: subjectid,
                    subjectName: name,
                    subjectType: type


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
                td = tr[i].getElementsByTagName("td")[1];
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
        <button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#exampleModal">
            Add new subject
        </button>
        <%--<button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#addmodal">--%>
            <%--bla bla--%>
        <%--</button>--%>

        <!-- 1 Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Subject information</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/addsubject" id="saveclass">
                            <input type="text" class="form-control" id="subjectName" name="subjectName"
                                   placeholder="Subject name">
                            <br>
                            <label>Choose type </label><br>
                            <div class="radio">
                                <label><input type="radio" name="subjectType" checked value="Main">Main</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="subjectType" value="Modul">Modul</label>
                            </div>
                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="document.forms['saveclass'].submit()">
                            Save
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 2 Modal -->
        <%--<div class="modal fade" id="addmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"--%>
             <%--aria-hidden="true">--%>
            <%--<div class="modal-dialog" role="document">--%>
                <%--<div class="modal-content">--%>
                    <%--<div class="modal-header">--%>
                        <%--<h5 class="modal-title" id="addModalTitle">Subject information</h5>--%>
                        <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                            <%--<span aria-hidden="true">&times;</span>--%>
                        <%--</button>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<form method="post" action="/addsubject" id="xxx">--%>
                            <%--<input type="text" class="form-control" id="xxxx" name="subjectName"--%>
                                   <%--placeholder="Subject name222">--%>
                            <%--<br>--%>
                            <%--<label>Choose type 222</label><br>--%>
                            <%--<div class="radio">--%>
                                <%--<label><input type="radio" name="subjectType" checked value="Main">Main2</label>--%>
                            <%--</div>--%>
                            <%--<div class="radio">--%>
                                <%--<label><input type="radio" name="subjectType" value="Modul">Modul22</label>--%>
                            <%--</div>--%>
                        <%--</form>--%>

                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
                        <%--<button type="button" class="btn btn-primary" onclick="document.forms['saveclass'].submit()">--%>
                            <%--Save--%>
                        <%--</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <table id="myTable" class="table table-striped table-inverse">
            <thead>
            <tr>
                <input class="border border-primary" type="text" id="myInput" onkeyup="myFunction()"
                       placeholder="Looking by subject name...">

            </tr>
            <tr>
                <th>Id</th>
                <th>Subject name</th>
                <th>Subject type</th>
                <th>Teacher name</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="subject" items="${subjectList}">
                <tr id="row_subject${subject.getSubjectid()}">
                    <td id="id_row_subject${subject.getSubjectid()}"><c:out
                            value="${subject.getSubjectid()}"/></td>
                    <td id="name_row_subject${subject.getSubjectid()}" contenteditable="true"><c:out
                            value="${subject.getSubjectName()}"/></td>
                    <td id="type_row_subject${subject.getSubjectid()}" contenteditable="true"><c:out
                            value="${subject.getSubjectType()}"/></td>
                    <%--<td id="teacher_row_subject${subject.getSubjectid()}" contenteditable="true"><c:out--%>
                            <%--value="${subject.teacher.getTeacherName()}"/></td>--%>
                    <td id="teacher_row_subject${subject.getSubjectid()}">
                        <c:choose>
                            <c:when test="${subject.teacher.getTeacherName() != null }">
                                ${subject.teacher.getTeacherName()}
                                <%--<input type="button" id="update_techer${subject.getSubjectid()}" value="DELETE"--%>
                                       <%--onclick="deleteTeacherFromSubject(${subject.getSubjectid()})">--%>
                                <a href="#" class="badge badge-secondary" onclick="deleteTeacherFromSubject(${subject.getSubjectid()})">Delete</a>
                            </c:when>
                            <c:otherwise>


                                <!-- Small modal -->
                                <a href="#" class="badge badge-success" data-toggle="modal"
                                   data-target=".bd-example-modal-sm">Add Teacher
                                </a>

                                <div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog"
                                     aria-labelledby="mySmallModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <div class="row">
                                                <div class="col">
                                                    <form action="/subteacher" method="post" id="addTeacher">
                                                        <input type="hidden" name="subjectid"
                                                               value="${subject.getSubjectid()}">

                                                        <select class="form-control" name="teacherid">

                                                            <c:forEach var="teacher" items="${teacherList}">
                                                                <option value="${teacher.getTeacherid()}">${teacher.getTeacherName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </form>
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-secondary btn-sm"
                                                            data-dismiss="modal">Close
                                                    </button>
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-success btn-sm"
                                                            onclick="document.forms['addTeacher'].submit()">Save
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </c:otherwise>
                        </c:choose>

                    </td>
                    <td>
                        <input type="button" id="update_subject${subject.getSubjectid()}" value="UPDATE"
                               onclick="update_subject(${subject.getSubjectid()})">
                        <input type="button" id="delete_subject${subject.getSubjectid()}" value="DELETE"
                               onclick="delete_subject(${subject.getSubjectid()})">
                    </td>
                </tr>
            </c:forEach>
            </tbody>


        </table>


    </div>
</section>
<jsp:include page="pagestructure/footer.jsp"/>
<%--<script type="text/javascript">--%>
<%----%>
<%--</script>--%>
<%--<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.js"></script>--%>
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
