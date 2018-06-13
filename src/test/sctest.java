package test;

import Entity.CalendarEntity;
import dao.ScheduleDao;

public class sctest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testFindBysche1();
	}
	public static void testFindBysche1(){

		ScheduleDao schedao = new ScheduleDao();
		CalendarEntity calen = new CalendarEntity();
//		calen = schedao.findBySchedule("izumi");



		CalendarEntity calen2 = new CalendarEntity();
		calen2 = calen;

	}

}
