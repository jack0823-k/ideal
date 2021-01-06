package model;

public class IdealException extends Exception{

	//フィールド
	private int errCd;	//エラーコード

	private static final String[] ERR_MSG = {"障害が発生しました。",
											"データベース処理で例外が発生しました。",
											"お客様ID、パスワードを確認してください。",
											"管理者名、パスワードを確認してください。",
											"ご指定された日時に、空席がございませんでした。",
											"予約されているコースなので削除できません。",
											"コースに登録されているメニューなので削除できません。"};

	public static final int ERR_NO_EXCEPTION            = 0;
	public static final int ERR_NO_DB_EXCEPTION         = 1;
	public static final int ERR_NO_NOT_MEMBER_EXCEPTION = 2;
	public static final int ERR_NO_ADMIN_EXCEPTION      = 3;
	public static final int ERR_NO_NOT_VACANCY          = 4;
	public static final int ERR_NO_NOT_RESERV_DELETE    = 5;
	public static final int ERR_NO_NOT_MENU_DELETE      = 6;

	//コンストラクター
	public IdealException(int errCd){
		this.errCd = errCd;
	}

	//メッセージを取得するメソッド
	public String getMsg(){
		return ERR_MSG[errCd];
	}

}