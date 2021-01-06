<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ristorante IDEALLE</title>
<!-- cssのインポート -->
<link rel="stylesheet" type="text/css"href="homeAction.css"/>
 <link rel="stylesheet" type="text/css" href="showMenu.css" />

<!-- タイトル用フォントのインポート -->
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>
<!-- 日本語レビュー用フォントのインポート -->
<style>
@import url('https://fonts.googleapis.com/css2?family=M+PLUS+1p&display=swap');
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
<video loop muted autoplay playsinline  id="bgvid">
<source src="./img/schoolTop.mp4" type="video/mp4">
</video>
<div id="polina" font-size : 2em;">

<font size="4" color="#FFFAF0" class="jpReview" >
<div class="fade-in01">
<div  class="slide" style="float:right;
         padding: 10px; text-align:center;">
    <img src="./img/menu9.jpg"  alt="menu1" />
        <img src="./img/menu3.jpg"  alt="menu2" />
</div>
</div>
<span class="firstStr2">
どこかで食べた気がする…<br/>
そんな経験は一度はあるはず。<br/>
そうです。<br/>
当店は吉野家から仕入れてます！<br/>
なのでうまいです!<br/>
ポテトはMacDonald,Kentucky Fried Chicken,
MOS BURGER・・・<br/>
そしてDOMDOM HamburgerをMix。<br/>
タレは<u>ベルのタレ</u>です。<br/>
食器だけは夜な夜な手焼きです。<br/>
<br/>
</span>
<div style="text-align:end;">
<a href="ShowMenuSvl"><b>■メニューを見る■
</b></a></div><br/>

<hr>
<br/>

 <img src="./img/entrance.jpg"  width="400px" />
<br/>
<span class="firstStr2">
箱根駅から徒歩２時間<br/>
お客様の中には散歩がてらに<br/>
歩いてくる方もいます。<br/>
送迎も無料でしています。<br/>
秋口には紅葉も眺められ<br/>
日常の<u>ハゲ社長</u>のストレスから<br/>
”ス〜”っと解放されます。<br/>
人目もつきにくい場所なので<br/>
隠しごとに向いてます！<br/>
あの<u>渡⚫さん</u>もご来店され・・・<br/>
<br/>
</span>

<br/>
<hr>
<br/>
 <img src="./img/image1.jpg"  width="400px" />
 <br/>
<span class="firstStr2" style="text-align:right;">
店内は暑苦しさ、ぬくもり、<br/>
しつこさを大切にしています。<br/>
外装内装、食器類はもちろん<br/>
私たちスタッフが<u>二日酔い</u>でも<br/>
頑張っておもてなしの心で<br/>
貴方の<u>おヒマなお時間</u>を<br/>
一生の思い出にします。<br/>

</span>
<br/>
<div style="text-align:end;">
<a href="information.jsp">■もっとお店を覗く</button>
</a></div>
<hr>
<br/>
<div style="text-align:center;">
<b>【Ristorante Idealle】</b>
</div><br/>
〒060-0005<br/>
札幌市中央区北５条西2−５<br/>
JRタワーオフィスプラザさっぽろ19F<br/>
TEL: 011-206-1663 <br/>
Mail: sapporo@kenschool.jp<br/>
＊迷ったら第一村人に尋ねるかお電話いただけたらお迎いに参ります。<br/>
<br/>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d8121136.269930602!2d30.49056931346272!3d-6.342397306420757!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x184b51314869a111%3A0x885a17314bc1c430!2z44K_44Oz44K244OL44Ki!5e0!3m2!1sja!2sjp!4v1603881686300!5m2!1sja!2sjp" width="400" height="400" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
<br/>
<br/>


</div>
</font>
</div>
</div>
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