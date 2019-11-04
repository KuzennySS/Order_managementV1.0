<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Список заказов</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<section>
    <h2>Список заказов</h2>
    <hr/>
    <a href="${pageContext.request.contextPath}/look/create">Создать заказ</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Номер заказа</th>
            <th>Email заказчика</th>
            <th>Время заказа</th>
            <th>Сумма заказа</th>
            <th>Просмотр заказа</th>
            <th>Удалить заказ</th>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="orderDto">
            <jsp:useBean id="orderDto" type="ru.kuzenny.testwork.dto.OrderDto"/>
            <tr>
                <td>${orderDto.numberOrder}</td>
                <td>${orderDto.email}</td>
                <td>${orderDto.time}</td>
                <td>${orderDto.sum}</td>
                <td><a href="look/${orderDto.numberOrder}">Смотреть заказ</a></td>
                <td><a href="delete/${orderDto.numberOrder}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="downloadXml/${orderDto}"> Загрузить xml файл </a></td>
</section>
</body>
</html>