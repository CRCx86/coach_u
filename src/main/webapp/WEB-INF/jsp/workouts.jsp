<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://coachu.com/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="workout.title"/></h3>

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
            <c:forEach items="${workouts}" var="workout">
                <jsp:useBean id="workout" scope="page" type="com.coachu.model.workout.Workout"/>
                <tr>
                    <td>${workout.dateTime}</td>
                    <td>${workout.description}</td>
                    <td>${workout.workoutTypes}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
