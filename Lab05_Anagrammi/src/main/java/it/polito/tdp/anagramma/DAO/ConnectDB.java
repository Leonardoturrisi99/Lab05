package it.polito.tdp.anagramma.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class DBConnect {
	private static final String jdbcURL="jdbc:mysql://localhost/dizionario";
	private static HikariDataSource ds;
	public static Connection getConnection() {
		if(ds==null) {
			HikariConfig config=new HikariConfig();
			config.setJdbcUrl(jdbcURL);
			config.setUsername("root");
			config.setPassword("root");
			config.addDataSourceProperty("cachePrepStmts", true);
			config.addDataSourceProperty("prepStmtChacheSize", 250);
			config.addDataSourceProperty("prepStmtChacheSqlLimit","2048");
			ds=new HikariDataSource(config);
		}
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Errore di connessione a DB");
			throw new RuntimeException(e);
		}
	}
}