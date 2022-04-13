<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rescue HR</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <%@ include file="common/css-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp"%>
<section>
    <div class="container-xxl">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Название органа по чрезвычайным ситуциям</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">№</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Имя</th>
                <th scope="col">Отчество</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Звание</th>
                <th scope="col">Должность</th>
                <th scope="col">Подразделение</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.employees}" var="employee">
                <fmt:parseDate value="${employee.birthday}" pattern="yyyy-MM-dd" var="birthday" type="date"/>
                <tr onclick="document.location = '${pageContext.request.contextPath}/view/employee/${employee.id}';">
                    <td></td>
                    <td>${employee.surname}</td>
                    <td>${employee.name}</td>
                    <td>${employee.patronymic}</td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${birthday}"/></td>
                    <td>${employee.rank.rankTitle} вн. сл.</td>
                    <td>${employee.position.positionTitle}</td>
                    <td>${employee.subdivision.subdivisionTitle}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
<script>
    $('.table tbody tr').each(function(i) {
        var number = i + 1;
        $(this).find('td:first').text(number);
    });
</script>
</body>
</html>