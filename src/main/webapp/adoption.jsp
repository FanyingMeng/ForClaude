<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="adoptions" scope="request" type="java.util.List<nbcc.petadoption.viewmodels.AdoptionViewModel>"></jsp:useBean>
<html>
<head>
    <title>Adoption</title>
</head>
<body>
<h1>Adoption</h1>
<br/>
<a href="./pets">Home</a>
<a href="./adopt">New Adopt</a>


<h2>Adoption Details</h2>
<table>
    <thead>
    <tr>
        <th>Pet Name</th>
        <th>Pet Species</th>
        <th>Pet Age</th>
        <th>Adopter Name</th>
        <th>Adopter Phone</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="adoption" items="${adoptions}">
        <tr>
            <td>${adoption.pet.name}</td>
            <td>${adoption.pet.species}</td>
            <td>${adoption.pet.age}</td>
            <td>${adoption.adoption.adopterName}</td>
            <td>${adoption.adoption.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

