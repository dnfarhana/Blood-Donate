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
        <title>Pending Appointment</title>
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
        <nav>
            <div class="logo">
                <h4>BloodPlus+</h4>
            </div>
            <ul class="nav-links">
                <li><a href="staffHomePage.html">Home</a></li>
                <li><a href="donorRecord.html">Donor Record</a></li>
                <li><a href="appPending.html">Pending Appointment</a></li>
                <li><a href="appRecord.html">Appointment Record</a></li>
                <li><a href="campForm.html">Camp Form</a></li>
                <li><a href="campRecord.html">Camp Record</a></li>
                <li><a href="welcomePage.html">Logout</a></li>

            </ul>
            <div class="burger">
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
        <div class="table">
        <h1><b>PENDING APPOINTMENT LIST</b></h1>
        <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM APP.APPOINTMENT
        </sql:query>
        <table id="status">
            <tr>
                <th>NAME</th>
                <th>IC</th>
                <th>EMAIL</th>
                <th>PHONE NO</th>
                <th>APPOINTMENT DATE</th>
                <th>LOCATION</th>
                <th>ACTION</th>
            </tr>
            
            <c:forEach var="column" items="${result.rows}">
            <tr>
                <td><c:out value="${column.donor_name}"/></td>
                <td><c:out value="${column.donor_ic}"/></td>
                <td><c:out value="${column.donor_email}"/></td>
                <td><c:out value="${column.donor_number}"/></td>
                <td><c:out value="${column.appointment_date}"/></td>
                <td><c:out value="${column.camp_name}"/></td>
                <td><button class="button button1" onclick="document.location='donorUpdate.jsp'" value="<c:set var="" value="${row.donor_address}"/>">Accept
                    </button><button class="button button2" onclick="document.location='donorUpdate.jsp'">Reject</button></td>
            </tr>
            </c:forEach>
        </table>
        </div>
    
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>