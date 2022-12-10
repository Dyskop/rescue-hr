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
    <c:set var="page" value="${requestScope.page}"/>
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
                    <fmt:parseDate value="${log.gettingDate}" pattern="yyyy-MM-dd" var="gettingDate" type="date"/>
                    <tr>
                        <td></td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${gettingDate}"/></td>
                        <td>${log.employee.surname} ${log.employee.name} ${log.employee.patronymic}</td>
                        <td>${log.position.positionTitle}</td>
                        <td>${log.subdivision.subdivisionTitle}</td>
                        <td>${log.orderPublisher}</td>
                        <td>${log.orderNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${page == '1'}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page}">${page}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page + 1}">${page + 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page + 2}">${page + 2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page - 1}">${page - 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page}">${page}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page + 1}">${page + 1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/position-logs?page=${page + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </section>
    <%@ include file="common/bootstrap-script.jsp"%>
    <%@ include file="common/order-number-of-table-raws.jsp"%>
    <%@ include file="common/change-table-row-color-after-one-click.jsp"%>
</body>
</html>