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
                    <th scope="col">Действие</th>
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
                        <td>${user.role}</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    выбрать
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/users/remove/${user.id}" onclick="return confirm('Подтвердить удаление?')" role="button">
                                        удалить
                                    </a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/users/update-form/${user.id}" role="button">
                                        изменить
                                    </a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${page == '1'}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/users?page=${page}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page}">${page}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page + 1}">${page + 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page + 2}">${page + 2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/users?page=${page + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/users?page=${page - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page - 1}">${page - 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page}">${page}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?page=${page + 1}">${page + 1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/users?page=${page + 1}" aria-label="Next">
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