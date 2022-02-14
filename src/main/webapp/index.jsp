<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rescue HR</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #332464">
        <div class="container-xxl">
            <a class="navbar-brand" href="#">
                <img src="./static/img/buttonhole.png" width="70" height="70" alt=""> Rescue HR
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="#">Сотрудники</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Штат</a>
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
                        <a class="nav-link dropdown-toggle" href="#" id="journals"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">Журналы
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Перемещения по службе</a></li>
                            <li><a class="dropdown-item" href="#">Присвоение званий</a></li>
                            <li><a class="dropdown-item" href="#">Командировки</a></li>
                            <li><a class="dropdown-item" href="#">Больничные</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Вход</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Введите данные" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Поиск</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<!--<section>
    <div class="container-xxl">
        <h1>Welcome to Rescue HR</h1>
    </div>
</section>-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
