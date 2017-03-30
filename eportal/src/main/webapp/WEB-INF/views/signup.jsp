<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form commandName="cust " action="addCustomer" autocomplete="on">
<div class="form-group">
    <label for="name">name:</label>
    <f:input path="cname" type="text" class="form-control" id="name"/>
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <f:input path="email" type="email" class="form-control" id="email"/>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <f:input path="password" type="password" class="form-control" id="pwd"/>
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>