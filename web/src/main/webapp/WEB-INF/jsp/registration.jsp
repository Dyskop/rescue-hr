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
    <%@ include file="common/login-registration-header.jsp"%>
    <section>
        <div class="container mt-5 mb-5">
            <div class="row d-flex align-items-center justify-content-center">
                <div class="col-md-6">
                    <div class="card px-5 py-5"><span class="circle"><i class="fa fa-check"></i></span>
                        <form action="${pageContext.request.contextPath}/registration" method="post">
                            <div class="form-floating mb-2">
                                <input id="label-firstname" type="text" class="form-control" placeholder="Имя"
                                       name="firstname" required>
                                <label for="label-firstname">Имя</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input id="label-lastname" type="text" class="form-control" placeholder="Фамилия"
                                       name="lastname" required>
                                <label for="label-lastname">Фамилия</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input id="label-email" type="text" class="form-control" placeholder="Email"
                                       name="email" required>
                                <label for="label-email">Email</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input id="label-username" type="text" class="form-control" placeholder="Имя пользователя"
                                       name="username" required>
                                <label for="label-username">Имя пользователя</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input id="label-password" type="password" class="form-control" placeholder="Пароль"
                                       name="password" required>
                                <label for="label-password">Пароль</label>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label" for="flexCheckChecked"> Я принимаю условия пользовательского соглашения </label>
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked"
                                       checked style="background-color: #332464">
                            </div>
                            <div class="text-center mt-4" style="color: red">
                                <c:if test="${error != null}">
                                    <c:out value="${error}"/>
                                </c:if>
                            </div>
                            <div class="d-grid gap-2">
                                <button class="btn btn-primary mt-4 signup">Регистрация</button>
                            </div>
                        </form>

                        <div class="text-center mt-4"><span>Уже зарегистрированы?</span> <a href="<c:url value="/login"/>"
                                                                                        class="text-decoration-none" style="color: #332464">Вход</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="common/bootstrap-script.jsp"%>
</body>
</html>