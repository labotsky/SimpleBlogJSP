<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 19.03.14
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title></title>
</head>
<body>
<div id="container">
    <jsp:include page="/WEB-INF/include/header.jsp"/>
    <jsp:include page="/WEB-INF/include/sidebar.jsp"/>
    <div id="content">
        <h2>Опрос общественного мнения показал!!!</h2>
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
            when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
        <table class="news">
            <tr class="title">
                <td>Lorem Ipsum</td>
            </tr>
            <tr class="desc">
                <td>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                        when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
                </td>
            </tr>
            <tr class="time">
                <td>
                    <p>01.01.2014</p>
                </td>
            </tr>
        </table>
        <table class="news">
            <tr class="title">
                <td>Lorem Ipsum</td>
            </tr>
            <tr class="desc">
                <td>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                        when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
                </td>
            </tr>
            <tr class="time">
                <td>
                    <p>01.01.2014</p>
                </td>
            </tr>
        </table>
    </div>
    <jsp:include page="/WEB-INF/include/footer.jsp"/>
</div>
</body>
</html>
