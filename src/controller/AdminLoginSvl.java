package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.IdealException;

/**
 * Servlet implementation class AdminLoginSvl
 */
@WebServlet("/AdminLoginSvl")
public class AdminLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Get送信の場合でもdoPost()を呼び出す
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;
		String url = "";				//遷移先URL
		HttpSession session = request.getSession();
		//requestからパラメータの取得
		String admName = request.getParameter("admName");
		String password = request.getParameter("password");

		try {
			Admin ad = Admin.login(admName, password);		//管理者情報の取得
			if (ad != null) {								//ログインできた場合
				session.setAttribute("adminInfo", ad);		//セッションにadminInfoとしてセット
				url = "adminIndex.jsp";						//遷移先「管理者処理選択画面」
			}else {											//ログインできなかった場合
				url = "adminLogin.jsp";
				throw new IdealException(IdealException.ERR_NO_ADMIN_EXCEPTION);
			}
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());		//「Admin.loginメソッド」OR「ログインできない場合」のメッセージが入る
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
