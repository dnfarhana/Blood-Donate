<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<sql:setDataSource var="myDatasource" 
driver="org.apache.derby.jdbc.ClientDriver" 
url="jdbc:derby://localhost:1527/BloodDonor" user="app" 
password="app"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Camp Record List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/staffStyle.css">
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <!--fetch session attribute-->
         <% HttpSession sess = request.getSession(false); //use false to use the existing session
            String id = (String)sess.getAttribute("staff_id");
//            out.println(id);
        %>
        <nav>
            <div class="logo">
                <h4>BloodPlus+</h4>
            </div>
            <ul class="nav-links">
                <li><a href="dashboard.jsp">Home</a></li>
                <li><a href="donorRecord.jsp">Donor Record</a></li>
                <li><a href="aptPending.jsp">Pending Appointment</a></li>
                <li><a href="appRecord.jsp">Appointment Record</a></li>
                <li><a href="event.jsp">Event Form</a></li>
                <li><a href="campRecord.jsp">Camp Record</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
            <div class="burger">
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
        <div class="table">
        <h1><b>CAMP RECORD LIST</b></h1>
        <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM APP.CAMP  
        </sql:query>
        <table id="status">
            <tr>
                <th>CAMP</th>
                <th>BLOOD A UNIT</th>
                <th>BLOOD B UNIT</th>
                <th>BLOOD AB UNIT</th>
                <th>BLOOD O UNIT</th>
            </tr>
            <c:forEach var="column" items="${result.rows}">
            <tr>
                <td><c:out value="${column.camp_name}"/></td>
                <td><c:out value="${column.total_a}"/></td>
                <td><c:out value="${column.total_b}"/></td>
                <td><c:out value="${column.total_ab}"/></td>
                <td><c:out value="${column.total_o}"/></td>
            </tr>
            </c:forEach>
        </table>
        </div>
    <!--set session attribute-->
             <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("staff_id", id);%>
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>