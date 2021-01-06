package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataTime_test {
	private int orderFlg;
	private int rsvId;

	public int getRsvId() {
		return rsvId;
	}

	public void setRsvId(int rsvId) {
		this.rsvId = rsvId;
	}

	public int getOrderFlg() {
		return orderFlg;
	}

	public void setOrderFlg(int orderFlg) {
		this.orderFlg = orderFlg;
	}

	@Override
	public String toString() {
		return "DataTime_test [orderFlg=" + orderFlg + ", rsvId=" + rsvId + "]";
	}

	public DataTime_test(int orderFlg, int rsvId) {
		super();
		this.orderFlg = orderFlg;
		this.rsvId = rsvId;
	}

	public static void main(String[] args) {
		int rsvYy;
		int rsvMm;
		int rsvDd;
		int rsvHh;
		int rsvMi;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime lo = LocalDateTime.now();
		rsvYy = lo.getYear();
		rsvMm = lo.getMonthValue();
		rsvDd = lo.getDayOfMonth();
		rsvHh = lo.getHour();
		rsvMi = lo.getMinute();
		int rsvSc = 0;

		LocalDateTime lo2 = LocalDateTime.of(rsvYy,
				rsvMm, rsvDd, rsvHh, rsvMi,rsvSc);
		String str2 = lo2.toString().replace("T", " ");
		String str = "" + rsvYy + rsvMm +  rsvDd + rsvHh + rsvMi + rsvSc;
		System.out.println(str2);
		lo2 = LocalDateTime.parse(str2, formatter);
		System.out.println(formatter.format(lo2));
//		str += rsvDd + rsvHh;

		System.out.println(rsvYy);
		System.out.println(rsvMm);
		System.out.println(str);
		System.out.println(rsvHh);
		System.out.println(rsvMi);
		System.out.println(rsvSc);
		ArrayList<DataTime_test> al = new ArrayList<>();
		al.add(new DataTime_test(1,3));
		al.add(new DataTime_test(0,1));
		al.add(new DataTime_test(1,2));
		//al.removeIf((DataTime_test d) -> d.getOrderFlg() == 0);

		java.util.Collections.sort(al, (d1,d2) -> d1.getRsvId() - d2.getRsvId());

		System.out.println(al);


	}
}
