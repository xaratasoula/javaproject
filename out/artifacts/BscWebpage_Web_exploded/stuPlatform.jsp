<%--
  Created by IntelliJ IDEA.
  User: ageli
  Date: 11-Sep-20
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UniPi-CS: Bcs Thesis Status</title>
<body>

<style>
    body { font-family: Calibri;}
    table,th,td { border: 0px; padding: 0px;}
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
    button:hover {
        opacity: 0.8;
    }
</style>
<img src="${pageContext.request.contextPath}/unipi.jpg"  style="width: 430px; height: 150px;"><br><br>
</head>
<jsp:include page="/StudentUtil" />
<script>
    function upload() {
        document.getElementById("file").hidden = false;
        document.getElementById("upl").hidden = false;
        document.getElementById("parameterAM").hidden = true;
        document.getElementById("parameterAM").value = document.getElementById("am").innerHTML;
    }
    function click(){
        document.getElementById("id").value = document.getElementById("id").innerHTML;
    }
</script>
<table>
    <tr>
        <td><input type="submit" class="button" value="Upload my Work" onclick="upload()"></td>
        <form method="POST" action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data">
        <td>  <input type='file' id = 'file' class = 'button' accept=".zip" name="file" onclick="click()" hidden/> </td>
        <td>  <input type="submit" id = 'upl' class = 'button' value="Submit" hidden/></td>
        <td> <input type='hidden' name = "id" id = "id" /> </td>
        </form>
        </tr>

    <tr>
        <td>
            <form action="index.jsp">
                <input type='submit' class = 'button' value='Logout'>
            </form>
    </tr>
</table>
</body>
</html>