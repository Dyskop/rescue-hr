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
    <%@ include file="common/headerAdmin.jsp"%>
    <c:set var="pageNumber" value="${requestScope.pageNumber}"/>
    <section>
        <div class="container-xxl">
            <table class="table table-bordered caption-top">
                <caption class="caption_title">Присвоение специальных званий</caption>
                <thead class="table-light">
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">Дата присвоения звания</th>
                    <th scope="col">Кому присвоено</th>
                    <th scope="col">Звание</th>
                    <th scope="col">Кем присвоено</th>
                    <th scope="col">№ приказа</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.rankLogs}" var="log">
                    <fmt:parseDate value="${log.gettingDate}" pattern="yyyy-MM-dd" var="gettingDate" type="date"/>
                    <tr>
                        <td></td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${gettingDate}"/></td>
                        <td>${log.employee.surname} ${log.employee.name} ${log.employee.patronymic}</td>
                        <td>${log.rank.rankTitle} внутренней службы</td>
                        <td>${log.orderPublisher}</td>
                        <td>${log.orderNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${pageNumber == '1'}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber + 2}">${pageNumber + 2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber - 1}">${pageNumber - 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/view/ranks-log/${pageNumber + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </section>
    <%@ include file="common/bootstrapScript.jsp"%>
    <%@ include file="common/orderNumberOfTableRaws.jsp"%>
    <%@ include file="common/changeTableRowColorAfterOneClick.jsp"%>
</body>
</html>