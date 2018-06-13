<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {background-color: mistyrose}

</style>s
</head>
<body>
登録ページです。

<form action="/MySche/AddScheduleServlet" method="POST">
日付：<input type="text" name="date"><br>
タイトル：<input type="text" name="title"><br>
何日前に通知するか：<input type="text" name="day"><br>
<input type="submit" value="登録">

</form>
</body>
</html>