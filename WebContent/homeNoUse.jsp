<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>Ristorante IDEALLE</title>


        <link rel="stylesheet" type="text/css"href="homeAction.css"/>

<!-- タイトル用フォントのインポート -->
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');
</style>
<!-- 日本語レビュー用フォントのインポート -->
<style>
@import url('https://fonts.googleapis.com/css2?family=M+PLUS+1p&display=swap');
</style>
<script type="text/javascript">
$(function() {
    var topBtn = $('#page-top');
    topBtn.hide();
    //スクロールが100に達したらボタン表示
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            topBtn.fadeIn();
        } else {
            topBtn.fadeOut();
        }
    });
    //スクロールしてトップ
    topBtn.click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
        return false;
    });
});
</script>
</head>
<body>
<!-- ページトップへ戻るボタン -->
<p class="pagetop" style="display: block;">
<a href="#">
<i class="fas fa-chevron-up">Top</i>
</a>
</p>
</head>
<header>

<div style="display: flex;margin: 0 auto;">
<div  style="float:left; width:10%;
         padding: 5px; text-align:center;margin: 0 auto;">
 <a href="home.jsp">
 <img src="./img/logo.png"  width="200px"/ >
 </a>
    </div>
<div  style="float:right; width:70%;
         padding: 5px; text-align:left;margin: 0 auto;">

<font class="right" size="1" color="#FFFAF0" ><p>
         【Ristorante Idealle】<br/>
〒060-0005<br/>
札幌市中央区北５条西2−５<br/>
JRタワーオフィスプラザさっぽろ19F<br/>
TEL: 011-206-1663 <br/>
Mail: sapporo@kenschool.jp<br/>
</p>
</font>
<div1 style="font-size:x-large;">
<font class="left"  color="#FFFAF0" >
        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ristorante Idealle</h1>
</font>
</div1>
</div>
</div>
<br/>
<br/>
<nav>
<div class="buttons-coll">
  <ul style="text-align:center ">
    <li >
        <button class="custom-btn btn-2">
        <a href="home.jsp">Top</button></a></a>
    </li>
    <li >
        <button class="custom-btn btn-2">
        <a href="ShowMenuSvl">Menu</button></a></a>
    </li>
    <li >
        <button class="custom-btn btn-2">
        <a href=”#”>
        <a href="information.jsp">About</button></a></a>
    </li>
     <li >
        <button class="custom-btn btn-2">
        <a href="review.jsp">Review</button></a></a>

    </li>
</div>
</nav>
 <br/>
<br/>
<br/>
<br/>
<br/>
</header>

<main>

          <video src="./img/schoolTop.mp4" width="100%" loop autoplay muted></video>

<!--
<div class="slide-show" >
<img src="./img/image1.jpg" />
<img src="./img/menu1.jpg" />
<img src="./img/menu9.jpg" />
<img src="./img/menu10.jpg" />
</div>
-->


<!--
<div class="slide-show" id="makeImg" >
  <img src="./img/image1.jpg"   alt="1">
  <img src="./img/menu1.jpg"    alt="2">
  <img src="./img/menu9.jpg"    alt="3">
  <img src="./img/menu10.jpg"    alt="4">
</div>
-->

<br/>
</main>

<middle>

<br/>
<br/>
<br/>
<br/>
<div style="display: flex;">
<div style="float:left; width:40%;
         padding: 10px; text-align:center;">
<font size="4" color="#FFFAF0">
<br/>
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

<a href="ShowMenuSvl" text-align:auto;><b>■メニュー■</b></a></span><br/><br/><br/><br/>
</font>
</div>

<div  class="slide" style="float:right;
         padding: 10px; text-align:center;">
         <br/>
    <img src="./img/menu9.jpg"  alt="menu1" />
        <img src="./img/menu3.jpg"  alt="menu2" />
<br/><br/><br/>
</div>
</div>
<hr>

<div style="display: flex;">
<div style="float:left; width:40%;
         padding: 10px; text-align:center;">
         <br/><br/><br/><br/>
    <img src="./img/entrance.jpg"  width="400px" />
</div>

<div style="float:right; width:40%;
         padding: 10px; text-align:center;">
<font size="4" color="#FFFAF0">

<br/>
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

<a href="userInsert.jsp"><b>■新規お客様登録し予約■</b><br/><br/><br/></a>
</span>
<br/>
<br/>
</font>
</div>
</div>
<hr>

<div style="display: flex;" class="jpReview">
<div  style="float:left; width:40%;
         padding: 10px; text-align:center;">
<font size="4" color="#FFFAF0" >
<br/><br/><br/>
<span class="firstStr2">
店内は暑苦しさ、ぬくもり、<br/>
しつこさを大切にしています。<br/>
外装内装、食器類はもちろん<br/>
私たちスタッフが<u>二日酔い</u>でも<br/>
頑張っておもてなしの心で<br/>
貴方の<u>おヒマなお時間</u>を<br/>
一生の思い出にします。<br/><br/><br/><br/>
</span>
</font>
</div>
<div style="float:right; width:40%;
         padding: 10px; text-align:center;">
<br/><br/><br/><br/>
    <img src="./img/image1.jpg"  width="400px" />
</div>
</div>
<hr>


<div style="display: flex;" class="jpReview">
<div style="float:left; width:40%;
         padding: 10px; text-align:center;">
<font size="4" color="#FFFAF0">
<br/>
<br/><br/>
<b>【Ristorante Idealle住所】</b><br/>
〒060-0005<br/>
札幌市中央区北５条西2−５<br/>
JRタワーオフィスプラザさっぽろ19F<br/>
TEL: 011-206-1663 <br/>
Mail: sapporo@kenschool.jp<br/>
＊迷ったら第一村人に尋ねるか<br/>
お電話いただけたらお迎いに参ります。<br/>
<br/>
<a href="userLogin.jsp"><b>■既に予約済＆会員の方はログイン■</b></a>
<br/><br/><br/><br/>
</font>
</div>
<div style="float:right; width:40%;
         padding: 10px; text-align:center;">
<br/><br/><br/>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d8121136.269930602!2d30.49056931346272!3d-6.342397306420757!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x184b51314869a111%3A0x885a17314bc1c430!2z44K_44Oz44K244OL44Ki!5e0!3m2!1sja!2sjp!4v1603881686300!5m2!1sja!2sjp" width="400" height="400" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe></div>
</div>

</middle>

<footer>
<br/><br/><br/>
<nav>
            <ul style="text-align:center">
              <li class=”current”><div> <a href="https://www.instagram.com/?hl=ja"><img src="./img/200520133708-5ec4b3f4bb74a.png"/></a></div></li>
              <li><div><a href="https://ja-jp.facebook.com/" ><img src="./img/200528153054-5ecf5a9ebd033.png"/></a></div></li>
              <li><div><a href="https://www.ubereats.com/jp"><img src="./img/200529091516-5ed0541485804.png"/></a></div></li>
              <li><div><a href="https://www.foxnews.com/"><img src="./img/200529090425-5ed051899491f.png"/></a></div></li>
              <li><div><a href=https://thebase.in/""><img src="./img/200529092244-5ed055d4afce8.png"/></a></div></li>
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