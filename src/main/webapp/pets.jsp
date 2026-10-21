
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pets" scope="request" type="java.util.List<nbcc.petadoption.entities.Pet>"></jsp:useBean>
<html>
<head>
    <title>Pets</title>
</head>
<body>
<h1>Pets</h1>
<br/>
<a href="./adopt">New Adopt</a>
<a href="./adoption">Adoption Details</a>


<h2>Pets Details</h2>
<table>
    <thead>
    <tr>
        <th>Pet Name</th>
        <th>Pet Species</th>
        <th>Pet Age</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.name}</td>
            <td>${pet.species}</td>
            <td>${pet.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
