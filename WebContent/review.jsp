<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>お客様レビュー
</title>
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
<main>
<div style="display: flex;margin: 0 auto;">
<div  style="float:left; width:40%;
         padding: 10px; text-align:center;   margin: 0 auto;">
<font class="left" size="4" color="#FFFAF0" ><p>
【Toro様】素敵な店主</p></font>
<font size="3" color="#FFFAF0" ><span class="firstStr">みどりの町の住宅街にある隠れ家的なお店。 <br/>
静かな環境で外観や内装もすごく良い雰囲気です。 <br/>
本日はランチにお邪魔しました。Bランチを注文。 <br/>
前菜2品、メインディッシュ,デザート、 <br/>
ドリンクは1品を選べます。 <br/>
パンはおかわり出来ます。 <br/>
料理はリーズナブルで見た目の彩りもキレイで美味しいです。 <br/>
焼きたてのパンも香ばしく、デザートも美味しくいただきました。 <br/>
ランチBOX、オードブルなどのテイクアウトもされてます。 <br/>
 (訪問：2020/08/25) <br/>
</span>
</font>
    </div>
<div  style="float:right; width:40%;
         padding: 10px; text-align:center;   margin: 0 auto;">
<font class="left" size="4" color="#FFFAF0" ><p>
【kino様】素敵な店主の娘</p></font>
<font size="3" color="#FFFAF0" ><span class="firstStr">
以前、記念日に伺い お店の雰囲気が良くて<br/>
落ち着いてフレンチをいただけたので、<br/>
今回は母とランチで再訪です。<br/>
私はお肉ランチ、母は魚ランチで前菜が２種選べる<br/>
コースにしました。前菜が凄すぎました。<br/>
エスカルゴを初めていただきましたが、<br/>
すごく柔らかくとろける食感で美味しかったです。<br/>
鮎を使った前菜も香りが良くかなり美味しかったです。<br/>
日常を少し忘れ、美味しいものに話を咲かせることが出来ました。<br/>
 (訪問：2020/07/30)
 </span>
</font>
    </div>
</div>
<hr/>
<div style="display: flex;margin: 0 auto;">
<div  style="float:left; width:40%;
         padding: 10px; text-align:center;   margin: 0 auto;">
<font class="left" size="4" color="#FFFAF0" ><p>
【ぴなぷ様】素敵なムスコ</p></font>
<font size="3" color="#FFFAF0" ><span class="firstStr">
先ずはサラダ。サラダというより前菜です。<br/>
一つ一つ丁寧に盛り付けてあり、味付けや素材の味の違いを楽しめます。<br/>
スープは人参のポタージュ。美味しいです。<br/>
次はメインの鶏肉。パリパリの皮でgood！<br/>
付け合わせのキャベツは甘く、ジャガイモはねっとりとしていてとても合います。<br/>
デザートは、レモンのタルトとバニラアイス。
<br/>レモンピールの苦味が絶妙、その辺の<br/>
ケーキ屋さんのよりも何倍も美味しいです。
<br/>バニラアイスはバニラの風味が豊かに香り、<br/>
タルトと一緒に食べたらまた美味しかったです。<br/>
絶対リピート、また来ます。お店の内装も雰囲気も好み。<br/>
大切なお店とさせて頂きたいと思います。<br/>
 (訪問：2020/03/03)
</span>
</font>
    </div>
<div  style="float:right; width:40%;
         padding: 10px; text-align:center;   margin: 0 auto;">
<font class="left" size="4" color="#FFFAF0" ><p>
【のん様】素敵な店主の愛人</p></font>
<font size="3" color="#FFFAF0" ><span class="firstStr">
平日のランチでお邪魔しました(^^)メインが選べる2000円のコースにしました。どれも美味しそうでかなり悩みます！フレンチなのに豚足?と思い、豚足の包んだような物をチョイス。運ばれてきて、まず、香りにビックリです。中華を思わせるような、八角の香りが漂います。添えてある野菜もまさかのニラ！味は中華なのに見た目はフレンチ〜、でも香りは中華、でもナイフとフォークで食べてる！軽いパニックになりました（笑）オードブルも一つ一つがとても手がこんでいて、特にキッシュは焼きたてサクサクで絶品です。デザートは、温かいタルトにアイスクリームが添えられていて(他にも数種類アリ)ランチとは思えないクオリティでした。コレで2000円はお得です☆値段以上の満足感でした。 (訪問：2015/08/27)
 </span>
</font>
    </div>
</div>
<br/>
<br/>
<br/><br/>
<br/>
</main>
<footer>
<nav>
            <ul style="text-align:center">
              <li class=”current”><div><a href=”#”> <a href="https://www.instagram.com/?hl=ja"><img src="./img/200520133708-5ec4b3f4bb74a.png"/></a></a></div></li>
              <li><div><a href=”#”><a href="https://ja-jp.facebook.com/" ><img src="./img/200528153054-5ecf5a9ebd033.png"/></a></div></li>
              <li><div><a href=”#”><a href="https://www.ubereats.com/jp"><img src="./img/200529091516-5ed0541485804.png"/></a></a></div></li>
              <li><div><a href=”#”><a href="https://www.foxnews.com/"><img src="./img/200529090425-5ed051899491f.png"/></a></a></div></li>
              <li><div><a href=”#”><a href=https://thebase.in/""><img src="./img/200529092244-5ed055d4afce8.png"/></a></a></div></li>
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