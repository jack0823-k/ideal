<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,
				model.Course,
				model.Reserve,
				controller.ReserveOperationSvl,
				java.time.LocalDate,
				java.time.format.DateTimeFormatter" %>
<%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ご予約変更</title>
		<link rel="stylesheet" type="text/css" href="homeAction.css"/>
		<link rel="stylesheet" type="text/css" href="showMenu.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>
</head>
		<script type="text/javascript">
			<!--
				function checkData(obj){
					var msg = "";
					var rsvYy = parseInt(obj.rsvYy.value);
					var rsvMm = parseInt(obj.rsvMm.value) - 1;
					var rsvDd = parseInt(obj.rsvDd.value);
					var rsvHh = parseInt(obj.rsvHh.value);
					var rsvMi = parseInt(obj.rsvMi.value);
					var rsvDay = new Date(rsvYy, rsvMm, rsvDd, rsvHh, rsvMi, 0);
					var toDay = new Date();
					if( rsvDay.getTime() < toDay.getTime() ){
						msg += "予約日時が過去日又は無効な日付です。\n";
					}
					if((rsvDay.getTime() - toDay.getTime()) / 24 / 60 / 60 / 1000 >= 365){
						msg += "一年以上先の予約は承れません。\n";
					}
					if(msg.length > 0){
						alert(msg);
						return false;
					}else{
						return true;
					}
				}
			//-->
		</script>
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

		<jsp:useBean id="courseList" class="java.util.ArrayList" scope="request" type="ArrayList<Course>"/>
		<jsp:useBean id="reserve" class="model.Reserve" scope="request"/>
		<jsp:useBean id="msg" class="java.lang.String" scope="request"/>
		<%
			//現在の年月日を取得
			int currentYear;
			int currentMonth;
			int currentDay;
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
			currentYear = Integer.parseInt(date.format(formatter));
			formatter = DateTimeFormatter.ofPattern("MM");
			currentMonth = Integer.parseInt(date.format(formatter));
			formatter = DateTimeFormatter.ofPattern("dd");
			currentDay = Integer.parseInt(date.format(formatter));
		%>
		<h2><%= reserve.getUsrName() %>様&emsp;ご予約変更</h2><br/>
		<%
			if(msg.length() > 0){
		%>
				<div><%= msg %></div>
		<%
			}
		%>
		<form action="ReserveOperationSvl" onsubmit="return checkData(this)" method="post">
			<table border="1" align="center">
				<tr>
					<th>予約番号</th>
					<td><%= reserve.getRsvId() %></td>
				</tr>
				<tr>
					<th>日付</th>
					<td>
						<select name = "rsvYy">
							<%
								//現在の年＋１年までのoptionタグを生成
								for(int y = currentYear; y <= currentYear + 1; y++){
									String selected = "";	//予約済みの年にselected属性を追加
									if((reserve != null && y == reserve.getRsvYy())
											|| (reserve == null && y == currentYear)){
										selected = "selected";
									}
							%>
									<option value="<%= y %>" <%= selected %>><%= y %>年</option>
							<%
								}
							%>
						</select>
						<select name="rsvMm">
							<%
								for(int m = 1; m <= 12; m++){
									String selected = "";
									if((reserve != null && m == reserve.getRsvMm())
											|| (reserve == null && m == currentMonth)){
										selected = "selected";
									}
							%>
									<option value="<%= m %>" <%= selected %>><%= m %>月</option>
							<%
								}
							%>
						</select>
						<select name="rsvDd">
							<%
								for(int d = 1; d <= 31; d++){
									String selected = "";
									if((reserve != null && d == reserve.getRsvDd())
											|| (reserve == null && d == currentDay)){
										selected = "selected";
									}
							%>
									<option value="<%= d %>" <%= selected %>><%= d %>日</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>時刻</th>
					<td>
						<select name="rsvHh">
							<%
								for(int h = 17; h <= 21; h++){
									String selected = "";
									if((reserve != null && h == reserve.getRsvHh())
											|| (reserve == null && h == 17)){
										selected = "selected";
									}
							%>
									<option value="<%= h %>" <%= selected %>><%= h %>時</option>
							<%
								}
							%>
						</select>
						<select name="rsvMi">
							<%
								for(int i = 0; i <= 45; i = i + 15){
									String selected = "";
									if((reserve != null && i == reserve.getRsvMi())
											|| (reserve == null && i == 0)){
										selected = "selected";
									}
							%>
									<option value="<%= i %>" <%= selected %>><%= i %>分</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>人数</th>
					<td>
						<select name="person">
							<%
								for(int p = 1; p <= 6; p++){
									String selected = "";
									if((reserve != null && p == reserve.getPerson())
											|| (reserve == null && p == 1)){
										selected = "selected";
									}
							%>
									<option value="<%= p %>" <%= selected %>><%= p %>人</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>コース</th>
					<td>
						<select name="courseId">
							<%
								for(int cn = 0; cn < courseList.size(); cn++){
									Course c = courseList.get(cn);
									String selected = "";
									if((reserve != null && reserve.getCourseId() == c.getCourseId())
											|| reserve == null && cn == 0){
										selected = "selected";
									}
							%>
									<option value="<%= c.getCourseId() %>" <%= selected %>>
										<%= c.getCourseName() %>
									</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td id="sub" colspan="2" ><font color="white">
						席を確認します。確認を押してください。
						<input type="submit" value=" 確認"/>
					</font></td>
				</tr>
			</table>
			<input type="hidden" name="rsvId" value="<%= reserve.getRsvId() %>"/>
			<input type="hidden" name="usrId" value="<%= reserve.getUsrId() %>"/>
			<input type="hidden" name="mode" value="<%= ReserveOperationSvl.UPDATE %>"/>
		</form>
		<br/>
<br />

		<p1><a class = "index" href="ReserveListSvl" id="button">◀◀◀ BACK</a></p>
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