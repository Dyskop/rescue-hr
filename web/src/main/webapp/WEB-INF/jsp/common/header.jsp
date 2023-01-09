<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-xxl">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
                <img src="${pageContext.request.contextPath}/static/img/buttonhole.png" width="70" height="70" alt=""> Rescue HR
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/users">Пользователи</a>
                        </li>
                    </sec:authorize>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/employees">Сотрудники</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="journals"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">Журналы
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/position-logs">Перемещения по службе</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/rank-logs">Присвоение званий</a></li>
                            <li><a class="dropdown-item" href="#">Командировки</a></li>
                            <li><a class="dropdown-item" href="#">Больничные</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/state">Штат</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Контракты</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Отпуски</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="discipline"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">Дисциплина
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Поощрения</a></li>
                            <li><a class="dropdown-item" href="#">Взыскания</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="user"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">${pageContext.request.userPrincipal.name}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" id="Logout">Выход</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex" action="${pageContext.request.contextPath}/search" method="get">
                    <input class="form-control me-2" type="search" placeholder="Введите данные" aria-label="Search" name="data">
                    <button class="btn btn-outline-success" type="submit">Поиск</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<%@ include file="logout-post-method-without-form-script.jsp"%>