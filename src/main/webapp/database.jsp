<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
   <head>
      <title>SELECT Operation</title>
   </head>

   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb"
         user = "ee417"  password = "ee417"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
SELECT firstname, lastname, email, password FROM testdb.Ulysse_database1      </sql:query>
 
 	<h1>Users</h1>
 	<h1> </h1>
      <table border = "1" width = "100%">
         <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Password</th>
         </tr>
        <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.firstname}"/>
               </td><td><c:out value = "${row.lastname}"/></td>
               <td><c:out value = "${row.email}"/></td>
               <td><c:out value = "${row.password}"/></td>
            </tr>
         </c:forEach>
      </table>
      
      <h1>Messages</h1>
 	<h1> </h1>
      
      <sql:query dataSource = "${snapshot}" var = "result">
SELECT name, email, object, message  FROM testdb.Ulysse_database2        </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Object</th>
            <th>Message</th>
         </tr>
        <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.name}"/></td>
               <td><c:out value = "${row.email}"/></td>
               <td><c:out value = "${row.object}"/></td>
               <td><c:out value = "${row.message}"/></td>
            </tr>
         </c:forEach>
      </table>
      
      
 
   </body>
</html>