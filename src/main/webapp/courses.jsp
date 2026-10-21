<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="registrations" scope="request" type="java.util.List<nbcc.assignmentservlet.viewmodels.CourseRegistrationViewModel>"/>
<jsp:useBean id="courses" scope="request" type="java.util.List<nbcc.assignmentservlet.entities.Course>"/>
<!DOCTYPE html>
<html>
<head>
    <title>NBCC Courses</title>
</head>
<body>
<h1>NBCC Reservations</h1>
<br/>
<a href="./registration">New Registration</a>


<h2>Available Courses</h2>
<table>
    <thead>
    <tr>
        <th>Course Name</th>
        <th>Credit Hours</th>
    </tr>
    </thead>
    <tbody>
<%--    Todo Implement jsp and html here--%>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.name}</td>
                <td>${course.creditHours}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<h2>Registrations</h2>

<table>
    <thead>
    <tr>
        <th>Course Name</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <%--    Todo Implement jsp and html here--%>
        <c:choose>
            <c:when test="${empty registrations}">
                <tr>
                    <td>No Registrations found</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="registration" items="${registrations}">
                    <tr>
                        <td>${registration.course.name}</td>
                        <td>${registration.courseRegistration.firstName}</td>
                        <td>${registration.courseRegistration.lastName}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>

</body>
</html>