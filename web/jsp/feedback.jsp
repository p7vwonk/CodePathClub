<%--
  Created by IntelliJ IDEA.
  User: fallw
  Date: 10/14/2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Feedback</title>
</head>
<body>
<%@include file="header.jsp"%>

<form class="form-group" action="/club/FeedbackServlet" method="post">
  <label for="feedback">
    <span class="glyphicon glyphicon-user"></span>
    意见反馈 <label style="color:red;">*</label>
  </label>
  <textarea class="form-control" id="feedback" name="feedback"
            type="text" rows="5" placeholder="不超过80字" required></textarea>
  <input class="btn btn-primary" type="submit" value="提交">
  <a href="/club/ShowFeedback" class="btn btn-primary">查看</a>
</form>

<%@include file="footer.jsp"%>
</body>
</html>
