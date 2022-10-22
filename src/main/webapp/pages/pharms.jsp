<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Аптеки</title>
    <link href="/style/table.css" rel="stylesheet">
</head>

<body>

<table class="table" title="Аптеки">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%--    <%--%>
    <%--        for (Pharm pharm : ) {--%>
    <%--            out.println("<tr onclick=\"location.href='/*'\">");--%>
    <%--            out.println("<td>" + pharm.getId() + "</td>");--%>
    <%--            out.println("<td>" + pharm.getAddress() + "</td>");--%>
    <%--            out.println("</tr>");--%>
    <%--        }--%>
    <%--    %>--%>
    <c:forEach items="${list}" var="item">
    <tr onclick = "location.href='..'" >
        <td>${item.id}</td>
        <td>${item.address}</td>
        <td><a href="pharms/edit?id=${item.id}">Edit</a></td>
        <td><a href="pharms/delete?id=${item.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
