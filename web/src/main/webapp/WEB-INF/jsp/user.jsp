<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>debitor</title>
</head>
<body>
<div>
    <p>Username: </p>
    <ul >
    <c:forEach items="${requestScope.debitorsList}" var="debitorsList">
            <li>
                    ${debitorsList.subdivisions}
            </li>
    </c:forEach>

   </div>
</body>
</html>