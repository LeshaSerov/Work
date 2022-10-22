<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Categ" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Категории</title>
    <link href="/style/table.css" rel="stylesheet">
</head>

<body>

<table class="table" title="Категории">
    <thead>
    <tr>
        <th>ID</th>
    </tr>
    </thead>
    <tbody>
    <%--    <%--%>
    <%--        for (Categ categ : ) {--%>
    <%--            out.println("<tr onclick=\"location.href='/*'\">");--%>
    <%--            out.println("<td>" + categ.getId() + "</td>");--%>
    <%--            out.println("<td>" + categ.getName() + "</td>");--%>
    <%--            out.println("</tr>");--%>
    <%--        }--%>
    <%--    %>--%>
    <c:forEach items="${list}" var="item">

    </c:forEach>
    </tbody>
</table>
</body>
</html>