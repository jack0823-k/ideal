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

import model.Admin;
import model.Course;
import model.IdealException;
import model.Menu;
import model.MenuType;

/**
 * Servlet implementation class MenuInsertSvl
 */
@WebServlet("/MenuInsertSvl")
public class MenuInsertSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuInsertSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get送信の場合でもdoPost()を呼び出す
		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;
		String url = "";				//遷移先URL
		HttpSession session = request.getSession();

		int typeId = 100;

		Admin ad = (Admin) session.getAttribute("adminInfo");
		if (ad == null) {				//nullの場合は「ホーム」へ
			url = "home.jsp";
			response.sendRedirect(url);
		}

		try {
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			typeId = 100;
		}
		try {
			if (typeId == 100) {		//コースの場合
				//分類ごとのメニューを格納したものをリスト化
				ArrayList<ArrayList<Menu>> typeMenuList = new ArrayList<>();
				for (int i = 0; i < Course.COURSE_MENU_TYPE_ID.length; i++) {
					ArrayList<Menu> menuList = Menu.getMenu(Course.COURSE_MENU_TYPE_ID[i]);	//分類ごとのメニューを格納
					typeMenuList.add(menuList);
				}
				request.setAttribute("typeMenuList", typeMenuList);
				url = "courseInsert.jsp";				//「新規コース登録画面」へ

			}else {						//コース以外の場合
				ArrayList<MenuType> mtList = MenuType.getAllType();
				request.setAttribute("mType", mtList);
				request.setAttribute("typeId", typeId);
				url = "menuInsert.jsp";					//「新規メニュー登録画面」へ
			}

		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());
			url = "menuMaintenanceSvl";				//「メニューメンテナンス画面表示処理(サーブレット)」へ
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
