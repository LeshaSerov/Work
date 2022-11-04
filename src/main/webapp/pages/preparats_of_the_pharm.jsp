<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Аптеки</title>
  <link href="/style/table.css" rel="stylesheet">
</head>
<body>
<h2>Список препаратов которые есть в аптеке: ${address}</h2>
<a href="/">Main</a>
<a href="preparats_of_the_pharm/add?pharmsid=${id}">Добавить препарат</a>
<table class="table" title="Аптека с препаратами">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th colspan="3">Count</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='preparats'" >
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.count}</td>
      <td><a href="preparats_of_the_pharm/edit?pharmsid=${id}&preparatsid=${item.id}">Edit</a></td>
      <td><a href="preparats_of_the_pharm/delete?pharmsid=${id}&preparatsid=${item.id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>