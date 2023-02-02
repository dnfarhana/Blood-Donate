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
        <title>Book Appointment</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <script>
            function validate(){
                var email = document.bookapt.donor_email.value;
                var no = document.bookapt.donor_number.value;
                var date = document.bookapt.appointment_date.value;
                var camp = document.bookapt.camp_name.value;
                
                if(email==null || email==""){
                    alert("Please enter your email!");
                    return false;
                }else if(no==null || no==""){
                    alert("Please enter your phone number!");
                    return false;
                }else if(date==null || date==""){
                    alert("Please choose your appointment date!");
                    return false;
                }else if(camp==null || camp==""){
                    alert("Please choose your appointment location!");
                    return false;
                }
            }            
        </script>
    </head>
    <body>
        <!--fetch session attribute-->
        <%     HttpSession sess = request.getSession(false); //use false to use the existing session
                String ic = (String)sess.getAttribute("donor_ic");
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

        <script src="app.js"></script>
        <div class="wrapper">
            <h1><b>Donor Appointment</b></h1>
            <br><br>
            <form method="POST" action="/bloodDonate/donorappointment">
                <table>
                    <c:forEach var="row" items="${donor.rows}">
                    <tr>
                        <td>Name </td>
                        <td>: <input type="text" name="donor_name" id="donor_name" value="<c:out value="${row.donor_name}"/>" style="color: grey" readonly></td>
                    </tr>
                    <tr>
                        <td>MyKad No </td>
                        <td>: <input type="text" name="donor_ic" id="donor_ic" value="<c:out value="${row.donor_ic}"/>" style="color: grey" readonly></td>
                    </tr>
                    <tr>
                        <td>Email </td>
                        <td>: <input type="text" name="donor_email" id="donor_email" value="<c:out value="${row.donor_email}"/>"></td>
                    </tr>
                    <tr>
                        <td>Phone No</td>
                        <td>: <input type="text" name="donor_number" id="donor_number" value="<c:out value="${row.donor_number}"/>"></td>
                    </tr>
                    <tr>
                        <td>Appointment Date </td>
                        <td>: <input type="date" name="appointment_date" id="appointment_date"></td>
                    </tr>
                    <tr>
                        <td>Location </td>
                        <td>: <select id="camp_name" name="camp_name">
                            <option value="Hospital Segamat">Hospital Segamat</option>
                            <option value="Pusat Darah Negara">Pusat Darah Negara</option>
                            <option value="Hospital Kuala Lumpur">Hospital Kuala Lumpur</option>
                            <option value="Hospital Shah Alam">Hospital Shah Alam</option>
                            <option value="Hospital Tungku Ampuan Rahimah">Hospital Tungku Ampuan Rahimah</option>
                            <option value="Institut Kanser Negara">Institut Kanser Negara</option>
                            <option value="Hospital Putrajaya">Hospital Putrajaya</option>
                        </select></td>
                    <tr><td><br><input type="submit" value="Submit" class="w3-button w3-brown w3-round"></td></tr>
                     </c:forEach>
                </table>
            </form>
            <!--set session attribute-->
            <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("donor_ic", ic);%>
        </div>
    </body>
    <footer>
        ©2021 BLOODPLUS+ ASSOCIATION
    </footer>
</html>