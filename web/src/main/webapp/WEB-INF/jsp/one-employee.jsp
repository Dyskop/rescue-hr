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
<section class="for_top_margin">
    <c:set var="employee" value="${requestScope.employee}"/>
    <div class="container-xxl">
        <div class="row justify-content-evenly">
            <div class="col col-view-one-employee">
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
            <div class="col-2">
                <img src="${pageContext.request.contextPath}/static/img/photo.png" class="employee_photo" alt="">
            </div>
        </div>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Перемещения по службе</caption>
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
                <fmt:parseDate value="${log.gettingDate}" pattern="yyyy-MM-dd" var="gettingDate" type="date"/>
                <tr>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${gettingDate}"/></td>
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
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Присвоение специальных званий</caption>
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
                <fmt:parseDate value="${log.gettingDate}" pattern="yyyy-MM-dd" var="gettingDate" type="date"/>
                <tr>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${gettingDate}"/></td>
                    <td>${log.rank.rankTitle} внутренней службы</td>
                    <td>${log.orderPublisher}</td>
                    <td>${log.orderNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Служебные командировки</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">Дата рег. к/у</th>
                <th scope="col">№ к/у</th>
                <th scope="col">Мето командировки</th>
                <th scope="col">Дата убытия</th>
                <th scope="col">Дата прибытия</th>
                <th scope="col">Цель</th>
                <th scope="col">Дата приказа</th>
                <th scope="col">№ приказа</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Временная нетрудоспособность</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">Вид</th>
                <th scope="col">Диагноз</th>
                <th scope="col">Дата начала</th>
                <th scope="col">Дата окончания</th>
                <th scope="col">№ справки</th>
                <th scope="col">Дата выдачи справки</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Сведения о поощрениях</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">Вид поощрения</th>
                <th scope="col">Кем поощрен</th>
                <th scope="col">Дата приказа</th>
                <th scope="col">№ приказа</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="container-xxl" margin-top="20px">
        <table class="table table-bordered caption-top">
            <caption class="caption_title">Сведения о дисциплинарных взысканиях</caption>
            <thead class="table-light">
            <tr>
                <th scope="col">Вид взыскания</th>
                <th scope="col">Кем наложено</th>
                <th scope="col">Дата приказа</th>
                <th scope="col">№ приказа</th>
                <th scope="col">Статус</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</section>
<%@ include file="common/bootstrap-script.jsp"%>
<%@ include file="common/change-table-row-color-after-one-click.jsp"%>
</body>
</html>