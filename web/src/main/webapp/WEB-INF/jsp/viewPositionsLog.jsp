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
            <caption class="caption_title">Перемещения по службе</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">№</th>
                <th scope="col">Дата назначения на должность</th>
                <th scope="col">Кто назначен</th>
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
                    <td></td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${positionGettingDate}"/></td>
                    <td>${log.employee.surname} ${log.employee.name} ${log.employee.patronymic}</td>
                    <td>${log.position.positionTitle}</td>
                    <td>${log.subdivision.subdivisionTitle}</td>
                    <td>${log.orderPublisher}</td>
                    <td>${log.orderNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<script>
    $('.table tbody tr').each(function(i) {
        var number = i + 1;
        $(this).find('td:first').text(number);
    });
</script>
</body>
</html>