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
    <c:set var="employee" value="${requestScope.employee}"/>
    <div class="container-xxl">
        <div class="row">
            <div class="col">
                <table class="table">
                    <tbody>
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
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered">
            <caption>Перемещения по службе</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">Дата назначения на должность</th>
                <th scope="col">Должность</th>
                <th scope="col">Подразделение</th>
                <th scope="col">Кем назначен</th>
                <th scope="col">№ приказа</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.positionLogs}" var="log">
                <fmt:parseDate value="${log.positionGettingDate}" pattern="yyyy-MM-dd" var="positionGettingDate" type="date"/>
                <tr>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${positionGettingDate}"/></td>
                    <td>${log.position.positionTitle}</td>
                    <td>${log.subdivision.subdivisionTitle}</td>
                    <td>${log.orderPublisher}</td>
                    <td>${log.orderNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered">
            <thead class="table-light">
            <tr>
                <th scope="col">Дата присвоения звания</th>
                <th scope="col">Звание</th>
                <th scope="col">Кем присвоено</th>
                <th scope="col">№ приказа</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.rankLogs}" var="log">
                <fmt:parseDate value="${log.rankGettingDate}" pattern="yyyy-MM-dd" var="rankGettingDate" type="date"/>
                <tr>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${rankGettingDate}"/></td>
                    <td>${log.rank.rankTitle} внутренней службы</td>
                    <td>${log.orderPublisher}</td>
                    <td>${log.orderNumber}</td>
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
</body>
</html>