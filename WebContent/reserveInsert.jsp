<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="model.Course"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page import="model.Reserve"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ご予約</title>
<link rel="stylesheet" type="text/css" href="homeActionUserIndex.css"/>
 <link rel="stylesheet" type="text/css" href="showMenu.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>

<script type="text/javascript">
	<!--
		function checkData(obj){
			var msg = "";
			var rsvYy = parseInt(obj.rsvYy.value);
			var rsvMm = parseInt(obj.rsvMm.value) - 1;
			var rsvDd = parseInt(obj.rsvDd.value);
			var rsvHh = parseInt(obj.rsvHh.value);
			var rsvMi = parseInt(obj.rsvMi.value);
			var rsvDate = new Date(rsvYy, rsvMm, rsvDd, rsvHh, rsvMi, 0);
			var currentDate = new Date();
			if(rsvDate.getTime() < currentDate.getTime()){
				msg += "予約日時が過去の日時です。\n";
			}
			if((rsvDate.getTime() - currentDate.getTime()) / 24 / 60 / 60 / 1000 >= 365){
				msg += "一年以上先の予約は承れません。\n";
			}
			if(msg.length > 0){
				alert(msg);
				return false;
			}
			rsvMm++;
			if(((rsvYy % 4 == 0 && rsvYy % 100 != 0) || rsvYy % 400 == 0) && rsvMm == 2 && rsvDd >= 30){
				msg += "予約日が存在しない日付です。29日までの日付を選択してください。\n";
			}else if(rsvMm == 2 && rsvDd >= 29){
				msg += "予約日が存在しない日付です。28日までの日付を選択してください。\n";
			}else if((rsvMm == 4 || rsvMm == 6 || rsvMm == 9 || rsvMm == 11) && rsvDd == 31){
				msg += "予約日が存在しない日付です。30日までの日付を選択してください。\n";
			}
			if(rsvHh == 21 && rsvMi != 0){
				msg += "予約する時刻は17時00分から21時00分までの間で選択してください。\n";
			}
			if(msg.length > 0){
				alert(msg);
				return false;
			}
			return true;
		}
	//-->
</script>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Meddon&display=swap');

h2,
h3{text-align: center;
      color:white
}

th{color:white}
td{color:white}
p1{text-align: center;
   color:white;
   font-size:x-large;
}

a.index {
    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    display: block;
    margin: 1px auto;
    max-width: 250px;
    text-decoration: none;
    border-radius: 4px;
    padding: 20px 30px;
}

#button {
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(255, 255, 255, 0.85) 0 0px 0px 1px inset;
}

#button:hover {
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(153, 102, 0, 1) 0 0px 0px 40px inset;
}
</style>
<body>
<header>
<%
        User user = (User) session.getAttribute("userInfo");
%>
<!--        アコーディオンメニューの表示          -->
<div class="cp_menu">
        <%
            if (user != null) {
        %>
        <label for="cp_menu_bar1">ようこそ！<%=user.getUsrName()%>様
        </label> <input type="radio" name="radio" id="cp_menu_bar1" class="accordion" />
        <ul id="link1">
            <li><a href="UserUpdateSvl">お客様情報変更</a></li>
            <li><a href="UserDeleteSvl">脱会手続き</a></li>
            <li><a href="UserLogoffSvl">ログオフ</a></li>
        </ul>
        <label for="cp_menu_bar3">ご予約はこちら</label> <input type="radio"
            name="radio" id="cp_menu_bar3" class="accordion" />
        <ul id="link3">
            <li><a href="ReserveListSvl">ご予約一覧</a></li>
            <li><a href="ReserveInsertSvl">新規予約</a></li>
        </ul>
        <%
            } else {
        %>
        <label for="cp_menu_bar1">ようこそ！ゲスト様</label> <input type="radio"
            name="radio" id="cp_menu_bar1" class="accordion" />
        <ul id="link1">
            <li><a href="userLogin.jsp">ログイン</a></li>
            <li><a href="userInsert.jsp">新規入会</a></li>
        </ul>
        <%
            }
        %>
    </div>



<div style="display: flex;margin: 0 auto;">

<div  style="float:left; width:10%;
         padding: 5px; text-align:center;margin: 0 auto;">
<br/>
<br/>
<br/>
<br/>
 <a href="home.jsp">
 <img src="./img/logo.png"  width="200px"/ >
 </a>
    </div>
<div  style="float:right; width:70%;
         padding: 5px; text-align:left;margin: 0 auto;">
<div1 style="font-size:x-large;">
<font class="left"  color="#FFFAF0" >
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ristorante Idealle</h1>
</font>
</div1>
</div>
</div>
<br/>
<br/>

<nav>
<div class="buttons-coll">
  <ul class="clearfix" style="text-align:center ;">
    <li >
        <button class="custom-btn btn-2">
        <a href="home.jsp">Top</button></a>
    </li>
    <li >
        <button class="custom-btn btn-2">
        <a href="ShowMenuSvl">Menu</button></a>
    </li>
    <li >
        <button class="custom-btn btn-2">
        <a href="information.jsp">About</button></a>
    </li>
     <li >
        <button class="custom-btn btn-2">
        <a href="review.jsp">Review</button></a>
    </li>
</div>
</nav>



