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
        <title>Event</title>
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
                var camp_name = document.event.camp_name.value;
                var event_date = document.event.event_date.value;
                var a = document.event.no_a.value;
                var b = document.event.no_b.value;
                var ab = document.event.no_ab.value;
                var o = document.event.no_o.value;
                var exp = document.event.expired.value;
                if(camp_name==null || camp_name==""){
                    alert("Please select location!");
                    return false;
                }else if(event_date==null || event_date==""){
                    alert("Please choose event date!");
                    return false;
                }else if(a==null || a==""){
                    alert("Please enter no of blood A donated!");
                    return false;
                }else if(b==null || b==""){
                    alert("Please enter no of blood B donated!");
                    return false;
                }else if(ab==null || ab==""){
                    alert("Please enter no of blood AB donated!");
                    return false;
                }else if(o==null || o==""){
                    alert("Please enter no of blood O donated!");
                    return false;
                }else if(exp==null || exp==""){
                    alert("Please choose expired date!");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <!--fetch session attribute-->
         <% HttpSession sess = request.getSession(false); //use false to use the existing session
            String id = (String)sess.getAttribute("staff_id");
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
        <div class="wrapper">
            <h1><b>EVENT</b></h1>
            <form method="POST" action="/bloodDonate/newevent" name="event" id="event" onsubmit=" return validate()">
                <table>
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
                    </tr>
                    <tr>
                        <td><label for="event_date">Event Date </label></td>
                        <td>: <input type="date" name="event_date" id="event_date"></td>
                    </tr>                
                    <tr>
                        <td><label for="no_a">No of Unit Blood A Donated</label></td>
                        <td>: <input type="text" name="no_a" id="no_a"></td>
                    </tr>
                    <tr>
                        <td><label for="no_b">No of Unit Blood B Donated</label></td>
                        <td>: <input type="text" name="no_b" id="no_b"></td>
                    </tr>
                    <tr>
                        <td><label for="no_ab">No of Unit Blood AB Donated</label></td>
                        <td>: <input type="text" name="no_ab" id="no_ab"></td>
                    </tr>
                    <tr>
                        <td><label for="no_o">No of Unit Blood O Donated</label></td>
                        <td>: <input type="text" name="no_o" id="no_o"></td>
                    </tr>
                    <tr>
                        <td><label for="expired">Blood Expired Date</label></td>
                        <td>: <input type="date" name="expired" id="expired"></td>
                    </tr>
                    <tr>
                        <td><label for="staff_id">Staff ID</label></td>
                        <td>: <input type="text" name="staff_id" id="staff_id" value="<%=id%>" style="color: grey" readonly></td>
                    </tr>
                    <tr><td><input type="submit" value="Submit" class="w3-button w3-brown w3-round"></td></tr>
                </table>
            </form>
        </div>
         <!--set session attribute-->
             <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("staff_id", id);%>
        <footer>
            ©2021 BLOODPLUS+ ASSOCIATION
        </footer>
    </body>
</html>