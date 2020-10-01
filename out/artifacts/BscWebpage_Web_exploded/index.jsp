<%--
  Created by IntelliJ IDEA.
  User: ageli
  Date: 07-Sep-20
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>UniPi-CS: Bcs Thesis Status</title>
</head>
<body>
<style>
    body { font-family: Calibri; font-size: 18;}

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
    .button {
        background-color: #05125c;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer
    }

    .button:hover {
        opacity: 0.8;
    }

</style>
<h1>Welcome to the Bachelor Thesis Status Platform of the University of Pireaus!</h1>
<img src="${pageContext.request.contextPath}/unipi.jpg"  style="width: 430px; height: 150px;">
<form method ="post" action="${pageContext.request.contextPath}/Login">
    <table>

        <td>User's ID </td>
        <td></td>
        <td><input type = "text" name = "id"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td></td>
            <td><input type ="password" name = "password"></td>
        </tr>
        <tr>
            <td></td><td></td>
            <td><input type = "submit" value ="Login" class = "button" style = "font-family: Calibri; font-size: 14;">
            </td>
        </tr>
    </table>
</form>
</body>
</html>