
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>


${requestScope.get("res")}
<form action = "/calc" method="post">

    <div class="mb-3">
        <label for="nam1" class="form-label">A</label>
        <input type="text" class="form-control" id="nam1" name="a" placeholder="a">
    </div>
    <div class="mb-3">
        <label for="nam2" class="form-label">B</label>
        <input type="text" class="form-control" id="nam2" name="b" placeholder="a">
    </div>
    <div class="mb-3">
        <label for="act" class="form-label">math action</label>
        <input type="text" class="form-control" id="act" name="operation" placeholder="math action">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<div>
    <p>History</p>
    <c:forEach items="${requestScope.sessions}" var = "session">
        <p>${session}</p>
    </c:forEach>
</div>


</body>
</html>
