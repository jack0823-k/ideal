package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Admin {
	//フィールド
	private String admName;
	private String password;
	private String exp;

	//アクセスメソッド
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}

	//引数なしのコンストラクター
	public Admin(){
	super();
	}

	//管理者ログイン処理
	public static Admin login(String admName, String password) throws IdealException{
			Admin a = null;
			//データベース接続用の変数を宣言
			InitialContext ic = null;
			DataSource ds = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "";
			try{
				//データベース接続
				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();
				//admName/password が nullでなければSQL文を生成
					sql = "SELECT * FROM admin WHERE adm_name = ? AND password = ? ;";
				//PreparedStatement型オブジェクトを生成
				pst = con.prepareStatement(sql);
				//インパラメータに値をセット
				pst.setString(1, admName);
				pst.setString(2, password);
				//SQL文を発行
				rs = pst.executeQuery();
				if (rs != null) {		//nullチェック
					while(rs.next()){
						//取得した情報をAdmin型オブジェクトの各フィールドにセット
						a = new Admin();
						a.setAdmName(rs.getString("adm_name"));
						a.setPassword(rs.getString("password"));
						a.setExp(rs.getString("exp"));
					}
				}
			}catch(NamingException e){
				e.printStackTrace();
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
			return a;
		}
}

