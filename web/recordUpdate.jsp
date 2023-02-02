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
        <title>Update Password</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/staffStyle.css">
        <script>
        function validate(){
            var name = document.update.newname.value;
            var email= document.update.newEmail.value;
            var bt = document.update.newBlood.value;
            var no = document.update.newPhone.value;
            var adr = document.update.newAddress.value;
                
            if(name== null || name==""){
                alert("Please enter your name!");
                return false;
            }else if(email==null || email==""){
                alert("Please enter your email!")
                return false;
            }else if(bt==null || bt==""){
                alert("Please choose your bloodtype!");
                return false;
            }else if(no==null || no==""){
                alert("Please enter your phone number!");
                return false;
            }else if(adr==null || adr==""){
                alert("Please enter your address!");
                return false;
            }
        }
        </script>
    </head>
    <body>
        <c:set var="donor_ic" value="${param.id}"/>
        <sql:query var="donor" dataSource="${myDatasource}">
            select* from donor where donor_ic = ?
            <sql:param value="${donor_ic}"/> 
        </sql:query> 
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
        <div class="wrapper" style="height: 500px;">
            <h1><b>Update Information</b></h1>
            <br>
            <form action="/bloodDonate/donorUpdate" method="POST" name="update" id="update" onsubmit=" return validate()">
                <table>
                    <c:forEach var="row" items="${donor.rows}">
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="newname" id="newname" value="<c:out value="${row.donor_name}"/>"></td>
                    </tr>
                    <tr>
                        <td>MyKad No: </td>
                        <td><input type="text" name="newIC" id="newIC" value="<c:out value="${row.donor_ic}"/>" style="color:grey" readonly></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="newEmail" id="newEmail" value="<c:out value="${row.donor_email}"/>"></td>
                    </tr>
                    <tr>
                        <td>Phone No</td>
                        <td><input type="text" name="newPhone" id="newPhone" value="<c:out value="${row.donor_number}"/>"></td>
                    </tr>
                    <tr>
                        <td>Blood Type: </td>
                        <td><input type="text" name="newBlood" id="newBlood" value="<c:out value="${row.donor_bloodtype}"/>"></td>
                    </tr>
                    <tr>
                        <td>Address: </td>
                        <td><input type="text" name="newAddress" id="newAddress" value="<c:out value="${row.donor_address}"/>"></td>
                    </tr>
                    <tr><td><br><input type="submit" value="Update" class="w3-button w3-brown w3-round"></td></tr>
                    </c:forEach>
                </table>
            </form>
        </div>
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>
