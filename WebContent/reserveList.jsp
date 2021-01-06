<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@ page import="model.Reserve"%>
<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ご予約一覧画面</title>
<link rel="stylesheet" type="text/css" href="homeActionUserIndex.css"/>
 <link rel="stylesheet" type="text/css" href="showMenu.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>
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
	<jsp:useBean id="reserveList" class="java.util.ArrayList" scope="request" />
	<%@ include file="incFile.jsp"%>
	<%
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		request.setCharacterEncoding("utf-8");
		User u = (User) session.getAttribute("userInfo");
	%>

	<h2 align="center"><font color = "white"><%= u.getUsrName() %>様 ご予約一覧</font></h2>
	<br/>
	<p><font color = "white"><%=fmtNull((String) request.getAttribute("msg"))%></font></p>

	<table border="1" align="center">
		<tr>
			<th id="head"><font color = "white">NO</font></th>
			<th id="head"><font color = "white">ご予約日時</font></th>
			<th id="head"><font color = "white">人数</font></th>
			<th id="head"><font color = "white">コース名</font></th>
			<th id="head"><font color = "white">テーブル名</font></th>
			<th id="head"><font color = "white">登録日時</font></th>

		</tr>
		<%
			for(int i = 0;i < reserveList.size(); i++){
				Reserve r = (Reserve)reserveList.get(i);
				//予約日が昨日以前のものは表示しない
				LocalDate currentDate = LocalDate.now();
				LocalDate reserveDate = LocalDate.of(r.getRsvYy(), r.getRsvMm(), r.getRsvDd());
				if(reserveDate.isBefore(currentDate)){
					continue;
				}
		%>
				<tr>
					<td><font color = "white"><%= r.getRsvId() %></font></td>
					<td><font color = "white">
						<%= r.getRsvYy() %>年<%= r.getRsvMm() %>月<%= r.getRsvDd() %>日&ensp;
						<%= r.getRsvHh() %>時<%= r.getRsvMi() %>分
					</font></td>
					<td><font color = "white"><%= r.getPerson() %></font></td>
					<td><font color = "white"><%= r.getCourseName() %></font></td>
					<td><font color = "white"><%= r.getTableName() %></font></td>
					<td><font color = "white">
						<%= r.getAppYy() %>年<%= r.getAppMm() %>月<%= r.getAppDd() %>日&ensp;
						<%= r.getAppHh() %>時<%= r.getAppMi() %>分
					</font></td>
					<td><font color = "white">
						<form action="ReserveUpdateSvl" method="post">
							<input type="hidden" name="rsvId" value="<%= r.getRsvId() %>"/>
							<input type="submit" value="変更"/>
						</form></font>
					</td>
					<td><font color = "white">
						<form action="ReserveDeleteSvl" method="post">
							<input type="hidden" name="rsvId" value="<%= r.getRsvId() %>"/>
							<input type="submit" value="削除"/>
						</form></font>
					</td>
				</tr>
		<%
			}
		%>
			</table>
		<br/>
		<div align = "center">
		<tr>
			<th>
				<form action="ReserveInsertSvl" method="post">
				<input type="submit" value="新規ご予約" class="button"/>
				</form>
			</th>
		</tr>
		</div>

	<br />
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