<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Аптеки</title>
    <link href="/style/table.css" rel="stylesheet">
</head>

<body>
<div>
    <div>
        <button onclick="location.href='/pharms'">Список аптек</button>
        <button onclick="location.href='/preparats'">Список препаратов</button>
        <button onclick="location.href='/categs'">Список категорий</button>
    </div>
    <div>
        <button onclick="location.href='/pharm/add'">Добавить аптеку</button>
        <button onclick="location.href='preparat/add'">Добавить препарат</button>
        <button onclick="location.href='categ/add'">Добавить категорию</button>
    </div>
</div>



<%--<a href="pharm/add">Добавить Аптеку</a>--%>
<table class="table" title="Аптеки">
    <thead>
    <tr>
        <th>ID</th>
        <th colspan="3">Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='preparats_of_the_pharm?id=${item.id}'" >
        <td>${item.id}</td>
        <td>${item.address}</td>
        <td><a href="pharm/edit?id=${item.id}">Edit</a></td>
        <td><a href="pharm/delete?id=${item.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
