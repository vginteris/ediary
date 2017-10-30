<%--***************************************MODALAS PRIDETI MOKYTOJA*****************************************--%>
<!-- Button trigger modal -->
<button type="button" class="btn btn-secondary margin_top_15px" data-toggle="modal" data-target="#exampleModal">
    Naujo mokytojo įvedimas
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Mokytojo įvedimas</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/teacher" id="saveteacher">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Vardas">
                    <input type="text" class="form-control" id="surname" name="surname" placeholder="Pavardė">
                    <input type="text" class="form-control" id="email" name="email" placeholder="El. pašto adresas">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Telefono numeris">
                    <br>
                    <label for="subject">Dalykas: </label><br>
                    <select multiple class="form-control" name="subject" id="subject">

                        <c:forEach var="subject" items="${subjectList}">

                            <option value="${subject.getSubject()}">${subject.getSubject()}</option>
                        </c:forEach>

                    </select>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Uždaryti</button>
                <button type="button" class="btn btn-primary" onclick="document.forms['saveteacher'].submit()">Išsaugoti</button>
            </div>
        </div>
    </div>
</div>