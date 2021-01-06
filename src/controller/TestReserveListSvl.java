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

import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveListSvl
 */
@WebServlet("/TestReserveListSvl")
public class TestReserveListSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestReserveListSvl() {
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
		String url = "";
		int userId ;
		//↓userの生成
		User user = new User();//使用するオブジェクトを作成
		user.setUsrId(23);		//Beansのメソッドを使用しないでください。
		user.setPassword("pass");
		user.setUsrName("abc");
		user.setAddress("address");
		user.setPhone("080");
		user.setMail("mail@ideal.com");
		user.setExp("EXP");
		//↑までがuser
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);//		if (user == null) {				//nullの場合は「ホーム」へ
//			url = "home.jsp";
//			response.sendRedirect(url);
//		}
		try {
			userId = user.getUsrId();
			//↓reserveListの生成
			ArrayList<Reserve> reserveList = new ArrayList<Reserve>();//使用するオブジェクトを作成
			for (int i = 1; i < 4; i++) {		//Beansのメソッドを使用しないでください。
				Reserve r = new Reserve();
				r.setRsvId(i);
				r.setUsrId(userId);
				r.setUsrName(user.getUsrName());
				r.setRsvYy(i);
				r.setRsvMm(i);
				r.setRsvDd(i);
				r.setRsvHh(i);
				r.setRsvMi(i);
				r.setPerson(i);
				r.setTableId(i);
				r.setTableName("tablename" + i);
				r.setCourseId(i);
				r.setCourseName("courseName" + i);
				r.setAppDate("appDate");
				r.setAppYy(i);
				r.setAppMm(i);
				r.setAppDd(i);
				r.setAppHh(i);
				r.setAppMi(i);
				reserveList.add(r);
			}
			//↑までがreseveList
			//予約IDで昇順にソート
			java.util.Collections.sort(reserveList, (r1,r2) -> r1.getRsvId() - r2.getRsvId());
			request.setAttribute("reserveList", reserveList);				//予約情報一覧をセット
			url = "reserveList.jsp";										//「予約一覧画面」へ
		} catch (Exception e) {
			request.setAttribute("msg", "exception発生");//表示したいメッセージを独自にセットしてください
			url = "userIndex.jsp";											//「顧客処理選択画面」へ
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
