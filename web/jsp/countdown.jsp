<%--
  Created by IntelliJ IDEA.
  User: Dagasi
  Date: 2024/10/15
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>蓝桥杯倒计时</title>
  <style>
    body {
      position: relative; /* 为了将子元素定位 */
      font-family: Arial, sans-serif;
      background-color: #f4f4f4; /* 背景颜色 */
      margin: 0; /* 去除默认边距 */
      height: 100vh; /* 视口高度 */
    }
    .countdown {
      position: absolute; /* 绝对定位 */
      top: 620px; /* 距离顶部 20 像素 */
      right: 20px; /* 距离右边 20 像素 */
      background: white; /* 背景颜色 */
      padding: 20px; /* 内边距 */
      border-radius: 10px; /* 圆角 */
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 阴影 */
      text-align: center; /* 内容居中 */
    }
  </style>
</head>
<body>
<div class="countdown">
  <h1>蓝桥杯倒计时</h1>
  <%
    // 获取当前日期
    Calendar today = Calendar.getInstance();
    // 设置蓝桥杯开始日期
    Calendar competitionDate = new GregorianCalendar(2025, Calendar.APRIL, 25);
    // 计算天数差
    long diff = competitionDate.getTimeInMillis() - today.getTimeInMillis();
    long daysLeft = diff / (1000 * 60 * 60 * 24);
  %>
  <p>距离蓝桥杯开始还有 <strong><%= daysLeft %></strong> 天</p>
</div>
</body>
</html>
