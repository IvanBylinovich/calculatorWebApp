<%--
  Created by IntelliJ IDEA.
  User: іван
  Date: 25.04.2021
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="_header.jsp"/>
    <title>$Title$</title>
</head>
<body>
<c:if test="${sessionScope.user==null}">
    <h1> To get access to the calculator, you need to register </h1>
    <form action="/reg" method="get">
        <button type="go to registration" class="btn btn-primary">go to registration</button>
    </form>
</c:if>
<c:if test="${sessionScope.user!=null}">
    <h1> Hi! ${sessionScope.user.name} </h1>
    <form action="/calc" method="get">
        <button type="Let's count" class="btn btn-primary">Let's count</button>
    </form>
</c:if>
<div class="alert alert-info" role="alert">
    ${requestScope.answer}
</div>




</body>
</html>
