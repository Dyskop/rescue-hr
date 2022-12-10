<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rescue HR</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <%@ include file="../common/css-connect.jsp"%>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<section>
    <div class="container-xxl">
        <div class="row table-title-admin">
            <div class="col-table-button"></div>
            <div class="col-table-title">
                Островецкий районный отдел по чрезвычайным ситуциям
            </div>
        </div>
        <div class="text-xl-center">
            <p>
                Данный сотрудник не найден.
            </p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/employees" role="button">
                Перейти к списку сотрудников
            </a>
        </div>
    </div>
</section>
<%@ include file="../common/bootstrap-script.jsp"%>
</body>
</html>