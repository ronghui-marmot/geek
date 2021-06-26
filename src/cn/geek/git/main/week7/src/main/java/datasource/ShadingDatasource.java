package datasource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

public class ShadingDatasource {
	
	public static void main(String[] args) {
		File yamlFile = new File("C:\\Users\\rongh\\Desktop\\geek\\src\\cn\\geek\\git\\main\\week7\\src\\main\\resources\\application.yml");
		try {
			DataSource datasource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
			String sql = "SELECT * FROM user_baseinfo";
			
			Connection conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					System.out.println(rs.getString("user_name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
