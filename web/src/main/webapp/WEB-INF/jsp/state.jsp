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
                <caption class="caption_title">Штатное расписание</caption>
                <thead class="table-light">
                <tr>
                    <th scope="col">Подразделение</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Штатная численность</th>
                    <th scope="col">Укомплектовано позиций</th>
                    <th scope="col">Количество вакансий</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="actualAmounts" value="${requestScope.actualAmounts}"/>
                <c:set var="freeAmounts" value="${requestScope.freeAmounts}"/>
                <c:forEach items="${requestScope.stateList}" var="state">
                    <tr>
                        <td>${state.subdivision.subdivisionTitle}</td>
                        <td>${state.position.positionTitle}</td>
                        <td>${state.stateAmount}</td>
                        <td>${actualAmounts.get(state)}</td>
                        <td>${freeAmounts.get(state)}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
    <%@ include file="common/bootstrap-script.jsp"%>
    <%@ include file="common/change-table-row-color-after-one-click.jsp"%>
</body>
</html>