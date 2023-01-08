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
    <%@ include file="common/login-registration-header.jsp"%>
    <section>
        <div class="container mt-5 mb-5">
            <div class="row d-flex align-items-center justify-content-center">
                <div class="col-md-6">
                    <div class="card px-5 py-5"><span class="circle"><i class="fa fa-check"></i></span>
                        <form action="${pageContext.request.contextPath}/login" method="post">
                            <div class="form-floating mb-3">
                                <input id="label-username" type="text" class="form-control" placeholder="Имя пользователя"
                                       name="username">
                                <label for="label-username">Имя пользователя</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input id="label-password" type="password" class="form-control" placeholder="Пароль"
                                       name="password">
                                <label for="label-password">Пароль</label>
                            </div>
                            <div class="text-center mt-4" style="color: red">
                                <c:if test="${error != null}">
                                    <c:out value="${error}"/>
                                </c:if>
                            </div>
                            <div class="d-grid gap-2">
                                <button class="btn btn-primary mt-4 signup">Вход</button>
                            </div>
                        </form>
                        <div class="text-center mt-4"><span>Ещё не зарегистрированы?</span> <a
                                href="<c:url value="/registration"/>"
                                class="text-decoration-none text-link">Регистрация</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="common/bootstrap-script.jsp"%>
</body>
</html>