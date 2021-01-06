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

/**
 * Servlet implementation class MenuUpdateSvl
 */
@WebServlet("/TestMenuUpdateSvl")
public class TestMenuUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMenuUpdateSvl() {
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
		String url = "courseUpdate.jsp";				//「コース情報変更画面」へ
		//Adminの生成＆sessionへセット
		HttpSession session = request.getSession();
		Admin ad = new Admin();
		ad.setAdmName("adm");
		ad.setPassword("adm");
		session.setAttribute("adminInfo", ad);
		//↑までsessionへのセット
		int typeId = 0;
		int menuId = 1;
		request.setAttribute("msg", "testexception");//TODO　テスト用msg

//		if (ad == null) {				//nullの場合は「ホーム」へ
//			url = "home.jsp";
//			response.sendRedirect(url);
//		}
		try {

			typeId = Integer.parseInt(request.getParameter("typeId"));
			menuId = Integer.parseInt(request.getParameter("menuId"));
		} catch (NumberFormatException e) {
			typeId = 100;
			menuId = 1;
		}
		//分類ごとのメニューを格納したものをリスト化
		ArrayList<ArrayList<Menu>> typeMenuList = new ArrayList<>();
		ArrayList<Menu> menuList;
		try {
		for (int i = 0; i < Course.COURSE_MENU_TYPE_ID.length; i++) {
				menuList = Menu.getMenu(Course.COURSE_MENU_TYPE_ID[i]);
				typeMenuList.add(menuList);
		}
		} catch (IdealException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	//分類ごとのメニューを格納
		request.setAttribute("typeMenuList", typeMenuList);
		ArrayList<Course> oneCourse = new ArrayList<>();
		try {
			oneCourse = Course.getOneCourse(menuId);
		} catch (IdealException e) {

			e.printStackTrace();
		}//TODO 仕様書ではmenuId
		request.setAttribute("oneCourse", oneCourse);
//		try {
//			if (typeId == 100) {		//コースの場合
//				//分類ごとのメニューを格納したものをリスト化
//				ArrayList<ArrayList<Menu>> typeMenuList = new ArrayList<>();
//				for (int i = 0; i < Course.COURSE_MENU_TYPE_ID.length; i++) {
//					ArrayList<Menu> menuList = Menu.getMenu(Course.COURSE_MENU_TYPE_ID[i]);	//分類ごとのメニューを格納
//					typeMenuList.add(menuList);
//				}
//				request.setAttribute("typeMenuList", typeMenuList);
//				ArrayList<Course> oneCourse = Course.getOneCourse(typeId);//TODO 仕様書ではmenuId
//				request.setAttribute("oneCourse", oneCourse);
//				url = "testcourseUpdate.jsp";				//「コース情報変更画面」へ
//
//			}else {						//コース以外の場合
//				ArrayList<MenuType> mtList = MenuType.getAllType();
//				request.setAttribute("mType", mtList);
//				request.setAttribute("typeId", typeId);
//				Menu oneMenu = Menu.getOneMenu(menuId, typeId);
//				request.setAttribute("oneMenu", oneMenu);
//				url = "menuUpdate.jsp";					//「メニュー情報変更画面」へ
//			}
//
//		} catch (IdealException e) {
//			request.setAttribute("msg", e.getMsg());
//			url = "menuMaintenance.jsp";				//「メニューメンテナンス画面表示処理(サーブレット)」へ
//			e.printStackTrace();
//		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