</header>
	<%@ include file="incFile.jsp"%>
	<%
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		request.setCharacterEncoding("utf-8");
		User u = (User) session.getAttribute("userInfo");
		LocalDateTime lo = LocalDateTime.now();
		ArrayList<Course> courseList = (ArrayList<Course>)request.getAttribute("courseList");
		Reserve reserve = (Reserve)request.getAttribute("reserve");
		int y;
		int mM;
		int d;
		int h;
		int mI;
		int p;
		if(reserve == null){
			y = lo.getYear();
			mM = lo.getMonthValue();
			d = lo.getDayOfMonth();
			h = lo.getHour();
			mI = lo.getMinute();
			p = 1;

		}
	%>
	<h2 align="center"><%=u.getUsrName()%>様 ご予約
	</h2>
		<h2 align="center"><%=fmtNull((String) request.getAttribute("msg"))%></h2>
	<br />
	<form id="frm1" name="frm1" action="ReserveOperationSvl"
		onSubmit="return checkData(this)" method="post">
		<table border="1" align="center">
			<tr>

				<th>日付</th>
				<td><select name="rsvYy">
<%
				for(int i = 0;i < 2;i++){
					y = reserve.getRsvYy() + i;
					String selected = "";
					if(y == lo.getYear()){
						selected = "selected";
					}
%>
						<option value="<%=y %>" <%= selected %>><%= y %>年</option>

				<% } %>

				</select> <select name="rsvMm">
<%
				for(int i =1 ; i < 13; i++){
					mM = reserve.getRsvMm();
					String selected = "";
					if(mM == i){
						selected = "selected";
					}
%>
					<option value="<%= i %>"<%= selected %>><%= i %>月</option>

				<% }%>

				</select> <select name="rsvDd">

<%
				for(int i =1 ; i < 32; i++){
					d = reserve.getRsvDd();
					String selected = "";
					if(d == i){
						selected = "selected";
					}
%>
					<option value="<%= i %>"<%= selected %>><%= i %>日</option>

				<% }%>
				</select></td>
			</tr>
			<tr>

				<th>時刻</th>
				<td><select name="rsvHh">
<%
				for(int i =17 ; i <= 21; i++){
					h = reserve.getRsvHh();
					if(45 <= reserve.getRsvMi()){
						h++;
					}
					String selected = "";
					if(h == i){
						selected = "selected";
					}
%>
					<option value="<%= i %>"<%= selected %>><%= i %>時</option>

				<% }%>

				</select> <select name="rsvMi">
<%
				for(int i =0 ; i <= 45; i += 15){
					mI = reserve.getRsvMi();
					String selected = "";
					if(1 <= mI && mI <= 14){
						mI = 15;
					}else if(15 <= mI && mI <= 29){
						mI = 30;
					}else if(30 <= mI && mI <= 44){
						mI = 45;
					}
					if(mI == i){
						selected = "selected";
					}
%>
					<option value="<%= i %>"<%= selected %>><%= i %>分</option>

				<% }%>

				</select></td>
			</tr>
			<tr>

				<th>人数</th>
				<td><select name="person">
<%
				for(int i =1 ; i <= 6; i++){
					p = reserve.getPerson();
					String selected = "";
					if(p == i){
						selected = "selected";
					}
%>
					<option value="<%= i %>"<%= selected %>><%= i %>名</option>

				<% }%>

				</select></td>
			</tr>
			<tr>

				<th>コース</th>
				<td><select name="courseId">
<%
				for(Course c : courseList){
					String cName = c.getCourseName();
					String selected = "";
					if(cName == reserve.getCourseName()){
						selected = "selected";
					}
%>
					<option value="<%= c.getCourseId() %>"<%= selected %>><%= cName %></option>

				<% }%>

				</select></td>
			</tr>
			<tr>

				<td id="sub" colspan="2">
				席を確認します。確認を押してください。 <input
					type="submit" value=" 確認" />
				</td>
			</tr>

			<input type="hidden" name="usrId" value="1" />

			<input type="hidden" name="mode" value="11" />
		</table>
			<br />
		</form>
		<br />

<p1><a class = "index" href="userIndex.jsp" id="button">◀◀◀ BACK</a></p>
<br/>
<footer>

<nav>
<ul style="text-align:center;">
	<li class=”current”><div> <a href="https://www.instagram.com/?hl=ja" target="_blank" rel="noopener noreferrer"><img src="./img/200520133708-5ec4b3f4bb74a.png"/></a></div></li>
	<li><div><a href="https://ja-jp.facebook.com/"  target="_blank" rel="noopener noreferrer"><img src="./img/200528153054-5ecf5a9ebd033.png"/></a></div></li>
	<li><div><a href="https://www.ubereats.com/jp" target="_blank" rel="noopener noreferrer"><img src="./img/200529091516-5ed0541485804.png"/></a></div></li>
	<li><div><a href="https://www.foxnews.com/" target="_blank" rel="noopener noreferrer"><img src="./img/200529090425-5ed051899491f.png"/></a></div></li>
	<li><div><a href="https://thebase.in/" target="_blank" rel="noopener noreferrer"><img src="./img/200529092244-5ed055d4afce8.png"/></a></div></li>
</ul>
    </nav>
<br/>
<br/>
    </div>
        </div>
<hr>
<font class="right" size="1" color="#FFFAF0" ><p>
         【Ristorante Idealle】<br/>
〒060-0005<br/>
札幌市中央区北５条西2−５<br/>
JRタワーオフィスプラザさっぽろ19F<br/>
TEL: 011-206-1663 <br/>
Mail: sapporo@kenschool.jp<br/>
</p>
</font>
<div style="text-align: right;" >
 <a href="adminLogin.jsp" >●管理者ログイン</a>
<br/>
<font  color="#FFFAF0" size="2">※Created by Kamiyama,Kawata,Nagata,Yanagisawa,Yokoi,Mizuki
<br/>
※Unauthorized copying of the All of this site are strictly prohibited.
<br/>
</font>
 </div>
</footer>
</body>
</html>