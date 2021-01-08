<%@ page import="mainPkg.User" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>
<%@ page import="java.io.PrintWriter" %><%--
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
    body { font-family: Calibri; }
    table,th,td { border: 0px; padding: 0px;}
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

<jsp:include page="/StudentDets"></jsp:include>

<script>
    function meeting(){
        document.getElementById("meeting").hidden = false;
        document.getElementById("label").hidden = false;
        document.getElementById("ok").hidden = false;
        document.getElementById("parAM").value=document.getElementById("am").innerHTML;
    }
    function finalGrd() {
        document.createElement("changeGrade");
        document.getElementById("grade").hidden = true;
        document.getElementById("changeGrade").hidden = false;
        document.getElementById("changeBtn").hidden = true;
        document.getElementById("submitBtn").hidden = false;
        document.getElementById("parameterAM").value = document.getElementById("am").innerHTML;
    }
</script>

<table>
    <br>
    <tr>
        <td> <input type='submit' value='Arrange meeting' class= 'button' onclick="meeting()"/> </td>
        <td></td>
        <td><input type = 'submit' class= 'button' id = 'changeBtn' value = 'Change grade' onclick="finalGrd()"></td>
        <form method="post" action="${pageContext.request.contextPath}/GradeSubmission">
            <td><input type='submit' class='button' id = 'submitBtn'  value = 'Submit grade' hidden></td>
            <td><input type = 'number' min = '0' max = '10' name = 'newGrade' id = 'changeGrade' hidden></td>
            <input type='text' id="parameterAM" name =  "am" hidden/>
        </form>
    </tr>
    <div >
        <tr><td>
            <label id = "label" hidden>Meeting on date: </label>
        </td>
            <td></td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/Meetings">
                    <input type='date' id="meeting" name =  "meeting" min = "2020-10-01" hidden/>
                    <input id ="ok" class = 'button' type="submit" value="Submit" hidden/>
                    <input type='text' id="parAM" name =  "am" hidden/>

                </form>
            </td>
        </tr>
    </div>

    <td>
        <form action="index.jsp">
            <input type='submit' class = 'button' value='Logout'>
        </form>
    </td>
    </tr>
</table>

</body>
</html>