package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.CalendarEntity;


public class ScheduleDao {
	public ArrayList<CalendarEntity> findBySchedule(String userid){

		Connection conn = null;
		String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS02;"+
		"databaseName=JavaSystem;user=user01;password=pass;";

		ArrayList<CalendarEntity> list = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			conn = DriverManager.getConnection(connectionUrl);

			String countsql = "select count(*) from ScheduleTable where USER_ID = ?";

			PreparedStatement prcount = conn.prepareStatement(countsql);
			prcount.setString(1, userid);

			ResultSet count = prcount.executeQuery();

			int c = 0;

			if(count.next()){
				c = count.getInt(1);
			}

			String sql = "select Schedule_ID,user_id,Title,Startdate,Enddate from ScheduleTable "
					+ "where USER_ID = ? ";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userid);

			ResultSet resultSet = preparedStatement.executeQuery();

			list = new ArrayList<CalendarEntity>(c);
			while (resultSet.next()) {
				CalendarEntity entity = new CalendarEntity();
				entity.setSchrid(resultSet.getString("Schedule_ID"));
				//String userid = resultSet.getString("USER_ID");
				entity.setTitle(resultSet.getString("Title"));
				entity.setStart(resultSet.getString("Startdate"));
				entity.setEnd(resultSet.getString("Enddate"));
				list.add(entity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
					// TODO: handle exception
				}
			}
		}

		return list;
	}


}
