<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='css/fullcalendar.css' />
<script src='js/lib/jquery.min.js'></script>
<script src='js/lib/moment.min.js'></script>
<script src='js/fullcalendar.js'></script>
<title>マイページ</title>
<style>
body {background-color: mistyrose}
#calsize {width: 1000px;
  		height: 900px;
  		background-color: white}


</style>
</head>
<style>
  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 800px;
    margin: 0 auto;
  }
</style>
<body>
<script type="text/javascript">
$(function () {
	$('#calendar').fullCalendar(
	{
		lang: "ja",
        height: 800,
        eventSources: [{
            url: '/MySche/CalemdaraServlet',
            dataType: 'json',
            data: {
                flg: 1
            },
            error: function () {
            	console.log("read err");
            	$('#read-error').show();
            }
        }]
	});
	});
</script>
<div id ="read-error" style="display:none">読み込めません</div>
<div id="calsize">
<div id="calendar"></div>
</div>
<p><a href="/MySche/AddScheduleServlet">登録ページへ</a></p>


</body>
</html>