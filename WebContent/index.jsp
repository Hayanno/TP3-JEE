<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Title</title>
</head>
<body>
  <p>Hello.</p>
  <jsp:useBean id="date" scope="request" class="java.util.Date">
    <p>Date : <%= date.toString()  %> !</p>
  </jsp:useBean>
</body>
</html>