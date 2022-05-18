<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rescue HR</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <%@ include file="common/css-connect.jsp"%>
</head>
<body>
    <%@ include file="common/headerAdmin.jsp"%>
    <c:set var="pageNumber" value="${requestScope.pageNumber}"/>
    <section>
        <div class="container-xxl">
            <div class="row table-title-admin">
                <div class="col-table-button"></div>
                <div class="col-table-title">
                    Название органа по чрезвычайным ситуциям
                </div>
                <div class="col-table-button">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/employees/create" role="button">
                        Новый сотрудник
                    </a>
                </div>
            </div>
        </div>
        <div class="container-xxl">
            <table class="table table-bordered">
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
                    <th scope="col">Действие</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.employees}" var="employee">
                    <fmt:parseDate value="${employee.birthday}" pattern="yyyy-MM-dd" var="birthday" type="date"/>
                    <tr ondblclick="document.location = '${pageContext.request.contextPath}/admin/employee/${employee.id}';">
                        <td></td>
                        <td>${employee.surname}</td>
                        <td>${employee.name}</td>
                        <td>${employee.patronymic}</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${birthday}"/></td>
                        <td>${employee.rank.rankTitle} вн. сл.</td>
                        <td>${employee.position.positionTitle}</td>
                        <td>${employee.subdivision.subdivisionTitle}</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    выбрать
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/delete/${employee.id}" onclick="return confirm('Подтвердить удаление?')" role="button">
                                        удалить
                                    </a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/update/${employee.id}" role="button">
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
                        <c:when test="${pageNumber == '1'}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber + 2}">${pageNumber + 2}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber - 1}">${pageNumber - 1}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber}">${pageNumber}</a></li>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber + 1}">${pageNumber + 1}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/employees/${pageNumber + 1}" aria-label="Next">
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