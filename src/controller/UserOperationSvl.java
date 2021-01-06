package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserOperationSvl
 */
@WebServlet("/UserOperationSvl")
public class UserOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//フィールド
	public static final int INSERT = 11;      //登録処理
	public static final int UPDATE = 12;      //変更処理
	public static final int DELETE = 13;      //削除処理

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOperationSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";

		// インターフェイスからオブジェクトのセッションを生成
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");   // セッション情報の取得
		int mode;
		mode = Integer.parseInt(request.getParameter("mode")); //リクエストパラメーターmodeを受け取る
		if(mode != 11){                                        //modeが登録"11"以外で
			if(user == null){                                  //セッション情報がnullの時
				url = "home.jsp";                              //ホームページに遷移する
				response.sendRedirect(url);
			}
		}
		//リクエストパラメーター（予約情報）を取得
		String usrName;    //顧客名
		String password;   //パスワード
		String address;    //住所
		String phone;      //電話番号
		String mail;       //メールアドレス
		usrName = request.getParameter("usrName");
		password = request.getParameter("password");
		address = request.getParameter("address");
		phone = request.getParameter("phone");
		mail = request.getParameter("mail");


		//顧客情報(User)を生成
		User u = new User();
		u.setUsrName(usrName);
		u.setPassword(password);
		u.setAddress(address);
		u.setPhone(phone);
		u.setMail(mail);

		 String eMail = "";
		 String passWord = "";
		 String eMailFlg = "";
		 String passWordFlg = "";
		int usrId =0;
		switch(mode){
		case INSERT: 			//modeが登録処理のとき
			//cookieオブジェクトを作成
			Cookie ck1 = new Cookie("eMail", mail);			//ログインに必要なemailを渡す
			Cookie ck2 = new Cookie("passWord", password);	//ログインに必要なpasswordを渡す
			Cookie ck3 = new Cookie("eMailFlg", request.getParameter("eMailFlg"));
			Cookie ck4 = new Cookie("passWordFlg", request.getParameter("passWordFlg"));
			System.out.println("UserOperationINSERT:Coookie");
			System.out.println(request.getParameter("eMailFlg"));
			System.out.println(request.getParameter("passWordFlg"));

			ck1.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck2.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck3.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck4.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定

			try {
				response.addCookie(ck1);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck2);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck3);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck4);	//クッキーに送信するcookieオブジェクトを追加

			} catch (IllegalArgumentException e) {//Cookieでは「スペース」や「カンマ」などの文字が許容されない
	            System.out.print(" : Some information was not saved to Cookie because illegal character such as ',' was used"+"</br>");
	            System.out.print("Please use characters which are in ASCII");
	            }
			try{
				u = User.insert(u);                                   //顧客テーブルの情報追加
				usrId = u.getUsrId();                                 //登録した顧客IDを取得
				session.setAttribute("userInfo", User.getUser(usrId));    //顧客IDで顧客情報を取得し、セッションに設定
				url = "userInsertCompletion.jsp";                     //顧客登録完了画面を遷移先にセット
			} catch (IdealException e) {
				request.setAttribute("msg","既に使用されているメールアドレスです。");              //例外が発生したときに、メッセージを取得
				try {
					request.setAttribute("user",User.getUser(usrId));
				} catch (IdealException e1) {
					request.setAttribute("msg", e.getMsg());
				}
				url = "userInsert.jsp";                               //顧客処理選択画面を遷移先にセット
			}
			break;

		case UPDATE:                      //modeが変更処理のとき
			 Cookie[] cks = request.getCookies();

			 if(cks != null){
			        for(int ck=0; ck<cks.length; ck++){
			                if(cks[ck].getName().equals("eMail")){
			                	eMail = cks[ck].getValue();
			                }
			                else if(cks[ck].getName().equals("passWord")){
			                        passWord = cks[ck].getValue();
			                }
			                else if(cks[ck].getName().equals("eMailFlg")){
			                	eMailFlg = cks[ck].getValue();
			            }
			                else if(cks[ck].getName().equals("passWordFlg")){
			                	passWordFlg = cks[ck].getValue();
			            }
			        }
			 }
			 if (eMailFlg.length() == 0) {
				eMail = "";
			}
			 if (passWordFlg.length() == 0) {
				passWord = "";
			}
			//cookieオブジェクトを作成
			ck1 = new Cookie("eMail", mail);			//ログインに必要なemailを渡す
			ck2 = new Cookie("passWord", password);	//ログインに必要なpasswordを渡す
			ck3 = new Cookie("eMailFlg", eMailFlg);
			ck4 = new Cookie("passWordFlg", passWordFlg);
			System.out.println("UserOperationUPDEATESvl:Coookie");
			System.out.println(eMail);
			System.out.println(passWord);
			System.out.println(eMailFlg);
			System.out.println(passWordFlg);
			ck1.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck2.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck3.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			ck4.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
			try {
				response.addCookie(ck1);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck2);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck3);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck4);	//クッキーに送信するcookieオブジェクトを追加
			} catch (IllegalArgumentException e) {//Cookieでは「スペース」や「カンマ」などの文字が許容されない
	            System.out.print(" : Some information was not saved to Cookie because illegal character such as ',' was used"+"</br>");
	            System.out.print("Please use characters which are in ASCII");
	            }
			try{
				usrId = Integer.parseInt(request.getParameter("usrId"));
				u.setUsrId(usrId);
				u.setExp("new exp");
				u = User.update(u);                                    //顧客テーブルの顧客情報変更
				usrId = u.getUsrId();                                 //登録した顧客IDを取得
				session.setAttribute("userInfo", User.getUser(usrId)); //変更した顧客情報をセッションに設定
				url = "userIndex.jsp";                                 //顧客処理選択画面を遷移先にセット
			} catch (IdealException e) {
				request.setAttribute("msg", e.getMsg());               //例外が発生したときに、メッセージを取得
				e.printStackTrace();
				url = "UserUpdateSvl";                            //顧客情報変更画面表示処理を遷移先にセット
			}
			break;

		case DELETE:                       //modeが削除処理のとき
			ck1 = new Cookie("eMail", eMail);
			ck2 = new Cookie("passWord", passWord);
			ck3 = new Cookie("eMailFlg", eMailFlg);
			ck4 = new Cookie("passWordFlg", passWordFlg);
			ck1.setMaxAge(60*60*24*0);	//Cookieの有効期限を0日に設定することでクッキー情報をリセットする
			ck2.setMaxAge(60*60*24*0);
			ck3.setMaxAge(60*60*24*0);
			ck4.setMaxAge(60*60*24*0);
			try {
				response.addCookie(ck1);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck2);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck3);	//クッキーに送信するcookieオブジェクトを追加
				response.addCookie(ck4);	//クッキーに送信するcookieオブジェクトを追加

			} catch (IllegalArgumentException e) {//Cookieでは「スペース」や「カンマ」などの文字が許容されない
	            System.out.print(" : Some information was not saved to Cookie because illegal character such as ',' was used"+"</br>");
	            System.out.print("Please use characters which are in ASCII");
	            }
			try{
				usrId = Integer.parseInt(request.getParameter("usrId"));
				u.setUsrId(usrId);
				User.delete(u);                                        //顧客テーブルの顧客情報削除
				session.invalidate();                                  //session情報の破棄
				url = "home.jsp";                                      //ホームページを遷移先にセット
			} catch (IdealException e) {
				request.setAttribute("msg", e.getMsg());               //例外が発生したときに、メッセージを取得
				e.printStackTrace();
				url = "UserDeleteSvl";                            //顧客情報削除画面表示処理を遷移先にセット
			}
			break;
		}

		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
