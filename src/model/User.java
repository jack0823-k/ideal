package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class User implements Serializable{
	private static final long  serialVersionUID = 1L;

	//フィールド
	private int usrId;
	private String usrName;
	private String password;
	private String address;
	private String phone;
	private String mail;
	private String exp;

	//アクセスメソッド
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	//引数なしのコンストラクター
	public User(){
	super();
	}

	//顧客ログイン処理
	public static User login(String mail, String password)throws IdealException{
		User u = null;
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql="SELECT usr_id,usr_name,password,address,phone,mail,exp FROM user WHERE mail = ? AND password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, mail);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrName(rs.getString("usr_name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPhone(rs.getString("phone"));
				u.setMail(rs.getString("mail"));
				u.setExp(rs.getString("exp"));
			}

		}catch(Exception e){
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
			if(pst != null){
				try{
					pst.close();
				}catch(Exception e){
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
		}
		return u;
	}

	//顧客情報取得
	public static User getUser(int usrId)throws IdealException{
		User u = null;
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql" );
			con = ds.getConnection();
			sql="SELECT usr_id,usr_name,password,address,phone,mail,exp FROM user WHERE usr_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, usrId);

			rs = pst.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrName(rs.getString("usr_name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPhone(rs.getString("phone"));
				u.setMail(rs.getString("mail"));
				u.setExp(rs.getString("exp"));
			}

		}catch(Exception e){
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}finally{
				//クローズ処理
				if(rs != null){
					try{
						rs.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(pst != null){
					try{
						pst.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
			}
		return u;
	}

	//顧客情報登録処理
	public static User insert(User user)throws IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql="INSERT INTO user VALUES (NULL,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setString(1,user.usrName);
			pst.setString(2,user.password);
			pst.setString(3,user.address);
			pst.setString(4,user.phone);
			pst.setString(5,user.mail);
			pst.setString(6,user.exp);
			pst.executeUpdate();
			}catch(Exception e){
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}finally{
				//クローズ処理
				if(rs != null){
					try{
						rs.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(pst != null){
					try{
						pst.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
			}
		//登録した顧客の顧客IDを取得し呼び大もとに戻す
		User u1 = null;
		InitialContext ic1 = null;
		DataSource ds1 = null;
		Connection con1 = null;
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;
		String sql1 = "";
		try{
			ic1 = new InitialContext();
			ds1 = (DataSource)ic1.lookup("java:comp/env/mysql");
			con1 = ds1.getConnection();
			sql1="SELECT LAST_INSERT_ID() AS last";
			pst1 = con1.prepareStatement(sql1);
			rs1 = pst1.executeQuery();
			while(rs1.next()){
				u1=new User();
				u1.setUsrId(rs1.getInt("last"));
				}
			}catch(Exception e){
				System.out.println("実行したSQL文: " + sql);
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}finally{
				//クローズ処理
				if(rs1 != null){
					try{
						rs1.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(pst1 != null){
					try{
						pst1.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
				if(con1 != null){
					try{
						con1.close();
					}catch(Exception e){
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}
			}
		return u1;
	}

	//顧客情報変更処理
	public static User update(User user)throws IdealException{
		//データベース接続処理
		InitialContext ic = null;
		DataSource ds  = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User u = null;
		String sql ="";
		try{
			ic  = new InitialContext();
			ds  = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

			//SQL文の作成
			sql += "UPDATE";
			sql += " user";
			sql += " SET";
			sql += " usr_id = ?,";
			sql += " usr_name = ?,";
			sql += " password = ?,";
			sql += " address = ?,";
			sql += " phone = ?,";
			sql += " mail = ?";
			sql += " WHERE usr_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUsrId());
			pst.setString(2, user.getUsrName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getMail());
			pst.setInt(7, user.getUsrId());
			pst.executeUpdate();
			pst.close();

			//必要な情報を取る為にSELECT文を発行
			sql = "SELECT * FROM";
			sql += " user";
			sql += " WHERE";
			sql += " usr_id = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUsrId());
			rs = pst.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrName(rs.getString("usr_name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPhone(rs.getString("phone"));
				u.setMail(rs.getString("mail"));
				u.setExp(rs.getString("exp"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
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
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return u;
	}

		//顧客情報削除処理
		public static void delete(User user)throws IdealException{
			//データベース接続用の変数を宣言
			InitialContext ic = null;
			DataSource ds = null;
			Connection con = null;
			PreparedStatement pst = null;
			PreparedStatement pst2 = null;
			ResultSet rs = null;
			String sql = "";
			String sql2 = "";
			try{
				//データベース接続
				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();
				//SQL文を生成
				sql  = "DELETE FROM reserve WHERE usr_id = ?;";
				sql2 = "DELETE FROM user WHERE usr_id = ?;";
				//PreparedStatement型オブジェクトを生成
				pst = con.prepareStatement(sql);
				pst2 = con.prepareStatement(sql2);
				//インパラメータに値をセット
				pst.setInt(1, user.getUsrId());
				pst2.setInt(1, user.getUsrId());
				//SQL文を発行
				 pst.executeUpdate();
				 pst2.executeUpdate();

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
			}
	}

