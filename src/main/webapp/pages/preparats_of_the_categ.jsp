<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Аптеки</title>
  <link href="/style/table.css" rel="stylesheet">
</head>
<body>
<h2>Список препаратов относящихся к категории: ${name}</h2>
<a href="/">Main</a>
<a href="preparats_of_the_categ/add?categsid=${id}">Добавить препарат</a>
<table class="table" title="Категория с препаратами">
  <thead>
  <tr>
    <th>ID</th>
    <th colspan="2">Name</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='categs'" >
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td><a href="preparats_of_the_categ/delete?preparatsid=${item.id}&categsid=${id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>