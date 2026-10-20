<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="viewModels" scope="request" type="nbcc.assignmentservlet.viewmodels.CourseRegistrationViewModel"/>
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
        <c:forEach var="course" items="${viewModel.course}">
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
        <c:forEach var="courseRegistration" items="${viewModel.courseRegistration}">
            <tr>
                <td></td>
                <td>${courseRegistration.firstName}</td>
                <td>${courseRegistration.lastName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>