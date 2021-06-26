package week8.week8;


import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public class Week8_6 {
	
	private static String configFile = "/config-sharding.yaml";
//  private static String configFile = "/META-INF/sharding-databases-tables-postgresql.yaml";
//  private static String configFile = "/META-INF/master-slave.yaml";
  
  private static final String MYSQL_CREATE_TABLE =
      "CREATE TABLE IF NOT EXISTS orders_base (order_id int(11) NOT NULL COMMENT 订单id,\r\n" + 
      "  order_sn int(11) DEFAULT NULL COMMENT 订单编号,\r\n" + 
      "  user_id int(11) DEFAULT NULL COMMENT 用户id,\r\n" + 
      "  receiver_name varchar(45) DEFAULT NULL COMMENT 收货人姓名,\r\n" + 
      "  receiver_addr varchar(45) DEFAULT NULL COMMENT 收货地址,\r\n" + 
      "  pay_amt int(11) DEFAULT NULL COMMENT 支付金额,\r\n" + 
      "  pay_method varchar(1) DEFAULT NULL COMMENT 支付方式,\r\n" + 
      "  order_time datetime DEFAULT NULL COMMENT 订单时间,\r\n" + 
      "  shipping_sn int(11) DEFAULT NULL COMMENT 快递单号,\r\n" + 
      "  shipping_amt int(11) DEFAULT NULL COMMENT 运费金额,\r\n" + 
      "  status varchar(1) DEFAULT NULL COMMENT 订单状态,\r\n" + 
      "  order_points int(11) DEFAULT NULL COMMENT 订单积分,\r\n" + 
      "  invoice_title varchar(45) DEFAULT NULL COMMENT 发票抬头,\r\n" + 
      "  create_time datetime DEFAULT NULL COMMENT 创建时间,\r\n" + 
      "  update_time datetime DEFAULT NULL COMMENT 更新时间,\r\n" + 
      "  PRIMARY KEY (order_id),\r\n" + 
      "  UNIQUE KEY order_id_UNIQUE (order_id))";
  

  public static void main(final String[] args) throws SQLException, IOException {
      DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(getFile(configFile));
      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
      initEnvironment(jdbcTemplate);
      process(jdbcTemplate);
  }
  
  private static File getFile(final String fileName) {
      return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
  }
  
  private static void initEnvironment(final JdbcTemplate jdbcTemplate) {
      jdbcTemplate.execute("TRUNCATE TABLE orders_base");
      jdbcTemplate.execute(MYSQL_CREATE_TABLE);
  }
  
  private static void process(final JdbcTemplate jdbcTemplate) {
      TransactionTypeHolder.set(TransactionType.XA);
      System.out.println("############### start commit transaction ################");
      jdbcTemplate.execute(new ConnectionCallback<Object>() {
          @Override
          public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
              connection.setAutoCommit(false);
              int result;
              try {
                  result = doInsert(connection);
                  printData(jdbcTemplate, "----------------- query all before commit ------------------");
                  connection.commit();
                  printData(jdbcTemplate, "----------------- query all after  commit ------------------");
              } catch (final SQLException ex) {
                  connection.rollback();
                  throw ex;
              }
              return result;
          }
      });
      System.out.println("############### start rollback transaction ################");
      TransactionTypeHolder.set(TransactionType.XA);
      jdbcTemplate.execute(new ConnectionCallback<Object>() {
          @Override
          public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
              connection.setAutoCommit(false);
              doInsert(connection);
              connection.rollback();
              printData(jdbcTemplate, "----------------- query all after rollback ------------------");
              return null;
          }
      });
  }
  
  private static int doInsert(final Connection connection) throws SQLException {
      int updateCount = 0;
      String sql = "insert into orders_base values(?,current_timestamp(),?,?,\"收货地址\",1000,\"1\",\"20210617120000\",123456789,25,\"0\",10,\"发票抬头\",current_timestamp(),current_timestamp());";
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
          for (int i = 4; i < 10; i++) {
              preparedStatement.setInt(1, i);
              preparedStatement.setInt(2, i);
              preparedStatement.setString(3, "收货人");
              updateCount += preparedStatement.executeUpdate();
          }
          return updateCount;
      }
  }
  private static void printData(final JdbcTemplate jdbcTemplate, final String title) {
      System.out.println(title);
      List<Map<String, Object>> data = jdbcTemplate.queryForList("SELECT * FROM orders_base");
      if (data.isEmpty()) {
          System.out.println("orders_base is empty");
          return;
      }
      for (Map<String, Object> each : data) {
          System.out.println(each.toString());
      }
  }
}
