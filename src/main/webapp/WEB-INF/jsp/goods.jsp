<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Товары</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<section>
    <h2>Прайс лист товаров:</h2>
    <hr/>
    <form method="post" action="add">
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>Название товара</th>
                <th>Цена товара</th>
                <th>Выберите одну из позиций</th>
            </tr>
            <thead>
            <c:forEach items="${goods}" var="good">
                <tr>
                    <td>${good.name}</td>
                    <td>${good.priceGoods}</td>
                    <td><input type="checkbox" name="id" value="${good.id}"/></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        Выберите количество: <input name="numberItem" type="number" min=1 />
        <br><br>
        <br>
        <input type="submit" value="Добавить выбранное"/>
        <input type="hidden" name="orderId" value="${orderId}">
        <br><br>
        <button onclick="window.history.back()" type="button">Назад</button>
    </form>
</section>
</body>
</html>
