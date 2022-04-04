<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rescue HR</title>
    <%@ include file="common/css-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp"%>
<section>
    <div class="container">
        <table>
            <tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Дата рождения</th>
                <th>Звание</th><th>Должность</th><th>Подразделение</th></tr>
            <c:forEach items="${requestScope.employees}" var="employee">
                <tr><td>${employee.surname}</td><td>${employee.name}</td><td>${employee.patronymic}</td>
                    <td>${employee.birthday}</td><td>${employee.rank.rankTitle}</td>
                    <td>${employee.position.positionTitle}</td><td>${employee.subdivision.subdivisionTitle}</td></tr>
            </c:forEach>
        </table>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
