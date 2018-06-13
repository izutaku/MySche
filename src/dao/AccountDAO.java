package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.AccountEntity;

public class AccountDAO {
	public AccountEntity findByLogin(AccountEntity login){
		Connection conn = null;
		AccountEntity account = null;
		String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS02;"+
		"databaseName=JavaSystem;user=user01;password=pass;";

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			conn = DriverManager.getConnection(connectionUrl);

			String sql = "SELECT USER_ID ,PASS FROM ACCOUNT where USER_ID = ? and PASS = ? ";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, login.getUserId());
			preparedStatement.setString(2, login.getPass());

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				String userId = resultSet.getString("USER_ID");
				String pass = resultSet.getString("PASS");

				account = new AccountEntity(userId, pass);
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
		return account;
	}
}
