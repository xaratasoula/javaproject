<%--
  Created by IntelliJ IDEA.
  User: ageli
  Date: 12-Sep-20
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UniPi-CS: Bcs Thesis Status: Student's Details</title>
<body>
<style>
    body { font-family: Calibri; font-size: 18;}
    table, th, td { border: 1px solid black; border-collapse: collapse; padding: 15px; text-align: left;}
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
<img src="${pageContext.request.contextPath}/unipi.jpg"  style="width: 430px; height: 150px;"><br>
</head>
<jsp:include page="/StudentDets" />
<input type = 'submit' name ='btn1' class= 'button' value = 'Show detailed progress' ><br>
<input type = 'submit' name ='btn2' class= 'button' value = 'Arrange meeting' ><br>
<input type = 'submit' name ='btn3' class= 'button' value = 'Submit final grade' ><br>
<form action="index.jsp">
    <input type='submit' class = 'button' value='Logout'>
</form>

</body>
</html>
