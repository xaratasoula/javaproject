<%--
  Created by IntelliJ IDEA.
  User: ageli
  Date: 10-Sep-20
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UniPi-CS: Bcs Thesis Status</title>
<body>

<style>
    body { font-family: Calibri;}
    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    /* Set a style for all buttons */
    button {
        background-color: #05125c;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer
    }
    button:hover {
        opacity: 0.8;
    }
</style>
<img src="${pageContext.request.contextPath}/unipi.jpg"  style="width: 430px; height: 150px;">
</head>

<jsp:include page="/SupReport" />
<br>
<form action="index.jsp">
    <button type='submit' value='Logout'>Logout</button>
</form>
</body>
</html>