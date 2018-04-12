<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://coachu.com/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/workoutDatatables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="workout.title"/></h3>

        <div class="row">
            <div class="cool-sm-7">
                <div class="panel panel-default">
                    <div class="panel-footer text-right">
                        <a class="btn btn-danger" type="button" onclick="updateTable()">
                            <span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <a class="btn btn-primary" onclick="add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            <spring:message code="common.add"/>
        </a>
        <table class="table table-striped display" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="workout.dateTime"/></th>
                <th><spring:message code="workout.description"/></th>
                <th><spring:message code="workout.type"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" id="detailsForm">
                <input type="hidden" id="id" name="id">
                <div class="form-group">
                    <label for="dateTime" class="control-label col-xs-3"><spring:message
                            code="workout.dateTime"/></label>
                    <div class="col-xs-9">
                        <input class="form-control" id="dateTime" name="dateTimeUI"
                               placeholder="<spring:message code="workout.dateTime"/>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="control-label col-xs-3"><spring:message
                            code="workout.description"/></label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="<spring:message code="workout.description"/>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="type" class="control-label col-xs-3"><spring:message
                            code="workout.type"/></label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" id="type" name="type"
                               placeholder="<spring:message code="workout.type"/>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <button class="btn btn-primary" type="button" onclick="save()">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
<jsp:include page="fragments/i18n.jsp"/>
<script type="text/javascript">
    i18n["addTitle"] = '<spring:message code="workout.add"/>';
    i18n["editTitle"] = '<spring:message code="workout.edit"/>';
</script>
</html>
