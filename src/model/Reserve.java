package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Reserve implements Serializable {

	private static final long serialVersionUID = 1L;

	//フィールド
	private int    rsvId;		//予約ID
	private int    usrId;		//顧客ID
	private String usrName;		//顧客名
	private int    rsvYy;		//予約＿年
	private int    rsvMm;		//予約＿月
	private int    rsvDd;		//予約＿日
	private int    rsvHh;		//予約＿時
	private int    rsvMi;		//予約＿分
	private int    person;		//人数
	private int    tableId;		//テーブルID
	private String tableName;	//テーブル名
	private int    courseId;	//コースID
	private String courseName;	//コース名
	private String appDate;		//登録日時 (フォーマットは "yyyy-MM-dd HH:mm:ss")
	private int    appYy;		//登録＿年
	private int    appMm;		//登録＿月
	private int    appDd;		//登録＿日
	private int    appHh;		//登録＿時
	private int    appMi;		//登録＿分

	//コンストラクター
	public Reserve() {
		super();
	}

	//アクセスメソッド
	public int getRsvId() {
		return rsvId;
	}
	public void setRsvId(int rsvId) {
		this.rsvId = rsvId;
	}
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
	public int getRsvYy() {
		return rsvYy;
	}
	public void setRsvYy(int rsvYy) {
		this.rsvYy = rsvYy;
	}
	public int getRsvMm() {
		return rsvMm;
	}
	public void setRsvMm(int rsvMm) {
		this.rsvMm = rsvMm;
	}
	public int getRsvDd() {
		return rsvDd;
	}
	public void setRsvDd(int rsvDd) {
		this.rsvDd = rsvDd;
	}
	public int getRsvHh() {
		return rsvHh;
	}
	public void setRsvHh(int rsvHh) {
		this.rsvHh = rsvHh;
	}
	public int getRsvMi() {
		return rsvMi;
	}
	public void setRsvMi(int rsvMi) {
		this.rsvMi = rsvMi;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public int getAppYy() {
		return appYy;
	}
	public void setAppYy(int appYy) {
		this.appYy = appYy;
	}
	public int getAppMm() {
		return appMm;
	}
	public void setAppMm(int appMm) {
		this.appMm = appMm;
	}
	public int getAppDd() {
		return appDd;
	}
	public void setAppDd(int appDd) {
		this.appDd = appDd;
	}
	public int getAppHh() {
		return appHh;
	}
	public void setAppHh(int appHh) {
		this.appHh = appHh;
	}
	public int getAppMi() {
		return appMi;
	}
	public void setAppMi(int appMi) {
		this.appMi = appMi;
	}

	/**
	 * 予約情報一覧取得処理。<br>
	 * 引数の顧客IDから、該当する予約情報をReserve型オブジェクトのlistで返すメソッド。
	 * 該当する予約情報が1件もない場合は空のArrayListオブジェクトを返す。
	 * @param usrId ユーザーID
	 * @return 予約情報のArrayList
	 * @throws IdealException
	 */
	public static ArrayList<Reserve> getReserveList(int usrId) throws IdealException {
		ArrayList<Reserve> al = new ArrayList<>();
		Reserve r = null;
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
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "SELECT "
						+ "rsv_id, "
						+ "usr_id, "
						+ "usr_name, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%Y'), signed) rsv_y, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%m'), signed) rsv_mo, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%d'), signed) rsv_d, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%H'), signed) rsv_h, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%i'), signed) rsv_mi, "
						+ "person, "
						+ "table_id, "
						+ "table_name, "
						+ "c_id, "
						+ "c_name, "
						+ "DATE_FORMAT(app_date, '%Y-%m-%d %H:%i:%s') app_date_f, "
						+ "CONVERT(DATE_FORMAT(app_date, '%Y'), signed) app_y, "
						+ "CONVERT(DATE_FORMAT(app_date, '%m'), signed) app_mo, "
						+ "CONVERT(DATE_FORMAT(app_date, '%d'), signed) app_d, "
						+ "CONVERT(DATE_FORMAT(app_date, '%H'), signed) app_h, "
						+ "CONVERT(DATE_FORMAT(app_date, '%i'), signed) app_mi "
					+ "FROM reserve "
						+ "INNER JOIN user      USING(usr_id) "
						+ "INNER JOIN table_loc USING(table_id) "
						+ "INNER JOIN course    USING(c_id) "
					+ "WHERE usr_id = ? "
					+ "ORDER BY rsv_id;";
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, usrId);
			//発行
			rs = pst.executeQuery();
			while(rs.next()){
				r = new Reserve();
				//取得した情報をReserve型オブジェクトの各フィールドにセット
				r.setRsvId(rs.getInt("rsv_id"));
				r.setUsrId(rs.getInt("usr_id"));
				r.setUsrName(rs.getString("usr_name"));
				r.setRsvYy(rs.getInt("rsv_y"));
				r.setRsvMm(rs.getInt("rsv_mo"));
				r.setRsvDd(rs.getInt("rsv_d"));
				r.setRsvHh(rs.getInt("rsv_h"));
				r.setRsvMi(rs.getInt("rsv_mi"));
				r.setPerson(rs.getInt("person"));
				r.setTableId(rs.getInt("table_id"));
				r.setTableName(rs.getString("table_name"));
				r.setCourseId(rs.getInt("c_id"));
				r.setCourseName(rs.getString("c_name"));
				r.setAppDate(rs.getString("app_date_f"));
				r.setAppYy(rs.getInt("app_y"));
				r.setAppMm(rs.getInt("app_mo"));
				r.setAppDd(rs.getInt("app_d"));
				r.setAppHh(rs.getInt("app_h"));
				r.setAppMi(rs.getInt("app_mi"));
				//listに追加
				al.add(r);
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
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
		return al;
	}

	/**
	 * 予約情報取得処理。<br>
	 * 引数の予約IDから該当する予約情報をReserve型オブジェクトで返すメソッド。
	 * 該当する予約情報が存在しない場合はnullを返す。
	 * @param rsvId 予約ID
	 * @return 予約情報を持つReserve型オブジェクト（存在しない場合はnull）
	 * @throws IdealException
	 */
	public static Reserve getReserve(int rsvId) throws IdealException {
		Reserve r = null;
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
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "SELECT "
					+ "rsv_id, "
					+ "usr_id, "
					+ "usr_name, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%Y'), signed) rsv_y, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%m'), signed) rsv_mo, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%d'), signed) rsv_d, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%H'), signed) rsv_h, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%i'), signed) rsv_mi, "
					+ "person, "
					+ "table_id, "
					+ "table_name, "
					+ "c_id, "
					+ "c_name, "
					+ "DATE_FORMAT(app_date, '%Y-%m-%d %H:%i:%s') app_date_f, "
					+ "CONVERT(DATE_FORMAT(app_date, '%Y'), signed) app_y, "
					+ "CONVERT(DATE_FORMAT(app_date, '%m'), signed) app_mo, "
					+ "CONVERT(DATE_FORMAT(app_date, '%d'), signed) app_d, "
					+ "CONVERT(DATE_FORMAT(app_date, '%H'), signed) app_h, "
					+ "CONVERT(DATE_FORMAT(app_date, '%i'), signed) app_mi "
				+ "FROM reserve "
					+ "INNER JOIN user      USING(usr_id) "
					+ "INNER JOIN table_loc USING(table_id) "
					+ "INNER JOIN course    USING(c_id) "
				+ "WHERE rsv_id = ?;";
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, rsvId);
			//発行
			rs = pst.executeQuery();
			if(rs.next()){
				r = new Reserve();
				//取得した情報をReserve型オブジェクトの各フィールドにセット
				r.setRsvId(rs.getInt("rsv_id"));
				r.setUsrId(rs.getInt("usr_id"));
				r.setUsrName(rs.getString("usr_name"));
				r.setRsvYy(rs.getInt("rsv_y"));
				r.setRsvMm(rs.getInt("rsv_mo"));
				r.setRsvDd(rs.getInt("rsv_d"));
				r.setRsvHh(rs.getInt("rsv_h"));
				r.setRsvMi(rs.getInt("rsv_mi"));
				r.setPerson(rs.getInt("person"));
				r.setTableId(rs.getInt("table_id"));
				r.setTableName(rs.getString("table_name"));
				r.setCourseId(rs.getInt("c_id"));
				r.setCourseName(rs.getString("c_name"));
				r.setAppDate(rs.getString("app_date_f"));
				r.setAppYy(rs.getInt("app_y"));
				r.setAppMm(rs.getInt("app_mo"));
				r.setAppDd(rs.getInt("app_d"));
				r.setAppHh(rs.getInt("app_h"));
				r.setAppMi(rs.getInt("app_mi"));
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
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
		return r;
	}

	/**
	 * コース予約確認処理。<br>
	 * 引数のコースIDが実行時以降の日時で予約されている場合は、
	 * ERR_NO_NOT_RESERV_DELETEを引数に指定したIdealExceptionをスルーするメソッド。
	 * @param c_id コースID
	 * @throws IdealException
	 */
	public static void reservCourseChk(int c_id) throws IdealException {
		boolean reserved = false;	//予約があるか否か
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
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "SELECT rsv_id "
					+ "FROM reserve "
					+ "WHERE c_id = ? AND rsv_date > NOW();";
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, c_id);
			//発行
			rs = pst.executeQuery();
			//該当する予約情報が存在する場合はreservedをtrueにする
			if(rs.next()){
				reserved = true;
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
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
		//予約が存在する場合はIdealExceptionをスローする
		if(reserved){
			throw new IdealException(IdealException.ERR_NO_NOT_RESERV_DELETE);
		}
	}

	/**
	 * 新規予約確認処理。<br>
	 * 引数の日時と人数から、予約が可能かを確認するメソッド。
	 * 予約可能な座席情報をTableLoc型オブジェクトで返す。
	 * 空いてるテーブルのうち、予約人数と座席数の差が最小で、
	 * かつtable_idが最小となるテーブル情報を優先して返す。
	 * 空席がなく予約不可能な場合はnullを返す。
	 * @param dateStr 予約日時（フォーマットは "uuuu-MM-dd HH:mm"）
	 * @param personNum 予約人数
	 * @return 予約可能なテーブル情報（空席がない場合はnull）
	 * @throws IdealException
	 */
	public static TableLoc insertChk(String dateStr, int personNum) throws IdealException {
		TableLoc tl = null;
		//データベースのtable_locテーブルから座席情報の一覧を取得しmapに格納する
		int minTableId = Integer.MAX_VALUE;		//テーブルIDの最小値
		int maxTableId = Integer.MIN_VALUE;		//テーブルIDの最大値
		//データベースから取得した座席の一覧情報を格納するmapを生成（キーはtableId）
		HashMap<Integer, TableLoc> tableMap = new HashMap<>();
		//データベース接続
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
			sql = "SELECT * FROM table_loc;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				tl = new TableLoc();
				tl.setTableId(rs.getInt("table_id"));
				tl.setTableName(rs.getString("table_name"));
				tl.setMaxCapacity(rs.getInt("max_capacity"));
				//テーブルの座席数が予約人数以上のときのみ、TableLocオブジェクトをmapに追加
				if(tl.getMaxCapacity() >= personNum){
					tableMap.put(tl.getTableId(), tl);
					//テーブルIDの最小値と最大値をminTableIdとmaxTableIdに代入
					if(minTableId > tl.getTableId()){
						minTableId = tl.getTableId();
					}
					if(maxTableId < tl.getTableId()){
						maxTableId = tl.getTableId();
					}
				}
			}
			//クローズ処理
			rs.close();
			pst.close();
			//データベースのreserveテーブルから予約情報を読み込み、空いている座席を探す
			//引数dateStrの書式と一致するDateTimeFormatterを生成
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
			//reserveStart - 予約の開始時間
			LocalDateTime reserveStart = LocalDateTime.parse(dateStr, formatter);
			//reserveEnd - 予約の終了時間（開始時間に2時間59分を足した時間）
			LocalDateTime reserveEnd = reserveStart.plusHours(2).plusMinutes(59);
			//予約しようとする日の予約情報を一覧で取得（rsv_dateのフォーマットはdateStrと同じにする）
			sql = "SELECT "
						+ "rsv_id, "
						+ "DATE_FORMAT(rsv_date, '%Y-%m-%d %H:%i') rsv_date_f, "
						+ "table_id "
					+ "FROM reserve "
					+ "WHERE rsv_date BETWEEN ? AND ?;";
			pst = con.prepareStatement(sql);
			String subDateStr = dateStr.substring(0, 11);
			pst.setString(1, subDateStr + " 00:00:00");
			pst.setString(2, subDateStr + " 23:59:59");
			rs = pst.executeQuery();
			while(rs.next()){
				//reserveStartDB - データベースから取得した、
				//                 すでに登録されている予約の開始時間
				LocalDateTime reserveStartDB = LocalDateTime.parse(rs.getString("rsv_date_f"), formatter);
				//reserveEndDB - データベースから取得した、
				//               すでに登録されている予約の終了時間（開始時間に2時間59分を足した時間）
				LocalDateTime reserveEndDB = reserveStart.plusHours(2).plusMinutes(59);
				//予約しようとする時間が、すでに登録されている予約時間と重なる場合、
				//そのTableLocオブジェクトをtableMapから削除
				if((reserveStart.isEqual(reserveStartDB))
						|| (reserveStart.isBefore(reserveEndDB) && reserveEnd.isAfter(reserveStartDB))){
					tableMap.remove(rs.getInt("table_id"));
				}
			}
		}catch(Exception e){
			System.out.println("発行したSQL:" + sql);
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
		//予約可能な座席情報のTableLocオブジェクトを返す（ない場合はnullを返す）
		//座席数から予約人数を引いた値が最小で、かつtable_idが最小のテーブル情報を優先して返す
		tl = null;
		int difference;							//座席数 - 予約人数
		int minDifference = Integer.MAX_VALUE; 	//座席数 - 予約人数 の最小値
		if(tableMap.size() != 0){
			for(int i = minTableId; i <= maxTableId; i++){
				TableLoc tltmp = tableMap.get(i);	//mapから取り出したTableLocオブジェクトを一時的に保持する
				if(tltmp != null){
					difference = tltmp.getMaxCapacity() - personNum;
					if(difference < minDifference){
						minDifference = difference;
						tl = tltmp;
					}
				}
			}
		}
		return tl;
	}

	/**
	 * 変更予約確認処理。<br>
	 * 引数の日時と人数から、予約の変更が可能かを確認するメソッド。
	 * 変更が可能な場合のみ、予約可能な座席情報をTableLoc型オブジェクトで返す。
	 * 空いてるテーブルのうち、予約人数と座席数の差が最小で、
	 * かつtable_idが最小となるテーブル情報を優先して返す。
	 * 空席がなく変更不可能な場合はnullを返す。
	 * @param rsvId 予約ID
	 * @param dateStr 予約日時（フォーマットは "uuuu-MM-dd HH:mm"）
	 * @param personNum 予約人数
	 * @return 予約可能なテーブル情報（空席がない場合はnull）
	 * @throws IdealException
	 */
	public static TableLoc updateChk(int rsvId, String dateStr, int personNum) throws IdealException {
		TableLoc tl = null;
		//データベースのtable_locテーブルから座席情報の一覧を取得しmapに格納する
		int minTableId = Integer.MAX_VALUE;		//テーブルIDの最小値
		int maxTableId = Integer.MIN_VALUE;		//テーブルIDの最大値
		//データベースから取得した座席の一覧情報を格納するmapを生成（キーはtableId）
		HashMap<Integer, TableLoc> tableMap = new HashMap<>();
		//データベース接続
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
			sql = "SELECT * FROM table_loc;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				tl = new TableLoc();
				tl.setTableId(rs.getInt("table_id"));
				tl.setTableName(rs.getString("table_name"));
				tl.setMaxCapacity(rs.getInt("max_capacity"));
				//テーブルの座席数が予約人数以上のときのみ、TableLocオブジェクトをmapに追加
				if(tl.getMaxCapacity() >= personNum){
					tableMap.put(tl.getTableId(), tl);
					//テーブルIDの最小値と最大値をminTableIdとmaxTableIdに代入
					if(minTableId > tl.getTableId()){
						minTableId = tl.getTableId();
					}
					if(maxTableId < tl.getTableId()){
						maxTableId = tl.getTableId();
					}
				}
			}
			//クローズ処理
			rs.close();
			pst.close();
			//データベースのreserveテーブルから予約情報を読み込み、空いている座席を探す
			//引数dateStrの書式と一致するDateTimeFormatterを生成
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
			//reserveStart - 予約の開始時間
			LocalDateTime reserveStart = LocalDateTime.parse(dateStr, formatter);
			//reserveEnd - 予約の終了時間（開始時間に2時間59分を足した時間）
			LocalDateTime reserveEnd = reserveStart.plusHours(2).plusMinutes(59);
			//予約しようとする日の予約情報を一覧で取得（rsv_dateのフォーマットはdateStrと同じにする）
			sql = "SELECT "
						+ "rsv_id, "
						+ "DATE_FORMAT(rsv_date, '%Y-%m-%d %H:%i') rsv_date_f, "
						+ "table_id "
					+ "FROM reserve "
					+ "WHERE rsv_date BETWEEN ? AND ?;";
			pst = con.prepareStatement(sql);
			String subDateStr = dateStr.substring(0, 11);
			pst.setString(1, subDateStr + " 00:00:00");
			pst.setString(2, subDateStr + " 23:59:59");
			rs = pst.executeQuery();
			while(rs.next()){
				//自予約情報のときは、予約済みとは判定しない
				if(rsvId == rs.getInt("rsv_id")){
					continue;
				}
				//reserveStartDB - データベースから取得した、
				//                 すでに登録されている予約の開始時間
				LocalDateTime reserveStartDB = LocalDateTime.parse(rs.getString("rsv_date_f"), formatter);
				//reserveEndDB - データベースから取得した、
				//               すでに登録されている予約の終了時間（開始時間に2時間59分を足した時間）
				LocalDateTime reserveEndDB = reserveStart.plusHours(2).plusMinutes(59);
				//予約しようとする時間が、すでに登録されている予約時間と重なる場合、
				//そのTableLocオブジェクトをtableMapから削除
				if((reserveStart.isEqual(reserveStartDB))
						|| (reserveStart.isBefore(reserveEndDB) && reserveEnd.isAfter(reserveStartDB))){
					tableMap.remove(rs.getInt("table_id"));
				}
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
		//予約可能な座席情報のTableLocオブジェクトを返す（ない場合はnullを返す）
		//座席数から予約人数を引いた値が最小で、かつtable_idが最小のテーブル情報を優先して返す
		tl = null;
		int difference;							//座席数 - 予約人数
		int minDifference = Integer.MAX_VALUE; 	//座席数 - 予約人数 の最小値
		if(tableMap.size() != 0){
			for(int i = minTableId; i <= maxTableId; i++){
				TableLoc tltmp = tableMap.get(i);	//mapから取り出したTableLocオブジェクトを一時的に保持する
				if(tltmp != null){
					difference = tltmp.getMaxCapacity() - personNum;
					if(difference < minDifference){
						minDifference = difference;
						tl = tltmp;
					}
				}
			}
		}
		return tl;
	}

	/**
	 * 予約情報登録処理。<br>
	 * 引数の予約情報をデータベースの予約テーブルに登録するメソッド。
	 * 登録に成功した場合は、登録した予約情報の予約IDのみを格納したReserve型オブジェクトを返す。
	 * 登録に失敗した場合はIdealExceptionをスローする。
	 * @param reserve 予約情報
	 * @return 予約IDのみを持つReserve型オブジェクト
	 * @throws IdealException
	 */
	public static Reserve insert(Reserve reserve) throws IdealException {
		Reserve r = null;
		int n = 0;	//処理件数
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
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "INSERT INTO reserve(usr_id, rsv_date, person, table_id, c_id) "
					+ "VALUES(?, STR_TO_DATE(?, '%Y-%m-%d %H:%i'), ?, ?, ?);";
			pst = con.prepareStatement(sql);
			//各インパラメータに値をセット
			pst.setInt(1, reserve.getUsrId());
			LocalDateTime date = LocalDateTime.of(reserve.getRsvYy(), reserve.getRsvMm(), reserve.getRsvDd(),
					reserve.getRsvHh(), reserve.getRsvMi());
			String rsvDate = date.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm"));
			pst.setString(2, rsvDate);
			pst.setInt(3, reserve.getPerson());
			pst.setInt(4, reserve.getTableId());
			pst.setInt(5, reserve.getCourseId());
			//発行
			n = pst.executeUpdate();
			//クローズ処理
			pst.close();
			//INSERT処理に成功した場合は、登録した予約情報の予約IDを取り出す
			if(n > 0){
				//SQL文とPreparedStatement型オブジェクトを生成
				sql = "SELECT LAST_INSERT_ID() rsv_id;";
				pst = con.prepareStatement(sql);
				//発行
				rs = pst.executeQuery();
				if(rs.next()){
					r = new Reserve();
					r.setRsvId(rs.getInt("rsv_id"));
				}
			}
		}catch(Exception e){
			System.out.println("発行したSQL:" + sql);
			System.out.println("usr_id:" + reserve.getUsrId());
			System.out.println("table_id:" + reserve.getTableId());
			System.out.println("c_id:" + reserve.getCourseId());
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
		return r;
	}

	/**
	 * 予約情報変更処理。<br>
	 * 引数の予約情報から、データベースの予約テーブルの該当レコードを変更するメソッド。
	 * 変更に成功した場合は、変更した予約情報を格納したReserve型オブジェクトを返す。
	 * 変更に失敗した場合はIdealExceptionをスローする。
	 * @param reserve 予約情報
	 * @return 変更後の予約情報
	 * @throws IdealException
	 */
	public static Reserve update(Reserve reserve) throws IdealException {
		Reserve r = null;
		int n = 0;	//処理件数
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
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "UPDATE reserve "
					+ "SET rsv_date = STR_TO_DATE(?, '%Y-%m-%d %H:%i'), person = ?, table_id = ?, c_id = ? "
					+ "WHERE rsv_id = ?;";
			pst = con.prepareStatement(sql);
			//各インパラメータに値をセット
			String rsvDate = reserve.getRsvYy() + "-" + reserve.getRsvMm() + "-" + reserve.getRsvDd()
					+ " " + reserve.getRsvHh() + ":" + reserve.getRsvMi();
			pst.setString(1, rsvDate);
			pst.setInt(2, reserve.getPerson());
			pst.setInt(3, reserve.getTableId());
			pst.setInt(4, reserve.getCourseId());
			pst.setInt(5, reserve.getRsvId());
			//発行
			n = pst.executeUpdate();
			//クローズ処理
			pst.close();
			//UPDATE処理に成功した場合は、登録した予約情報を取り出す
			if(n > 0){
				//SQL文とPreparedStatement型オブジェクトを生成
				sql = "SELECT "
						+ "rsv_id, "
						+ "usr_id, "
						+ "usr_name, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%Y'), signed) rsv_y, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%m'), signed) rsv_mo, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%d'), signed) rsv_d, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%H'), signed) rsv_h, "
						+ "CONVERT(DATE_FORMAT(rsv_date, '%i'), signed) rsv_mi, "
						+ "person, "
						+ "table_id, "
						+ "table_name, "
						+ "c_id, "
						+ "c_name, "
						+ "DATE_FORMAT(app_date, '%Y-%m-%d %H:%i:%s') app_date_f, "
						+ "CONVERT(DATE_FORMAT(app_date, '%Y'), signed) app_y, "
						+ "CONVERT(DATE_FORMAT(app_date, '%m'), signed) app_mo, "
						+ "CONVERT(DATE_FORMAT(app_date, '%d'), signed) app_d, "
						+ "CONVERT(DATE_FORMAT(app_date, '%H'), signed) app_h, "
						+ "CONVERT(DATE_FORMAT(app_date, '%i'), signed) app_mi "
					+ "FROM reserve "
						+ "INNER JOIN user      USING(usr_id) "
						+ "INNER JOIN table_loc USING(table_id) "
						+ "INNER JOIN course    USING(c_id) "
					+ "WHERE rsv_id = ?;";
				pst = con.prepareStatement(sql);
				//インパラメータに値をセット
				pst.setInt(1, reserve.getRsvId());
				//発行
				rs = pst.executeQuery();
				if(rs.next()){
					r = new Reserve();
					//取得した情報をReserve型オブジェクトの各フィールドにセット
					r.setRsvId(rs.getInt("rsv_id"));
					r.setUsrId(rs.getInt("usr_id"));
					r.setUsrName(rs.getString("usr_name"));
					r.setRsvYy(rs.getInt("rsv_y"));
					r.setRsvMm(rs.getInt("rsv_mo"));
					r.setRsvDd(rs.getInt("rsv_d"));
					r.setRsvHh(rs.getInt("rsv_h"));
					r.setRsvMi(rs.getInt("rsv_mi"));
					r.setPerson(rs.getInt("person"));
					r.setTableId(rs.getInt("table_id"));
					r.setTableName(rs.getString("table_name"));
					r.setCourseId(rs.getInt("c_id"));
					r.setCourseName(rs.getString("c_name"));
					r.setAppDate(rs.getString("app_date_f"));
					r.setAppYy(rs.getInt("app_y"));
					r.setAppMm(rs.getInt("app_mo"));
					r.setAppDd(rs.getInt("app_d"));
					r.setAppHh(rs.getInt("app_h"));
					r.setAppMi(rs.getInt("app_mi"));
				}
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
		return r;
	}

	/**
	 * 予約情報削除処理。<br>
	 * 引数の予約情報から、データベースの予約テーブルの該当レコードを削除するメソッド。
	 * 削除に失敗した場合はIdealExceptionをスローする。
	 * @param reserve 削除したい予約情報
	 * @throws IdealException
	 */
	public static void delete(Reserve reserve) throws IdealException {
		//データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try{
			//データベース接続
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			//SQL文とPreparedStatement型オブジェクトを生成
			sql = "DELETE FROM reserve WHERE rsv_id = ?;";
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, reserve.getRsvId());
			//SQL文を発行
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			try{
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
	}

	/**
	 * 日別予約情報一覧取得処理。<br>
	 * 引数の年月日情報から、その日の予約情報のリストを返すメソッド。
	 * 該当する予約情報が存在しない場合は空のArrayListを返す。
	 * @param dateStr 年月日情報（フォーマットは"uuuu-MM-dd"）
	 * @return 予約情報のリスト
	 * @throws IdealException
	 */
	public static ArrayList<Reserve> getReserveDailyList(String dateStr) throws IdealException {
		ArrayList<Reserve> rlist = new ArrayList<>();
		Reserve r = null;
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
			sql = "SELECT "
					+ "rsv_id, "
					+ "usr_id, "
					+ "usr_name, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%Y'), signed) rsv_y, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%m'), signed) rsv_mo, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%d'), signed) rsv_d, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%H'), signed) rsv_h, "
					+ "CONVERT(DATE_FORMAT(rsv_date, '%i'), signed) rsv_mi, "
					+ "person, "
					+ "table_id, "
					+ "table_name, "
					+ "c_id, "
					+ "c_name, "
					+ "DATE_FORMAT(app_date, '%Y-%m-%d %H:%i:%s') app_date_f, "
					+ "CONVERT(DATE_FORMAT(app_date, '%Y'), signed) app_y, "
					+ "CONVERT(DATE_FORMAT(app_date, '%m'), signed) app_mo, "
					+ "CONVERT(DATE_FORMAT(app_date, '%d'), signed) app_d, "
					+ "CONVERT(DATE_FORMAT(app_date, '%H'), signed) app_h, "
					+ "CONVERT(DATE_FORMAT(app_date, '%i'), signed) app_mi "
				+ "FROM reserve "
					+ "INNER JOIN user      USING(usr_id) "
					+ "INNER JOIN table_loc USING(table_id) "
					+ "LEFT  JOIN course    USING(c_id) "
				+ "WHERE rsv_date BETWEEN ? AND ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, dateStr + " 00:00:00");
			pst.setString(2, dateStr + " 23:59:59");
			rs = pst.executeQuery();
			while(rs.next()){
				r = new Reserve();
				//取得した情報をReserve型オブジェクトの各フィールドにセット
				r.setRsvId(rs.getInt("rsv_id"));
				r.setUsrId(rs.getInt("usr_id"));
				r.setUsrName(rs.getString("usr_name"));
				r.setRsvYy(rs.getInt("rsv_y"));
				r.setRsvMm(rs.getInt("rsv_mo"));
				r.setRsvDd(rs.getInt("rsv_d"));
				r.setRsvHh(rs.getInt("rsv_h"));
				r.setRsvMi(rs.getInt("rsv_mi"));
				r.setPerson(rs.getInt("person"));
				r.setTableId(rs.getInt("table_id"));
				r.setTableName(rs.getString("table_name"));
				r.setCourseId(rs.getInt("c_id"));
				r.setCourseName(rs.getString("c_name"));
				if(r.getCourseName() == null){
					r.setCourseName("※削除されたコース");
				}
				r.setAppDate(rs.getString("app_date_f"));
				r.setAppYy(rs.getInt("app_y"));
				r.setAppMm(rs.getInt("app_mo"));
				r.setAppDd(rs.getInt("app_d"));
				r.setAppHh(rs.getInt("app_h"));
				r.setAppMi(rs.getInt("app_mi"));
				//listに追加
				rlist.add(r);
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
		return rlist;
	}

}