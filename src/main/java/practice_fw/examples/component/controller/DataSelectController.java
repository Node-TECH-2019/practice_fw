package practice_fw.examples.component.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataSelectController {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECT_URL = "jdbc:mysql://localhost/work_db?characterEncoding=UTF-8&serverTimezone=JST&autoReconnect=true&useSSL=false";
	private static final String DB_USER_ID = "work_user";
	private static final String DB_USER_PW = "work_password";

	public DataSelectController() {
		super();
	}

	@RequestMapping(value="/data_select.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String handleRequest(){
		try{
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(CONNECT_URL, DB_USER_ID, DB_USER_PW);

			String sql = "select id, name, price from t_product where id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,"pen");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				System.out.println(id + "> " + name + "=" + String.valueOf(price));
			}
			connection.close();
			return "success !";
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			return "failure !上";
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return "failure !下";
		}
	}
}
