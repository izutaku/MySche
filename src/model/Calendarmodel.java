package model;

import java.util.ArrayList;

import Entity.CalendarEntity;
import dao.ScheduleAddDao;
import dao.ScheduleDao;
import net.arnx.jsonic.JSON;

public class Calendarmodel {

	public String CalendarSelect(String userid){

		ScheduleDao dao = new ScheduleDao();

		ArrayList<CalendarEntity> en = dao.findBySchedule(userid);

		String jsonmsg = JSON.encode(en);
		return jsonmsg;

	}

	public boolean CalendarAdd(String userid, String stadate,String title){

//		Date date = Date.valueOf(stadate);
		ScheduleAddDao dao = new ScheduleAddDao();
		boolean res = dao.AddSchedule(userid, stadate, title);




		return res;
	}


}
