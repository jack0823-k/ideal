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
import model.Menu;

/**
 * Servlet implementation class MenuOperationSvl
 */
@WebServlet("/MenuOperationSvl")
public class MenuOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//フィールド
	public static final int INSERT = 11;
	public static final int UPDATE = 12;
	public static final int DELETE = 13;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuOperationSvl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost()を呼び出す
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//セッションのadminInfoがnullならホームへ遷移
		HttpSession session = request.getSession();
		if(session.getAttribute("adminInfo") == null){
			response.sendRedirect("home.jsp");
		}
		//リクエストパラメーターを各変数に代入
		int mode;			//モード(INSERT or UPDATE or DELETE)
		String menuName;	//メニュー名
		String detail;		//詳細
		int orderFlg;		//オーダー可否
		int price;			//価格
		int typeId;			//分類
		int menuId;
		try{
			mode = Integer.parseInt(request.getParameter("mode"));
		}catch(NumberFormatException e){
			mode = 0;
		}
		menuName = request.getParameter("menuName");
		detail = request.getParameter("detail");
		try{
			orderFlg = Integer.parseInt(request.getParameter("orderFlg"));
		}catch(NumberFormatException e){
			orderFlg = 0;
		}
		try{
			price = Integer.parseInt(request.getParameter("price"));
		}catch(NumberFormatException e){
			price = 0;
		}
		try{
			typeId = Integer.parseInt(request.getParameter("typeId"));
		}catch(NumberFormatException e){
			typeId = 0;
		}
		try{//追加したパラメータ
			menuId = Integer.parseInt(request.getParameter("menuId"));
		}catch(NumberFormatException e){
			menuId = 0;
		}
		//Menu型オブジェクトを生成し、リクエストパラメーターの情報をセット
		Menu m = new Menu();
		m.setMenuName(menuName);
		m.setDetail(detail);
		m.setOrderFlg(orderFlg);
		m.setPrice(price);
		m.setTypeId(typeId);
		m.setMenuId(menuId);//追加したパラメータ

		String url = "MenuMaintenanceSvl";	//遷移先URL
		try{
			//データベースのメニュー情報を更新
			Menu.updateMenu(m, mode);
			//リクエストオブジェクトにtypeIdをセット
			request.setAttribute("typeId", typeId);
		}catch(IdealException e){
			//リクエストオブジェクトにmsgとoneMenuをセット
			request.setAttribute("msg", e.getMsg());
			request.setAttribute("oneMenu", m);
			switch(mode){
				case INSERT:
					url = "MenuInsertSvl";
					break;
				case UPDATE:
					url = "MenuUpdateSvl";
					break;
				case DELETE:
					url = "MenuDeleteSvl";
					break;
			}
		}
		//フォワーディング
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}