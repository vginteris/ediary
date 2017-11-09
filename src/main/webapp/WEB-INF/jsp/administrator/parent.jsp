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
        function delete_parent(parentid) {
            var id = $('#id_row_parent' + parentid).text();
            var name = $('#name_row_parent' + parentid).text();
            var surname = $('#surname_row_parent' + parentid).text();
            var phone = $('#phone_row_parent' + parentid).text();
            var email = $('#email_row_parent' + parentid).text();
            var prCode = $('#personalcode_row_parent' + parentid).text();

            $.post("/deleteparent",
                {
                    parentid: parentid,
                    parentName: name,
                    parentSurname: surname,
                    parentPhone: phone,
                    parentEmail: email,
                    personalCode: prCode
                },
                function (data, status) {
//                    alert("Delete from DB success")
                }
            );

        }

//        function update_parent(parentid) {
//
//            $.post("/updateparent",
//                {
//                    parentid: parentid
//
//                },
//                function (data, status) {
//
//                }
//            );

//        }
    </script>
</head>
<body>
<jsp:include page="pagestructure/header.jsp"/>
<jsp:include page="pagestructure/navigator.jsp"/>
<section>
    <div class="container">
        <button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#exampleModal">
            Add new parent
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Parent information</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/newaparent" id="saveclass">
                            <input type="text" class="form-control" id="parentName" name="parentName"
                                   placeholder="Name">
                            <input type="text" class="form-control" id="parentSurname" name="parentSurname"
                                   placeholder="Surname">
                            <input type="text" class="form-control" id="personalCode" name="personalCode"
                                   placeholder="Personal Code">
                            <input type="text" class="form-control" id="parentPhone" name="parentPhone"
                                   placeholder="Phone">
                            <input type="text" class="form-control" id="parentEmail" name="parentEmail"
                                   placeholder="Email">
                            <input type="text" class="form-control" id="parentAddress" name="parentAddress"
                                   placeholder="Address">
                            <input type="hidden" value="4" name="roleid" id="roleid">
                            <%--<input type="text" class="form-control" placeholder="Login username" name="username">--%>
                            <br>
                            <label for="children">Children </label><br>
                            <select multiple class="form-control" name="children" id="children">
                                <c:forEach var="apprentice" items="${apprenticeList}">
                                    <option value="${apprentice.getApprenticeid()}">${apprentice.getApprenticeName()}-${apprentice.getPersonalCode()}</option>
                                </c:forEach>
                            </select>
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
                <th>Address</th>
                <th>Children</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="parent" items="${parentList}">
                <tr id="row_parent${parent.getParentid()}">
                    <td id="id_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentid()}"/></td>
                    <td id="name_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentName()}"/></td>
                    <td id="surname_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentSurname()}"/></td>
                    <td id="phone_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentPhone()}"/></td>
                    <td id="email_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentEmail()}"/></td>
                    <td id="personalcode_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getPersonalCode()}"/></td>
                    <td id="address_row_parent${parent.getParentid()}" contenteditable="true"><c:out
                            value="${parent.getParentAddress()}"/></td>
                    <td>
                        <c:forEach var="apprentice" items="${parent.parentChildrenList}">
                            <c:out value="${apprentice.getApprenticeName()}"/>
                            <br>
                        </c:forEach>
                    </td>
                    <td>
                        <form action="/updateparent" method="get">
                            <button type="submit" id="parentid" name="parentid" value="${parent.getParentid()}">UPDATE</button>
                        </form>
                        <input type="button" id="delete_parent${parent.getParentid()}" value="DELETE"
                               onclick="delete_parent(${parent.getParentid()})">
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
