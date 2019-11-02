<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Просмотр состава заказа</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2>Состав заказа:</h2>
    <hr/>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Номер заказа</th>
            <th>Email заказчика</th>
            <th>Время заказа</th>
            <th>Сумма заказа</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tr>
            <td>${orders.numberOrder}</td>
            <td>${orders.email}</td>
            <td>${orders.time}</td>
            <td>${orders.sum}</td>
            <td><a href="update?numberOrder=${orders.numberOrder}">Редактировать</a></td>
        </tr>
    </table>

    <h2>В состав заказа входят следущие позиции:</h2>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Товар</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Стоимость</th>
            <th>Удалить позицию</th>
        </tr>
        </thead>
        <c:forEach items="${looks}" var="orderListDto">
            <jsp:useBean id="orderListDto" type="ru.kuzenny.testwork.dto.OrderListDto"/>
            <tr>
                <td>${orderListDto.nameGoods}</td>
                <td>${orderListDto.priceOrder}</td>
                <td>${orderListDto.number}</td>
                <td>${orderListDto.cost}</td>
                <td><a href="delete/${orderListDto.orderId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="add/${orders.orderId}">Добавить товар из прайс листа</a>
    <br><br>
    <a href="${pageContext.request.contextPath}/"> Назад</a>
</section>
</body>
</html>