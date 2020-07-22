package practice_fw.examples.component.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataInsertController {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String CONNECT_URL = "jdbc:mysql://localhost/work_db?characterEncoding=UTF-8&serverTimezone=JST&autoReconnect=true&useSSL=false";
	private static final String DB_USER_ID = "work_user";
	private static final String DB_USER_PW = "work_password";

	public DataInsertController() {
		super();
	}

	@RequestMapping(value="/data_insert.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String handleRequest(){

		try{
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(CONNECT_URL, DB_USER_ID, DB_USER_PW);

			connection.setAutoCommit(false);
			//// ここから
			// String sql = "insert into t_product(id, name, price) values(?, ?, ?)";
			// try{
			// 	PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// 	preparedStatement.setString(1, "pen");
			// 	preparedStatement.setString(2, "ペン");
			// 	preparedStatement.setInt(3, 100);
			// 	int n = preparedStatement.executeUpdate();
			// 	connection.commit();

			// 	System.out.println("n=" + String.valueOf(n));
			// 	return "success !";
			///ここまで

		//// ここから
		// 		String sql = "update t_product set id=?,name=?,price=? where id=?";

		// try{

		// 	PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// 	preparedStatement.setString(1,"bourbon");
		// 	preparedStatement.setString(2,"ウイスキー");
		// 	preparedStatement.setString(3,"500");
		// 	preparedStatement.setString(4,"pen");
		// 	int n = preparedStatement.executeUpdate();
		// 	connection.commit();

		// 	System.out.println("n=" + String.valueOf(n));
		// 	return "success !";
		// ここまで

			//// ここから
			String sql = "delete from t_product where id=?";

		try{

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,"bourbon");
			int n = preparedStatement.executeUpdate();
			connection.commit();

			System.out.println("n=" + String.valueOf(n));
			return "success !";
			//// ここまで
			}
			catch(SQLException sqle){
				connection.rollback();
				throw sqle;
			}
			finally{
				connection.close();
			}
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			return "failure !";
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return "failure !";
		}
	}
}
