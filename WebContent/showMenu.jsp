<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@ page import="model.Menu"%>
<%@ page import="model.Course"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="incFile.jsp"%>
<title>Menu | Restaurante IDEALLE</title>

<!-- cssのインポート -->
<link rel="stylesheet" type="text/css" href="homeAction.css" />
<!-- タイトル用フォントのインポート -->
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>
<!-- 日本語レビュー用フォントのインポート -->
<style>
@import
	url('https://fonts.googleapis.com/css2?family=M+PLUS+1p&display=swap');
</style>

<script type="text/javascript">
<!--

	//1.メニュー名クリック時のコメント表示、
	function showDetail(id) {
		//1.引き渡されたメニュー番号の"style.display"が"block"の時、
		if (document.getElementById(id).style.display == 'block') {
			//1.引き渡されたメニュー番号の"style.display"を"none"に設定する。
			document.getElementById(id).style.display = 'none';
		}
		//2.引き渡されたメニュー番号の"style.display"が"block"以外の時、
		else {
			//1.引き渡されたメニュー番号の"style.display"を"block"に設定する。
			document.getElementById(id).style.display = 'block';
		}
	}
	//2.メニュー名クリック時のメニュー名のフォント変更、
	function change(id, val) {
		//1.引き渡された色区分(val)が"0"の時
		if (val == 0) {
			//1.引き渡されたメニュー番号のフォント色を"red"、フォントの太さを"bold"に設定する。
			document.getElementById(id).style.color = 'red';
			document.getElementById(id).style.fontWeight = 'bold';
		}
		//2.引き渡された色区分(val)が"0"以外の時
		else {
			//1.引き渡されたメニュー番号のフォント色を"DarkOliveGreen"、フォントの太さを"normal"に設定する。
			document.getElementById(id).style.color = 'DarkOliveGreen';
			document.getElementById(id).style.fontWeight = 'normal';
		}
	}

	-->
</script>

<link rel="stylesheet" type="text/css" href="showMenu.css" />

</head>
<body>
	<%
		User user = (User) session.getAttribute("userInfo");
	%>
	<header>

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





	</nav> <!--  追尾するメニューバーの表示 --> <!--  <table id="auto">
		<tr>
			<th id="auto"><a href="reserveInsert.jsp">ご予約</a></th>
		</tr>
		<tr>
			<th id="auto"><a href="userInsert.jsp">新規お客様登録</a></th>
		</tr>
		<tr>
			<th id="auto"><a href="userLogin.jsp">ログイン</a></th>
		</tr>

	</table>	--> <!--		アコーディオンメニューの表示			-->
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
	</header>



	<h2>Menu</h2>
	<br />
	<!-- Beanを生成 -->


	<%
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		request.setCharacterEncoding("utf-8");
	%>

	<jsp:useBean id="courseList" class="java.util.ArrayList"
		scope="request" />
	<jsp:useBean id="menuList" class="java.util.ArrayList" scope="request" />

	<div class="clearfix">
		<div id="fake1"></div>

		<!-- 左側メニュー目次の表示 -->


		<table id="mokuzi" align="left">
			<tr>
				<th id="right"><a href="#jump1">コース料理</a></th>
			</tr>
			<tr>
				<th id="right"><a href="#jump2">アラカルト</a></th>
			</tr>

		</table>

		<div id="fake2"></div>

		<!-- コースの表示 -->

		<table id="main">

			<tr>
				<td id="left"><img src="./img/lefttop.png" /></td>
				<td id="right"><img src="./img/righttop.png" /></td>
			</tr>
			<tr>
				<td><div id="jump1"></div></td>
			</tr>

			<tr>
				<td colspan="2"><div class="box1">
						<p>～ コース料理 ～</p>
					</div></td>
			</tr>

			<tr>

				<td id="center" ><div class="cen">
