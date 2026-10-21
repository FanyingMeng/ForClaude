<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pets" scope="request" type="java.util.List<nbcc.petadoption.entities.Pet>"></jsp:useBean>
<html>
<head>
    <title>Adopt</title>
</head>
<body>
<h1>Adopt</h1>
<br/>
<a href="./pets">Home</a>
<a href="./adoption">Adoption Details</a>
<form action="./adopt" method="post">
  <div>
    <label for="petId">Course:
      <select name="petId">
        <option value="">-- Select Pet --</option>
        <c:forEach items="${pets}" var="pet">
          <option value="${pet.id}">${pet.name}</option>
        </c:forEach>
      </select>
    </label>
  </div>

  <div>
    <label for="name">Name:
      <input type="text" name="adopterName">
    </label>
  </div>

  <div>
    <label for="phone">Phone:
      <input type="text" name="phone">
    </label>
  </div>

  <div>
    <input type="submit" value="adoption">
  </div>
</form>
</body>
</html>
