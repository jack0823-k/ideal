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
import model.IdealException;
import model.Menu;
import model.MenuType;

/**
 * Servlet implementation class MenuMaintenanceSvl
 */
@WebServlet("/MenuMaintenanceSvl")
public class MenuMaintenanceSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuMaintenanceSvl() {
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

		int typeId;

		Admin ad = (Admin) session.getAttribute("adminInfo");
		if (ad == null) {				//nullの場合は「ホーム」へ
			url = "home.jsp";
			response.sendRedirect(url);
		}
		try {											//typeIdを変換
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {				//変換できない場合は100を代入(Get送信)
			typeId = 100;
		}
		ArrayList<MenuType> mtList;
		ArrayList<Menu>  menuList;
		try {
			mtList = MenuType.getAllType();
			request.setAttribute("mType", mtList);		//分類一覧をセット
			menuList = Menu.getMenu(typeId);
			request.setAttribute("menu", menuList);		//typeIdに該当するメニュー一覧をセット
			url = "menuMaintenance.jsp";				//「メニューメンテナンス画面」へ
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());	//「MenuType.getAllType()」OR「Menu.getMenu(typeId);」のメッセージが格納
			url = "adminIndex.jsp";						//「管理者処理画面」へ
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
