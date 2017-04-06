<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: script972
  Date: 06.04.2017
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta content="text/html">
    <meta charset="utf-8">
    <title>Calculator</title>
  </head>
  <body>
  <form action="calculate" method="get">
    <input type="number" placeholder="5" name="a">
    <select name="operation" id="">
      <option value="add">+</option>
      <option value="minus">-</option>
      <option value="mult">*</option>
      <option value="div">/</option>
    </select>
    <input type="number" placeholder="2" name="b">
    <input type="submit" value="Підрахуй">
  </form>

  <%
    try {
      response.getWriter().print("Сессия ИД " + session.getId());
      ArrayList<String> list = (ArrayList<String>) session.getAttribute("form");
      for (String s :
              list) {
        response.getWriter().print("<p>" + s + "</p>");
      }
    } catch (Exception e){
      System.out.println(e);
    }
  %>

  </body>
</html>
