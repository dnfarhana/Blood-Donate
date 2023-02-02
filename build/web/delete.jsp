<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<sql:setDataSource var="myDatasource" 
driver="org.apache.derby.jdbc.ClientDriver" 
url="jdbc:derby://localhost:1527/BloodDonor" user="app" 
password="app"/>

<html>
    <head>
        <title>Delete Donor Record</title>
    </head>
    <body>
        <c:set var="donor_ic" value="${param.id}"/>
        <%--<c:out value="${donor_ic}"/>--%>
        <sql:update var="donor" dataSource="${myDatasource}">
            delete from donor where donor_ic = ?
            <sql:param value="${donor_ic}"/> 
        </sql:update> 
        <script>    
            success();
            function success(){
                alert("Successfully delete record!");
                window.location.href = "donorRecord.jsp";
            }
        </script>
    </body>
</html>
 
