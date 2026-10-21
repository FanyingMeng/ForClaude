<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="courses" scope="request" type="java.util.List<nbcc.assignmentservlet.entities.Course>"/>
<html>
<head>
    <title>Course Registration</title>
</head>
<body>
<h1>Registration</h1>

<form action="./registration" method="post">
    <div>
        <label for="courseId">Course:
            <select name="courseId">
                <option value="">-- Select Course --</option>
                <%-- Todo Add code here to display courses--%>
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
            </select>
        </label>
    </div>

    <div>
        <label for="name">First Name:
            <input type="text" name="firstName">
        </label>
    </div>

    <div>
        <label for="name">Last Name:
            <input type="text" name="lastName">
        </label>
    </div>

    <div>
        <input type="submit" value="Register">
    </div>
</form>
</body>
</html>
