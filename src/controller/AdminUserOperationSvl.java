package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.User;
/**
 * Servlet implementation class UserOperationSvl
 */
@WebServlet("/AdminUserOperationSvl")
public class AdminUserOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int INSERT = 11; //登録処理
	public static final int UPDATE = 12; //変更処理
	public static final int DELETE = 13; //削除処理

    public AdminUserOperationSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset=UTF-8");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		//セッション情報userInfoを取得する。
//		session.getAttribute("userInfo");
		int usrId = Integer.parseInt(request.getParameter("usrId"));
		int mode = 0;
		String url = "";
		//リクエストパラメーター
		String usrName   = ""; //顧客名
		String password  = ""; //パスワード
		String address   = ""; //住所
		String phone     = ""; //電話番号
		String mail      = ""; //メールアドレス
		//リクエストパラメーターmodeを受け取る。
		mode = Integer.parseInt(request.getParameter("mode"));

		//リクエストパラメーターmodeが登録11以外でセッション情報userInfoが
		//nullの時ホームページに推移
		if (mode != 11 && session.getAttribute("adminInfo") == null) {
			response.sendRedirect("home.jsp");
		}
		//リクエストパラメーター予約情報を取得しUserを生成する。
		usrName   =request.getParameter("usrName");
		password  =request.getParameter("password");
		address   =request.getParameter("address");
		phone     =request.getParameter("phone");
		mail      =request.getParameter("mail");

		//modeにより処理
		switch (mode) {


		//変更処理
			case AdminUserOperationSvl.UPDATE:
				try{
					User user;
				/*
				生成した顧客情報Userで、顧客テーブルに顧客情報を変更する。
				変更した顧客情報を取得し、userInfoを設定する。
				*/
					//更新されたデータを受け取る前にusrIdでデータベースの
					//passwordとexpの情報を受け取りパスワード未入力時に備える。
//					usrId = user.getUsrId();
					user = User.getUser(usrId);
					user.setUsrName(usrName);
					user.setPassword(password);
					user.setAddress(address);
					user.setPhone(phone);
					user.setMail(mail);
					User.update(user);
					session.setAttribute("userInfo",user);
				//urlに顧客処理選択画面をセットする。
					url = "UserList";

					break;
				//例外処理
				}catch (IdealException e) {

					//リクエストオブジェクト"msg"に独自例外()よりメッセージを取得し設定する。
					request.setAttribute("msg", e.getMsg());
					//遷移先urlにをセットする。
					url = "AdminUserUpdateSvl";
					break;
				}
		//削除処理
			case AdminUserOperationSvl.DELETE:
				try{
					User user = User.getUser(usrId);
				/*
				生成した顧客情報Userで、顧客テーブルに顧客情報を削除する。
				*/
					User.delete(user);
				//urlにホームページをセットする。
					url = "UserList";

					break;
				//例外処理
				}catch (IdealException e) {
					//リクエストオブジェクト"msg"に独自例外()よりメッセージを取得し設定する。
					request.setAttribute("msg", e.getMsg());
					//遷移先urlにをセットする。
					url = "AdminUserDeleteSvl";
					break;
				}
		}
			//最後にフォーワードする。
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	}

}
