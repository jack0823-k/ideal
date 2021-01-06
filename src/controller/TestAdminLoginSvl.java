package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.Admin;
import model.IdealException;

/**
 * Servlet implementation class AdminLoginSvl
 */
@WebServlet("/TestAdminLoginSvl")
public class TestAdminLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestAdminLoginSvl() {
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
		String admName = "adm";
		String password = "adm";
		Admin a = null;


		try {
			//データベース接続用の変数を宣言
			InitialContext ic = null;
			DataSource ds = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = null;
			try{
				a = new Admin();
				//データベース接続
				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();
				//admName/password が nullでなければSQL文を生成
				sql = "SELECT * FROM admin WHERE adm_name = ? AND password = ? ;";

				//sql = "SELECT * FROM admin WHERE adm_name = '" + admName + "' AND password = '" + password + "' ;";
				//PreparedStatement型オブジェクトを生成
				pst = con.prepareStatement(sql);
				//インパラメータに値をセット
				pst.setString(1, admName);
				pst.setString(2, password);
				//SQL文を発行
				rs = pst.executeQuery();
				System.out.println("実行したSQL文: " + sql);

				while(rs.next()){
					//取得した情報をAdmin型オブジェクトの各フィールドにセット
					a.setAdmName(rs.getString("adm_name"));
					a.setPassword(rs.getString("password"));
					a.setExp(rs.getString("exp"));
				}
			}catch(NamingException e){
				e.printStackTrace();
				System.out.println("実行したSQL文: " + sql);

				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}catch(SQLException e){
				System.out.println("実行したSQL文: " + sql);
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}finally{
				try{
					if(rs != null){
					rs.close();
					}
					if(pst != null){
					pst.close();
					}
					if(con != null){
					con.close();
					}
				}catch(Exception e){
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
//			ad.setAdmName(admName);
//			ad.setPassword(password);
			if (a != null) {								//ログインできた場合
				session.setAttribute("adminInfo", a);		//セッションにadminInfoとしてセット
				url = "adminIndex.jsp";						//遷移先「管理者処理選択画面」
			}
		} catch (Exception e) {
			request.setAttribute("msg", "exception発生");		//「Admin.loginメソッド」OR「ログインできない場合」のメッセージが入る
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
