package zrh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class Week5_10 {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/test_demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	
	private final String USER = "root";
	private final String PASSWORD ="password";
	
	private final String SQL_QUERY = "select * from users";
	private final String SQL_INSERT = "insert into users values(?,?)";
	private final String SQL_DELETE = "";
	
	public void init() {
		Connection conn = null;
		Statement stmt = null;
		try {
//			注册驱动
			Class.forName(DRIVER);
//			连接数据库
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_QUERY);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				System.out.println("学生 id:"+id +"--姓名:"+name);
			}
			
			//preparestatment  预编译
			PreparedStatement preStmt = conn.prepareStatement(SQL_INSERT);
			preStmt.setInt(1,3);
			preStmt.setString(2,"marmot");
			preStmt.execute();
			
			preStmt.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.err.println("注册驱动失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("连接数据库失败，请检查地址、用户名和密码");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Week5_10 w510 = new Week5_10();
		w510.init();
	}
	
	
}
