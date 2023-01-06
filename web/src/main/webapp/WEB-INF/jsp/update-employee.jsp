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
                    <c:set var="employee" value="${requestScope.employee}"/>
                    <form action="${pageContext.request.contextPath}/employees/update/${employee.id}" method="post">
                        <div class="form-floating mb-2">
                            <input id="label-surname" type="text" class="form-control" placeholder="Фамилия"
                                   name="surname" value="${employee.surname}">
                            <label for="label-surname">Фамилия</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-name" type="text" class="form-control" placeholder="Имя"
                                   name="name" value="${employee.name}">
                            <label for="label-name">Имя</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-patronymic" type="text" class="form-control" placeholder="Отчество"
                                   name="patronymic" value="${employee.patronymic}">
                            <label for="label-patronymic">Отчество</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input id="label-birthday" type="date" class="form-control" placeholder="Дата рождения"
                                   name="birthday" value="${employee.birthday}">
                            <label for="label-birthday">Дата рождения</label>
                        </div>
                        <div class="form-floating mb-2">
                            <select id="label-rankTitle" type="text" class="form-select" name="rankTitle">
                                <option selected value="${employee.rank.title}">${employee.rank.title} внутренней службы</option>
                                <option value="генерал-лейтенант">генерал-лейтенант внутренней службы</option>
                                <option value="генерал-майор">генерал-майор внутренней службы</option>
                                <option value="полковник">полковник внутренней службы</option>
                                <option value="подполковник">подполковник внутренней службы</option>
                                <option value="майор">майор внутренней службы</option>
                                <option value="капитан">капитан внутренней службы</option>
                                <option value="старший лейтенант">старший лейтенант внутренней службы</option>
                                <option value="младший лейтенант">младший лейтенант внутренней службы</option>
                                <option value="старший прапорщик">старший  внутренней службы</option>
                                <option value="прапорщик">прапорщик внутренней службы</option>
                                <option value="старшина">старшина внутренней службы</option>
                                <option value="старший сержант">старший сержант внутренней службы</option>
                                <option value="сержант">сержант внутренней службы</option>
                                <option value="младший сержант">младший сержант внутренней службы</option>
                                <option value="рядовой">рядовой внутренней службы</option>
                            </select>
                            <label for="label-rankTitle">Специальное звание</label>
                        </div>
                        <div class="form-floating mb-2">
                            <select id="label-positionTitle" type="text" class="form-select" name="positionTitle">
                                <option selected value="${employee.position.positionTitle}">${employee.position.positionTitle}</option>
                                <option>начальник отдела</option>
                                <option>первый зам. начальника отдела</option>
                                <option>зам. начальника отдела</option>
                                <option>начальник центра</option>
                                <option>ст. помощник начальника центра</option>
                                <option>начальник сектора</option>
                                <option>начальник службы</option>
                                <option>начальник отряда</option>
                                <option>зам. начальника отряда</option>
                                <option>начальник части</option>
                                <option>зам. начальника части</option>
                                <option>начальник дежурной смены</option>
                                <option>начальник караула</option>
                                <option>главный специалист</option>
                                <option>старший инженер</option>
                                <option>старший инспектор</option>
                                <option>инспектор по ППиС</option>
                                <option>инспектор</option>
                                <option>начальник поста</option>
                                <option>старшина</option>
                                <option>старший водитель</option>
                                <option>командир отделения</option>
                                <option>диспетчер</option>
                                <option>старший пожарный</option>
                                <option>пожарный</option>
                                <option>водитель</option>
                            </select>
                            <label for="label-positionTitle">Занимаемая должность</label>
                        </div>
                        <div class="form-floating mb-2">
                            <select id="label-subdivisionTitle" type="text" class="form-select" name="subdivisionTitle">
                                <option selected value="${employee.subdivision.subdivisionTitle}">${employee.subdivision.subdivisionTitle}</option>
                                <option>руководство</option>
                                <option>ЦОУ</option>
                                <option>ИНиП</option>
                                <option>ГСЧСиГО</option>
                                <option>СИРиКО</option>
                                <option>СМТОиО</option>
                                <option>ПАСЧ-1</option>
                                <option>ПАСО-2</option>
                                <option>ПАСЧ-3</option>
                                <option>ПАСП-11</option>
                                <option>ПАСП-12</option>
                                <option>ПАСП-13</option>
                                <option>ПАСП-14</option>
                            </select>
                            <label for="label-subdivisionTitle">Подразделение</label>
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