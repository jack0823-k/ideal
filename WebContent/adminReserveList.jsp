<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Reserve,
		model.Admin,
		java.util.ArrayList,
		java.time.LocalDate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>予約情報一覧</title>
	<!-- 要CSS -->
	<%@ include file="incFile.jsp"%>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="reserveList" class="java.util.ArrayList" scope="request" type="ArrayList<Reserve>"/>
	<%
		//管理者情報を取得
		Admin ad = (Admin)session.getAttribute("adminInfo");
	%>
	<h2 align="center"><%= ad.getAdmName() %>様&ensp;予約情報一覧</h2>
	<h3 align="center"><%= fmtNull((String)request.getAttribute("msg")) %></h3>
	<div align="center">
		<form action="AdminReserveListSvl" method="post" onsubmit="return checkData(this);">
			<select name="selectedDateStr">
				<%
					//現在の年月日情報を取得
					LocalDate currentDate = LocalDate.now();
					//選択された年月日情報を取得
					LocalDate selectedDate;
					if(request.getParameter("selectedDateStr") != null){
						selectedDate = LocalDate.parse(request.getParameter("selectedDateStr"));
					}else{
						//初回アクセス時は現在の年月日をセット
						selectedDate = currentDate;
					}
					//その他の年月日情報を生成
					LocalDate firstDate = selectedDate.minusYears(1);  //選択されている日－１年
					LocalDate lastDate  = currentDate.plusYears(1);    //現在＋１年
					//firstDateからlastDateまで繰り返し
					for(LocalDate d = firstDate; d.isBefore(lastDate); d = d.plusDays(1)){
						String selected = "";
						if(d.isEqual(selectedDate)){
							selected = "selected";
						}
				%>
						<option value="<%= d.toString() %>" <%= selected %>>
							<%= d.toString().replace("-", " / ") %>
						</option>
				<%
					}
				%>
			</select>
			<input type="submit" value="表示"/>
		</form>
	</div>
	<br/>
	<table border align="center">
		<tr>
			<th>No</th>
			<th>お名前</th>
			<th>ご予約日時</th>
			<th>人数</th>
			<th>コース名</th>
			<th>テーブル名</th>
			<th>登録日時</th>
		</tr>
		<%
			for(Reserve r : reserveList){
		%>
				<tr>
					<td><%= r.getRsvId() %></td>
					<td><%= r.getUsrName() %></td>
					<td>
						<%= r.getRsvYy() %>年<%= r.getRsvMm() %>月<%= r.getRsvDd() %>日&ensp;
						<%= r.getRsvHh() %>時<%= r.getRsvMi() %>分
					</td>
					<td><%= r.getPerson() %></td>
					<td><%= r.getCourseName() %></td>
					<td><%= fmtNull(r.getTableName()) %></td>
					<td>
						<%= r.getAppYy() %>年<%= r.getAppMm() %>月<%= r.getAppDd() %>日&ensp;
						<%= r.getAppHh() %>時<%= r.getAppMi() %>分
					</td>
				</tr>
		<%
			}
		%>
	</table>
	<br/>
	<div align="center"><a href="adminIndex.jsp">管理者メニューへ戻る</a></div>
</body>
</html>