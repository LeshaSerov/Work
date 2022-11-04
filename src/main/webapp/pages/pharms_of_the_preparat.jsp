<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Аптеки</title>
  <link href="/style/table.css" rel="stylesheet">
</head>
<body>
<h2>Список аптек в которых содержится препарат: ${name}</h2>
<a href="/">Main</a>
<a href="pharms_of_the_preparat/add?preparatsid=${id}">Добавить аптеку</a>
<table class="table" title="Препарат с аптеками">
  <thead>
  <tr>
    <th>ID</th>
    <th>Address</th>
    <th colspan="3">Count</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='pharms'">
      <td>${item.id}</td>
      <td>${item.address}</td>
      <td>${item.count}</td>
      <td><a href="pharms_of_the_preparat/edit?pharmsid=${item.id}&preparatsid=${id}">Edit</a></td>
      <td><a href="pharms_of_the_preparat/delete?pharmsid=${item.id}&preparatsid=${id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>