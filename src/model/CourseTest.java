package model;

import java.util.ArrayList;

public class CourseTest {

	public static void main(String[] args){
		try {
			ArrayList<Menu> al2 = Menu.getMenuList();
			for(Menu m :al2){
				System.out.println(m.getMenuName());
				System.out.println(m.getDetail());

			}
		} catch (IdealException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

//		ArrayList<Course> al;
//		try {
//			al = Course.getCourseList();
//			for(Course c : al){
//				System.out.println(c.getCourseName());
//				System.out.println(c.getPrice());
//				System.out.println(c.getDetail());
//				System.out.println(c.getMenuName());
//				System.out.println(c.getMenuId());
//			}
//		} catch (IdealException e) {
//			e.printStackTrace();
//		}
	}

}
