<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="users?action=users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Edit User</h2>
      </caption>
      <c:if test="${requestScope.user != null}">
        <input type="hidden" name="id" value="<c:out value='${requestScope.user.getId()}' />"/>
      </c:if>
      <tr>
        <th>User Name:</th>
        <td>
          <label>
            <input type="text" name="name" size="45"
                   value="<c:out value='${requestScope.user.getName()}' />"
            />
          </label>
        </td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>
          <label>
            <input type="text" name="email" size="45"
                   value="<c:out value='${requestScope.user.getEmail()}' />"
            />
          </label>
        </td>
      </tr>
      <tr>
        <th>Country:</th>
        <td>
          <label>
            <input type="text" name="idCountry" size="15"
                   value="<c:out value='${requestScope.user.getIdCountry()}' />"
            />
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>