<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="utf-8">
    <title>Main</title>
</head>
<body>

<%--<%=request.getAttribute("list")%>--%>
<%--<c:forEach var="item" items="${list}" >--%>
<%--    ${item.number}--%>
<%--</c:forEach>--%>

<%--<%--%>
<%--    List<TD> list = (List<TD>) request.getAttribute("list");--%>
<%--    if (list != null && !list.isEmpty())--%>
<%--    {--%>
<%--        for (TD item: list){--%>
<%--            out.println("<p>" + item.getNumber() + "<p>");--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
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
<%--<select id="selectID">--%>
<%--    <option value=”GR”>Green</option>--%>
<%--    <option value=”YE”>Yellow</option>--%>
<%--    <option value=”BL”>Black</option>--%>
<%--</select>--%>
</body>
</html>