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
        <title>Donor Profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <!--fetch session attribute-->
        <% HttpSession sess = request.getSession(false); //use false to use the existing session
            String ic = (String)sess.getAttribute("donor_ic");
//            out.println(ic);
        %>
        <c:set var="donor_ic" value="${donor_ic}"/>
         <sql:query var="donor" dataSource="${myDatasource}">
            select* from donor where donor_ic = ?
            <sql:param value="${donor_ic}"/> 
        </sql:query>  
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
            <h1><ins><b>Donor Profile</b></ins></h1>
            <br><br>
            <table>
                <c:forEach var="row" items="${donor.rows}">
                <tr>
                    <td>Name</td>
                    <td>: <c:out value="${row.donor_name}"/></td>
                </tr>
                <tr>
                    <td>MyKad No</td>
                    <td>: <c:out value="${row.donor_ic}"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>: <c:out value="${row.donor_email}"/></td>
                </tr>
                <tr>
                    <td>Blood type</td>
                    <td>: <c:out value="${row.donor_bloodtype}"/></td>
                </tr>
                <tr>
                    <td>Phone no</td>
                    <td>: <c:out value="${row.donor_number}"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>: <c:out value="${row.donor_address}"/></td>
                </tr>
                <tr><td><br><button class="w3-button w3-brown w3-round" onclick="document.location='donorUpdate.jsp'">Update Information</button></td></tr>
                </c:forEach>
            </table>
        </div>
            <!--set session attribute-->
             <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("donor_ic", ic);%>
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>
