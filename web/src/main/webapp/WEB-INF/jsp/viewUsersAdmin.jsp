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
            <div class="row table-title-admin">
                <div class="col-table-button"></div>
                <div class="col-table-title">
                    Все пользователи
                </div>
                <div class="col-table-button"></div>
            </div>
        </div>
        <div class="container-xxl">
            <table class="table table-bordered">
                <thead class="table-light">
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Email</th>
                    <th scope="col">Имя пользователя</th>
                    <th scope="col">Роль</th>
                </tr>
                </thead>
                <tbody>
                <sec
                <c:forEach items="${requestScope.users}" var="user">
                    <tr>
                        <td></td>
                        <td>${user.lastname}</td>
                        <td>${user.firstname}</td>
                        <td>${user.email}</td>
                        <td>${user.username}</td>
                        <td>
                            <c:forEach items="${user.roles}" var="role">
                                ${role.name}
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${pageNumber == '1'}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber + 2}">${pageNumber + 2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber - 1}">${pageNumber - 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/users/${pageNumber + 1}" aria-label="Next">
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