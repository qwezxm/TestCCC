package rabbit;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFacy {
	private static final String url = "jdbc:xugu://10.20.73.132:5138/XBRY";
	private static final String  model="XBRY1";
	private static final int checkoutTimeout = 30000;
	private static final int idleConnectionTestPeriod = 30;
	private static final int initialPoolSize = 3;
	private static final int maxIdleTime = 30;
	private static final int  maxPoolSize = 50;
	private static final int  minPoolSize = 2;
	private static final int maxStatements = 200;
	private static final String username = "SYSDBA";
	private static final String password = "SYSDBA";
	
	private volatile static ComboPooledDataSource dataSource;
	public static Connection getDataSource() {
		if (dataSource == null) {
			dataSource = new ComboPooledDataSource();
           
            dataSource.setJdbcUrl(url);
            try {
               dataSource.setDriverClass("com.xugu.cloudjdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataSource.setCheckoutTimeout(checkoutTimeout);
            dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
            dataSource.setInitialPoolSize(initialPoolSize);
            dataSource.setMaxIdleTime(maxIdleTime);
            dataSource.setMaxPoolSize(maxPoolSize);
            dataSource.setMinPoolSize(minPoolSize);
            dataSource.setMaxStatements(maxStatements);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        }
		 Connection connection = null;
	        try {
	            connection = dataSource.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
		}
	   
	
    		
}
