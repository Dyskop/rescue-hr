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
<%@ include file="common/header.jsp"%>
<section>
    <div class="container mt-5 mb-5">
        <div class="row d-flex align-items-center justify-content-center">
            <div class="col-md-6">
                <div class="card px-5 py-5"><span class="circle"><i class="fa fa-check"></i></span>
                    <c:set var="user" value="${requestScope.user}"/>
                    <c:set var="rolesNames" value="${requestScope.rolesNames}"/>
                    <form action="${pageContext.request.contextPath}/users/update/${user.id}" method="post">
                        <div class="form-floating mb-2">
                            <input id="label-firstname" type="text" class="form-control" placeholder="Имя"
                                   name="firstname" value="${user.firstname}">
                            <label for="label-firstname">Имя</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-lastname" type="text" class="form-control" placeholder="Фамилия"
                                   name="lastname" value="${user.lastname}">
                            <label for="label-lastname">Фамилия</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-email" type="text" class="form-control" placeholder="email"
                                   name="email" value="${user.email}">
                            <label for="label-email">email</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-username" type="text" class="form-control" placeholder="Имя пользователя"
                                   name="username" value="${user.username}">
                            <label for="label-username">Имя пользователя</label>
                        </div>
                        <div class="form-floating mb-2">
                            <select id="label-role-admin" type="text" class="form-select" name="adminRole">
                                <c:choose>
                                    <c:when test="${rolesNames.contains('ADMIN')}">
                                        <option value="ADMIN">да</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="USER">нет</option>
                                    </c:otherwise>
                                </c:choose>
                                <option value="ADMIN">да</option>
                                <option value="USER">нет</option>
                            </select>
                            <label for="label-role-admin">Роль администратора</label>
                        </div>
                        <%--<div class="text-center mt-4" style="color: red">
                            <c:if test="${error != null}">
                                <c:out value="${error}"/>
                            </c:if>
                        </div>--%>
                        <div class="d-grid gap-2">
                            <button class="btn btn-primary mt-4 signup">Сохранить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="common/bootstrap-script.jsp"%>
</body>
</html>