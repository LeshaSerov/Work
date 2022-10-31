<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Аптеки</title>
  <link href="/style/table.css" rel="stylesheet">
</head>
<body>
<a href="preparats_categs/addPreparat">Добавить препарат</a>
<table class="table" title="Категория с препаратами">
  <thead>
  <tr>
    <th>ID</th>
    <th colspan="3">Name</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='preparat?id=${item.id}'" >
      <td>${item.id}</td>
      <td>${item.address}</td>
      <td><a href="preparats_categs/editPreparat?id=${item.id}">Edit</a></td>
      <td><a href="preparats_categs/deletePreparat?id=${item.id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>