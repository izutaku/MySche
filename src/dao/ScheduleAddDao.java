package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleAddDao {
	public Boolean AddSchedule(String userid,String stdate,String title){

		Connection conn = null;
		String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS02;"+
		"databaseName=JavaSystem;user=user01;password=pass;";


		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			conn = DriverManager.getConnection(connectionUrl);

			String sql = "INSERT INTO ScheduleTable (USER_ID,Title,Startdate,Enddate) VALUES(?,?,? ,null)";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, stdate);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
			return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return true;
					// TODO: handle exception
				}
			}
		}

		return true;
	}

}
