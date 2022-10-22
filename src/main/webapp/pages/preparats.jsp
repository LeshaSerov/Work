<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Preparat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Препараты</title>
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
        <button onclick="location.href='*'">Добавить аптеку</button>
        <button onclick="location.href='*'">Добавить препарат</button>
        <button onclick="location.href='*'">Добавить категорию</button>
    </div>
</div>
<table class="table" title="Препараты">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <%--    <%--%>
    <%--        for (Preparat preparat : ) {--%>
    <%--            out.println("<tr onclick=\"location.href='/*'\">");--%>
    <%--            out.println("<td>" + preparat.getId() + "</td>");--%>
    <%--            out.println("<td>" + preparat.getName() + "</td>");--%>
    <%--            out.println("</tr>");--%>
    <%--        }--%>
    <%--    %>--%>
    <c:forEach items="${list}" var="item">

    </c:forEach>
    </tbody>
</table>
</body>
</html>