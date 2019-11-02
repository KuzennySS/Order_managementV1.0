<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<section>
    <jsp:useBean id="orderForm" type="ru.kuzenny.testwork.dto.OrderDto" scope="request"/>
<%--    <h3><spring:message code="${orderForm.orderId.isNew() ? 'orderForm.add' : 'orderForm.create'}"/></h3>--%>
    <hr>
    <form method="post" action="orderForm">
        <input type="hidden" name="oldNumberOrder" value="${orderForm.numberOrder}">
        <dl>
            <dt>Номер заказа:</dt>
            <dd><input type="number" value="${OrderForm.numberOrder}" name="newNumberOrder" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${OrderForm.email}" size=40 name="email" required></dd>
        </dl>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()" type="button">Отменить</button>
    </form>
</section>
</body>
</html>
