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
        <title>Appointment Status</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <%     HttpSession sess = request.getSession(false); //use false to use the existing session
                String ic = (String)sess.getAttribute("donor_ic");
//                out.println(ic);
        %>
        <c:set var="donor_ic" value="${donor_ic}"/>
        <nav>
            <div class="logo">
                <h4>BloodPlus+</h4>
            </div>
            <ul class="nav-links">
                <li><a href="donorProfile.jsp">Profile</a></li>
                <li><a href="donorAppointment.jsp">Book Appointment</a></li>
                <li><a href="aptStatus.jsp">Status</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <div class="burger">
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
        
        <div class="wrapper">
        <h1><b>Appointment status</b></h1>
        <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM APP.APPOINTMENT where donor_ic = ?
            <sql:param value="${donor_ic}"/>  
        </sql:query>
        <table id="status">
            <tr>
                <th>Date</th>
                <th>Location</th>
                <th>Status</th>
            </tr>
            
            <c:forEach var="column" items="${result.rows}">
            <tr>
                <td><c:out value="${column.appointment_date}"/></td>
                <td><c:out value="${column.camp_name}"/></td>
                <td><c:out value="${column.appointment_status}"/></td>
            </tr>
            </c:forEach>
        </table>
        </div>
        <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("donor_ic", ic);%>
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>