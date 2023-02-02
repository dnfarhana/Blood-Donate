<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/staffStyle.css">
    <script>
        function validate(){
            var name = document.staffRegistration.staff_name.value;
            var id = document.staffRegistration.staff_id.value;
            var email = document.staffRegistration.staff_email.value;
            var no = document.staffRegistration.staff_number.value;
            var adr = document.staffRegistration.staff_address.value;
            var pass = document.staffRegistration.staff_password.value;
            var confirm = document.staffRegistration.confirm.value;
            
            if(name==null || name==""){
                alert("Please enter your name");
                return false;
            }else if(id==null || id==""){
                alert("Please enter your IC");
                return false;
            }else if(email==null || email==""){
                alert("Please enter your email");
                return false;
            }else if(no==null || no==""){
                alert("Please enter your number");
                return false;
            }else if(adr==null || adr==""){
                alert("Please enter your address");
                return false;
            }else if(pass==null || pass==""){
                alert("Please enter your password");
                return false;
            }else if(confirm==null || confirm==""){
                alert("Please enter confirmation password");
                return false;
            }
        }
    </script>
</head>
<body> 
    <nav>
        <div class="logo">
            <h4>BloodPlus+</h4>
        </div>
        <ul class="nav-links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="location.html">Location</a></li>
            <li><a href="index.jsp">Login</a></li>
        </ul>
    </nav>
    <div class="wrapper">
        <h1><b>Staff Registration Form</b></h1>
        <br>
        <form method="POST" action="/bloodDonate/staffregister" name="staffRegistration" id="staffRegistration" onsubmit="return validate()">
            <table>
                <tr>
                    <td><label for="staff_name">Name</label></td>
                    <td>: <input type="text" name="staff_name" id="staff_name"></td>
                </tr>
                <tr>
                    <td><label for="staff_id">IC</label></td>
                    <td>: <input type="text" id="staff_id" name="staff_id"></td>
                </tr>
                <tr>
                    <td><label for="staff_email">Email</label></td>
                    <td>: <input type="text" name="staff_email" id="staff_email"></td>
                </tr>
                <tr>
                    <td><label for="staff_number">Phone No</label></td>
                    <td>: <input type="text" name="staff_number" id="staff_number"></td>
                </tr>
                <tr>    
                    <td><label for="staff_address">Address</label></td>
                    <td>: <input type="text" name="staff_address" id="staff_address"></td>
                </tr>
                <tr>
                    <td><label for="staff_password">Password</label></td>
                    <td>: <input type="password" name="staff_password" id="staff_password"></td>
                </tr>
                <tr>
                    <td><label for="confirm">Confirm Password</label></td>
                    <td>: <input type="password" name="confirm" id="confirm"></td>
                </tr>
                <tr><td><br><input type="submit" value="Submit" class="w3-button w3-brown w3-round"></td></tr>
            </table>
        </form>
    </div>
    <footer>
        ©2021 BLOODPLUS+ ASSOCIATION
    </footer>
</body>
</html>