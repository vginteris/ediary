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
        //        function delete_captain(apprenticeid) {
        //            document.getElementById("row_captain" + apprenticeid).outerHTML = "";
        //
        //            var postgres
        //            var url = "/deleteapprentice";
        //            var parameter = "apprenticeid=" + apprenticeid;
        //
        //            postgres = window.XMLHttpRequest ? new XMLHttpRequest() :
        //                new ActiveXObject("Microsoft.XMLHTTP");
        //
        //            postgres.onreadystatechange = function () {
        //                if (postgres.readyState == 4 && postgres.status == 200) {
        //                    var responseText = postgres.responseText;
        //                }
        //            };
        //            postgres.open("POST", url + "?" + parameter, true);
        //            postgres.send();
        //
        //        }
        //
        //        function update_apprentice(apprenticeid) {
        //
        //            var id = $('#id_row_apprentice' + apprenticeid).text();
        //            var name = $('#name_row_apprentice' + apprenticeid).text();
        //            var surname = $('#surname_row_apprentice' + apprenticeid).text();
        //            var schoolClass = $('#class_row_apprentice' + apprenticeid).text();
        //            var parent = $('#parent_row_apprentice' + apprenticeid).text();
        //            var loginuser = $('#loginuser_row_apprentice' + apprenticeid).text();
        //            alert(name);
        //            console.log(name);
        //            console.log(surname);
        //
        ////            private long apprenticeid;
        ////            private String apprenticeName;
        ////            private String apprenticeSurname;
        ////            private SchoolClass schoolClass;
        ////            private Parent apprentieParent;
        ////            private LoginUser loginUser;
        //            $.post("/updateapprentice",
        //                {
        //                    apprenticeid: apprenticeid,
        //                    apprenticeName: name,
        //                    apprenticeSurname: surname,
        //                    className: schoolClass,
        //                    parentName: parent,
        //                    username: loginuser
        //
        //                },
        //                function (data, status) {
        //                    alert("Update to DB success")
        //                }
        //            );
        //
        //        }
    </script>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
        <button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#exampleModal">
            Add user
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">User information</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/insertnewuser" id="saveclass">
                            <input type="text" class="form-control" placeholder="Login username" name="username">
                            <input type="text" class="form-control" placeholder="Login password" name="password">
                            <input type="text" class="form-control" placeholder="Password Confirm" name="passwordComfirm">
                            <select name="roleid">
                                <option value="0">Choose Role</option>
                                <c:forEach var="rolelist" items="${roleList}">
                                    <option value="<c:out value="${rolelist.getRoleid()}"/>"><c:out value="${rolelist.getRoleName()}"/></option>
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
        <table id="myTable" class="table table-striped table-inverse">
            <thead>
            <tr>
                <input class="border border-primary" type="text" id="myInput" onkeyup="myFunction()"
                       placeholder="Looking by class name...">

            </tr>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="useriai" items="${userList}">
                <tr id="row_useriai${useriai.getUserid()}">
                    <td id="id_row_useriai${useriai.getUserid()}"><c:out
                            value="${useriai.getUserid()}"/></td>
                    <td id="username_row_useriai${useriai.getUserid()}" contenteditable="true"><c:out
                            value="${useriai.getUsername()}"/></td>
                    <td id="password_row_useriai${useriai.getUserid()}" contenteditable="true"><c:out
                            value="${useriai.getPassword()}"/></td>
                    <td id="role_row_useriai${useriai.getUserid()}" contenteditable="true"><c:out
                            value="${useriai.userRole.getRoleName()}"/></td>
                    <td>
                        <input type="button" id="update_schoolclass${schoolclass.getSchoolClassid()}" value="UPDATE"
                               onclick="update_schoolclass(${schoolclass.getSchoolClassid()})">
                        <input type="button" id="delete_schoolclass${schoolclass.getSchoolClassid()}" value="DELETE"
                               onclick="delete_schoolclass(${schoolclass.getSchoolClassid()})">
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