<img src="./img/course1.jpg"  class="appIconBig" />
				</div>
				</td>

			</tr>



			<%
				int current_cId = 0;

				for (int i = 0; i < courseList.size(); i++) {
					Course c = (Course) courseList.get(i);

					//コース名は一回のみ表示する
					if (current_cId != c.getCourseId()) {
						current_cId = c.getCourseId();
			%>

			<tr><td><br /></td></tr>
			<tr>
				<th id="c_name"><div id="area1" />～&nbsp;<%=c.getCourseName()%>&nbsp;～</div></th>
				<th id="c_price"><%=nf.format(c.getPrice())%></th>
			</tr>


			<tr>
				<th id="c_detail"><%=c.getDetail()%></th>
			</tr>


			<%
				}
			%>

			<tr>
				<!-- 先頭2文字分くらいさげたい -->
				<th id="c_name"><%=c.getMenuName()%></th>
			</tr>

			<%
				}
			%>

			<!--ここから  <tr>
				<td id="left"><img src="./img/leftunder.png"  class="conner"/></td>
				<td id="right"><img src="./img/rightunder.png"  class="conner"/></td>
			</tr>




		<div class="clearfix">

		<div id="fake3"></div>

		<table id = "main"  >

			<tr>
				<td id = "left"><img src="./img/lefttop.png"  /></td>
				<td id = "right"><img src="./img/righttop.png"  /></td>
			</tr>
			ここまでコメントアウト-->


			<tr>
				<td><div id="jump2"></div></td>
			</tr>

			<tr>
				<td id="title" colspan="2"><div class="box2">
						<p>～ アラカルトメニュー ～</p>
					</div> <br /></td>
			</tr>

			<tr>
				<td id="center" ><div class="cen"><img src="./img/imageex3.jpg" class="applconBig" /></div></td>
			</tr>


			<%
				int current_cId2 = 0;

				for (int i = 0; i < menuList.size(); i++) {
					Menu m = (Menu) menuList.get(i);

					//分類名は一回のみ表示する
					if (current_cId2 != m.getTypeId()) {
						current_cId2 = m.getTypeId();
			%>
			<tr><td><br /></td></tr>
			<tr>
			<th><div id="area1">～&nbsp;<%=m.getTypeName()%>&nbsp;～</div></th>
			</tr>
			<%
				}
			%>
			<tr>
				<td id ="menu">
				<font color="DarkOliveGreen">
				<div class="menu"
				id="menu<%= m.getMenuId() %>"
				onmouseover ="change('menu<%= m.getMenuId() %>' , 0)"
				onmouseout="change('menu<%= m.getMenuId() %>' , 1)"
				onclick="showDetail('exp<%= m.getMenuId() %>')">
						◆<%=m.getMenuName()%>
				</div> </td>
				</font>
				<th id="m_price"><%=nf.format(m.getPrice())%></th>
			</tr>

			<tr>
				<th><div id="exp<%= m.getMenuId() %>"  style="display:none"><%=fmtNull(m.getDetail()) %></div></th>
			</tr>


			<%
				}
			%>

			<tr>
				<!-- 下部の装飾 -->
				<td id="left"><img src="./img/leftunder.png" /></td>
				<td id="right"><img src="./img/rightunder.png" /></td>
			</tr>

		</table>
	</div>
	</br>
	</br>
	</br>

	<footer> <nav>
	<ul style="text-align: center;">
		<li class=”current”><div>
				<a href="https://www.instagram.com/?hl=ja" target="_blank"
					rel="noopener noreferrer"><img
					src="./img/200520133708-5ec4b3f4bb74a.png" /></a>
			</div></li>
		<li><div>
				<a href="https://ja-jp.facebook.com/" target="_blank"
					rel="noopener noreferrer"><img
					src="./img/200528153054-5ecf5a9ebd033.png" /></a>
			</div></li>
		<li><div>
				<a href="https://www.ubereats.com/jp" target="_blank"
					rel="noopener noreferrer"><img
					src="./img/200529091516-5ed0541485804.png" /></a>
			</div></li>
		<li><div>
				<a href="https://www.foxnews.com/" target="_blank"
					rel="noopener noreferrer"><img
					src="./img/200529090425-5ed051899491f.png" /></a>
			</div></li>
		<li><div>
				<a href="https://thebase.in/" target="_blank"
					rel="noopener noreferrer"><img
					src="./img/200529092244-5ed055d4afce8.png" /></a>
			</div></li>
	</ul>
	</nav> <br />
	<br />
	<hr>
		<font class="right" size="1" color="#FFFAF0"><p>
				【Ristorante Idealle】<br /> 〒060-0005<br /> 札幌市中央区北５条西2−５<br />
				JRタワーオフィスプラザさっぽろ19F<br /> TEL: 011-206-1663 <br /> Mail:
				sapporo@kenschool.jp<br />
			</p> </font>
		<div style="text-align: right;">
			<a href="adminLogin.jsp">●管理者ログイン</a> <br /> <font color="#FFFAF0"
				size="2">※Created by
				Kamiyama,Kawata,Nagata,Yanagisawa,Yokoi,Mizuki <br /> ※Unauthorized
				copying of the All of this site are strictly prohibited. <br />
			</font>
		</div>
	</footer>






	<!-- TODO①値をgetできてるかチェック -->
	<!-- TODO②コース部分の表示が整っているか -->
	<!-- TODO③コース詳細、メニュー詳細をonmouseoverで表示 -->

	<br />



	<!--
		//顧客ログイン済のときuserIndex.jspに遷移
		if(){
			<p><a href="userIndex.jsp">[戻る]</a></p>

		}%


		//顧客未ログインのときhome.jspに遷移
		if(){
			<p><a href="home.jsp">[戻る]</a></p>

		}
		-->

</body>
</html>