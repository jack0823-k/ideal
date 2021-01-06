package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.Reserve;
import model.TableLoc;
import model.User;

/**
 * Servlet implementation class ReserveOperationSvl
 */
@WebServlet("/TestReserveOperationSvl")
public class TestReserveOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int INSERT = 11;
	public static final int UPDATE = 12;
	public static final int DELETE = 13;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestReserveOperationSvl() {
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
		String url = "";

		// Reserveオブジェクトの各パラメータが入る変数を宣言
		int rsvId;
		int rsvYy;
		int rsvMm;
		int rsvDd;
		int rsvHh;
		int rsvMi;
		int usrId;
		int person;
		int courseId;
		int tableId;

		int mode = 0;

		//↓sessionにuserオブジェクトをセット
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
		session.setAttribute("userInfo", user);
		//↑までがsessionにuserのセット
//		try {
//			mode = Integer.parseInt(request.getParameter("mode"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		usrId = user.getUsrId(); // 念のためセッションから取得
//		try {
//		} catch (Exception e) {
//			request.setAttribute("msgUser", "userIdが取得できていません");
//			usrId = 0;
//			e.printStackTrace();
//		}
		try {
			rsvId = Integer.parseInt(request.getParameter("rsvId"));
		} catch (NumberFormatException e) {
			rsvId = 0;
		}
		try {
			person = Integer.parseInt(request.getParameter("person"));
		} catch (NumberFormatException e) {
			person = 0;
		}
		try {
			courseId = Integer.parseInt(request.getParameter("courseId"));
		} catch (NumberFormatException e) {
			courseId = 0;
		}
		try {
			tableId = Integer.parseInt(request.getParameter("tableId"));
		} catch (NumberFormatException e) {
			tableId = 0;
		}
		try {
			rsvYy = Integer.parseInt(request.getParameter("rsvYy"));
			rsvMm = Integer.parseInt(request.getParameter("rsvMm"));
			rsvDd = Integer.parseInt(request.getParameter("rsvDd"));
			rsvHh = Integer.parseInt(request.getParameter("rsvHh"));
			rsvMi = Integer.parseInt(request.getParameter("rsvMi"));
		} catch (NumberFormatException e) {
			rsvYy = 0;
			rsvMm = 0;
			rsvDd = 0;
			rsvHh = 0;
			rsvMi = 0;
		}
		if (rsvYy == 0) {			//日時が0の場合は現在時刻を設定
			LocalDateTime lo = LocalDateTime.now();
			rsvYy = lo.getYear();
			rsvMm = lo.getMonthValue();
			rsvDd = lo.getDayOfMonth();
			rsvHh = lo.getHour();
			rsvMi = lo.getMinute();
		}
		// 予約情報のオブジェクト生成
		Reserve reserve = new Reserve();
		reserve.setRsvId(rsvId);
		reserve.setRsvYy(rsvYy);
		reserve.setRsvMm(rsvMm);
		reserve.setRsvDd(rsvDd);
		reserve.setRsvHh(rsvHh);
		reserve.setRsvMi(rsvMi);
		reserve.setUsrId(usrId);
		reserve.setPerson(person);
		reserve.setCourseId(courseId);
		reserve.setTableId(tableId);

		// 予約日時の文字列を作成
		String dateStr = "";
//		LocalDateTime lo = LocalDateTime.of(reserve.getAppYy(),
//				reserve.getRsvMm(), reserve.getRsvDd(), reserve.getRsvHh(),
//				reserve.getRsvMi());
//		dateStr = lo.toString().replace("T", " ");
		mode = INSERT;
		switch (mode) {
		case INSERT:
			TableLoc table ;
			request.setAttribute("reserve", reserve);
			url = "reserveInsertCompletion.jsp";
//			try {
//				table = Reserve.insertChk(dateStr, reserve.getPerson());
//				if (table != null) {			//空席があった場合
//					reserve.setTableId(table.getTableId());
//					reserve.setTableName(table.getTableName());
//					reserve = Reserve.insert(reserve);//insertすると予約IDがセットされる
//					rsvId = reserve.getRsvId();		//予約IDの取得
//				}else {
//					request.setAttribute("reserve", reserve);
//					throw new IdealException(IdealException.ERR_NO_NOT_VACANCY);
//				}
//			} catch (IdealException e) {
//				request.setAttribute("msg", e.getMsg());
//				url = "ReserveInsertSvl";
//				e.printStackTrace();
//			}
			break;
		case UPDATE:
			try {
				table = Reserve.updateChk(reserve.getRsvId(),dateStr, reserve.getPerson());
				if (table != null) {			//空席があった場合
					reserve.setTableId(table.getTableId());
					reserve.setTableName(table.getTableName());
					reserve = Reserve.update(reserve);
					request.setAttribute("reserve", reserve);
					url = "ReserveListSvl";				//「予約一覧表示処理(サーブレット)」へ
				}else {
					request.setAttribute("reserve", reserve);
					throw new IdealException(IdealException.ERR_NO_NOT_VACANCY);
				}
			} catch (IdealException e) {
				request.setAttribute("msg", e.getMsg());
				url = "ReserveUpdateSvl";
				e.printStackTrace();
			}
			break;
		case DELETE:
			try {
				Reserve.delete(reserve);
				url = "ReserveListSvl";				//「予約一覧表示処理(サーブレット)」へ
			} catch (IdealException e) {
				request.setAttribute("msg", e.getMsg());
				url = "ReserveDeleteSvl";
				e.printStackTrace();
			}
			break;
		default:
			request.setAttribute("msg", "modeの値が正しくありません。");
			url = "ReserveListSvl";				//「予約一覧表示処理(サーブレット)」へ

			break;
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
