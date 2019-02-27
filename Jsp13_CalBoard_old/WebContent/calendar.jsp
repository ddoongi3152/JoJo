<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	#calendar{
		border-collapse:collapse;
		border:1px solid grayl;
	}
	#calendar th{
		width: 80px;
		border: 1px solid gray;
	}
	
	#calendar td{
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align:left;
		vertical-align : top;
		position: relative;
	}

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

</script>

</head>
<%
	Calendar cal=Calendar.getInstance();
	
	int year=cal.get(Calendar.YEAR);
	// 자바에서 month는 0~11까지 이므로 
	int month=cal.get(Calendar.MONTH) +1;
	
	String paramYear=request.getParameter("year");
	String paramMonth=request.getParameter("month");
	
	if(paramYear != null){
		year=Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month=Integer.parseInt(paramMonth);
	}
	if(month>12){
		month=1;
		year++;
	}
	if(month <1){
		month=12;
		year--;
	}
	
	// 현재년도, 현재월, 해당월의 1일을 찾는다.
	cal.set(year,month-1,1);
	
	// 1일의 요일 (1~7 도출)
	int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
	
	// 현재 월의 마지막 일 
	int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);

%>

<body>

	<table id="calendar">
		<caption >
			<a href="calendar.jsp?year=<%=year-1 %>&month=<%=month%>"/>◁</a>
			<a href="calendar.jsp?year=<%=year %>&month=<%=month-1%>">◀</a>
			<span><%=year %>년</span>
			<span><%=month %>월</span>
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
		</caption>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
        </tr>
		
		<tr>
		<%
		// 공백
		for(int i=0;i<dayOfWeek-1;i++){
			out.print("<td>&nbsp;</td>");
		}
		for(int i=1;i<=lastDay;i++){
		%>
		<td>
			<a href="CalController.do?command=callist&year=<%=year %>&month=<%=month %>&date=<%=i %>"><%=i %></a>
			<a href="insertCalBoard.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%> ">
				<img alt="일정추가" src="img/pen.png" style="width:10px; height:10px;">
			</a>
			<div></div>
		</td>		
<% 
        // 한줄 넘어가는 조건
        // 토요일까지 출력한 후, 새로운 줄로
		if((dayOfWeek-1+i)%7==0){
			out.print("<tr></tr>");
		}
		
	}
		
		// 마지막 주의 남은칸
		// 마지막 날의 요일 = (dayOfWeek-1+lastDay)%7
		for(int i=0;i<(7-(dayOfWeek-1+lastDay)%7)%7;i++){
			out.print("<td>&nbsp</td>");
		}
%>		
	</tr>
	</table>

</body>
</html>




































