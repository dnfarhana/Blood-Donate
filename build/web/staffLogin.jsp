<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <!-- <link rel="preconnect" href="https://fonts.gstatic.com"> -->
        <link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/loginStaff.css">
        <script>
            function validate(){
                var id = document.stafflogin.staff_id.value;
                var pass = document.stafflogin.staff_password.value;
                
                if(id==null || id==""){
                    alert("Please enter your Id!");
                    return false;
                }else if(pass==null || pass==""){
                    alert("Please enter your password!");
                    return false;
                }
            }
        </script>
    </head>
    <body><nav>
        <div class="logo">
            <h4>BloodPlus+</h4>
        </div>
        <ul class="nav-links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="location.html">Location</a></li>
            <li><a href="index.jsp">Login</a></li>
        </ul>
    </nav>
    <div class="login">
        <center><img src="img/logo.png"></center>
        <h3>SAVE LIVES DONATE BLOOD</h3>
        <form method="POST" action="/bloodDonate/stafflogin" name="stafflogin" id="stafflogin" onsubmit="return validate()">
            <input type="text" placeholder="Staff ID" name="staff_id" >
            <input type="password" placeholder="Password" name="staff_password" >
            <span style="color: red">
                    <%=(request.getAttribute("errMessage")== null)?"": request.getAttribute("errMessage")%>
            </span>
            <input type="submit" value="LOGIN">
        </form>
	<div class="bottom-text">
            Don't Have Account? <a href="staffRegistration.jsp">Sign Up</a><br>
	</div>
    </div>
    <footer>
        ©2021 BLOODPLUS+ ASSOCIATION
    </footer>
    </body>
</html>