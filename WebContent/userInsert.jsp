<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>お客様情報登録</title>
		<link rel="stylesheet" type="text/css"href="homeActionUserIndex.css"/>
		 <link rel="stylesheet" type="text/css" href="showMenu.css" />

    	<%@ include file="incFile.jsp" %>
		<style>
		@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
		</style>
		<script type="text/JavaScript" src="incScript.js"></script>
		<script type="text/JavaScript">
			<!--
				//1.入力項目チェック
				function checkData(obj){
					//メッセージを宣言
					var msg = "";
					//名前が未入力の時、
					if(obj.usrName.value == null || obj.usrName.value == ""){
						//1.メッセージに"お名前を入力してください！\n"を追加
						msg += "お名前を入力してください。\n";
					}
					//メールが未入力の時、
					if(obj.mail.value == null || obj.mail.value == ""){
						//1.メッセージに"メールを入力してください。\n"を追加
						msg += "メールを入力してください。\n";
					}
					//電話番号に入力がある時の正規化チェック
					if(obj.phone.value == null || obj.phone.value == ""){

					}else if (obj.phone.value.match(/^[0-9]{2}-?[0-9]{4}-?[0-9]{4}|[0-9]{3}-?[0-9]{3}-?[0-9]{4}|[0-9]{4}-?[0-9]{2}-?[0-9]{4}$/)) {

					}else{
						msg += "電話番号を確認してください。\n";
						}
					//メールアドレスに入力がある時の正規化チェック
					if(obj.mail.value == null || obj.mail.value == ""){

					}else if (obj.mail.value.match(/^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}.[A-Za-z0-9]{1,}$/)) {

					}else{
						msg += "メールアドレスを確認してください。\n";
						}
					//パスワードが未入力の時、
					if(obj.password.value == null || obj.password.value == ""){
						//1.メッセージに"パスワードを入力してください。\n"を追加
						msg += "パスワードを入力してください。\n";
					}

					//8.メッセージが空白の時、
					if(msg == ""){
						//1."true"を返す。
						return true;
					}else{
					//9.メッセージが空白以外の時、
						//1.アラーとでメッセージを表示し"false"を返す。
						alert(msg);
						return false;
					}
				}
			//-->
		</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Meddon&display=swap');


h2,
h3{
	text-align: center;
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
	</head>
<body>
	<%
		User user = (User) session.getAttribute("userInfo");
	%>
<header>
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

<main>
		<h2>お客様情報登録</h2>
		<br/>

					<jsp:useBean id="msg" class="java.lang.String" scope="request"/>
		<%
			if(msg.length() > 0){
		%>
				<div align= "center"><font color = "white"><%= msg %></font></div>
				<br/>
		<%
			}
		%>

		<form action="UserOperationSvl" onsubmit="return checkData(this)" method="post">
			<table border align="center">
				<tr>
					<th>※お名前</th>
					<td><input type="text" name="usrName" size="30" maxlength="30" style="ime-mode: active;" value=""/></td>
				</tr>

				<tr>
					<th>住 所</th>
					<td><input type="text" name="address" size="50" maxlength="200" style="ime-mode: active;" value=""/></td>
				</tr>

				<tr>
					<th>電話番号</th>
					<td><input type="text" name="phone" size="15" maxlength="20" style="ime-mode: disabled;" value=""/></td>
				</tr>

				<tr>
					<th>※e-mail</th>
					<td><input type="text" name="mail" size="30" maxlength="100" style="ime-mode: disabled;" value=""/></td>
				</tr>

				<tr>
					<th>※password</th>
					<td><input type="password" name="password" size="8" maxlength="8" style="ime-mode: inactive;" value=""/></td>
				</tr>

				<input type = "hidden" name = "mode" value = "11" />
				<tr>
					<td id="sub" colspan="2" align="right">※は必修入力です。
						<input type="submit" value=" 登録 " />
					</td>
				</tr>

			</table>
			<div align="center">
			<font color="white">
					<input type="checkbox" name="eMailFlg" value="1" />e-mailを保存
					<input type="checkbox" name="passWordFlg" value="1"  />passwordを保存
			</font>
			</div>
			<br />
		</form>
		<br />

	<p1><a class = "index" href="home.jsp" id="button">◀◀◀ BACK</a></p>
	</main>


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