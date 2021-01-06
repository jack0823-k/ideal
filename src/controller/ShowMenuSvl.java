package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.IdealException;
import model.Menu;
import model.User;

/**
 * Servlet implementation class ShowMenuSvl
 */
@WebServlet("/ShowMenuSvl")
public class ShowMenuSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuSvl() {
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
		String url = "";										//ログイン時と未ログイン時別の遷移先URLが入る
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");//セッション情報の取得
		if (user != null) {										//セッション情報がある場合(ログイン時)「顧客処理選択画面」へ
			url = "userIndex.jsp";
			request.setAttribute("url", url);
		}else {													//未ログイン時は「ホーム画面」へ
			url = "home.jsp";
			request.setAttribute("url", url);
		}//attributeにセットされたurlはshowMenu.jspの戻るボタンでgetAttributeして使います。
		try {
			ArrayList<Course> courses = Course.getCourseList();
			courses.removeIf( c -> c.getOrderFlg() == 0);	//オーダー不可の要素をListから削除
			ArrayList<Menu> menus = Menu.getMenuList();
			menus.removeIf(m -> m.getOrderFlg() == 0);		//オーダー不可の要素をListから削除
			request.setAttribute("courseList", courses);
			request.setAttribute("menuList", menus);
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());
		}
		//フォワーディング
		rd = request.getRequestDispatcher("showMenu.jsp");
		rd.forward(request, response);
	}

}
