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
        <div class="row">
            <div class="col">
                <table class="table">
                    <tbody>
                    <c:set var="employee" value="${requestScope.employee}"/>
                    <fmt:parseDate value="${employee.birthday}" pattern="yyyy-MM-dd" var="birthday" type="date"/>
                    <tr>
                        <th scope="row">ФИО</th>
                        <td>${employee.surname} ${employee.name} ${employee.patronymic}</td>
                    </tr>
                    <tr>
                        <th scope="row">Специальное звание</th>
                        <td>${employee.rank.rankTitle} внутренней службы</td>
                    </tr>
                    <tr>
                        <th scope="row">Занимаемая должность</th>
                        <td>${employee.position.positionTitle}</td>
                    </tr>
                    <tr>
                        <th scope="row">Подразделение</th>
                        <td>${employee.subdivision.subdivisionTitle}</td>
                    </tr>
                    <tr>
                        <th scope="row">Дата рождения</th>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${birthday}"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <img src="${pageContext.request.contextPath}/static/img/photo.jpg" class="employee_photo" alt="">
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
</body>
</html>