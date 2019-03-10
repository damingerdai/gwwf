package org.daming.gwwf.utils;

import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类，可以实现增删改查
 * 
 * @author daming
 * 
 */
public class JDBCTools {

	private static HikariDataSource dataSource;

	static {
		init();
	}

	/**
	 * 获得数据库的连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭数据库的连接
	 * 
	 * @param conn
	 */
	public static void release(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭数据库的连接
	 * 
	 * @param st
	 * @param conn
	 */
	public static void release(Statement st, Connection conn) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		release(conn);
	}

	/**
	 * 关闭数据库的连接
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		release(st, conn);
	}

	public static void release(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 *  提交事务
	 * @param conn
	 */
	public static void commit(Connection conn) {
		if (conn != null) {
			try {
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 开始事务
	 * @param conn
	 */
	public static void beginTx(Connection conn) {
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void init() {
		try {
			Properties p = new Properties();
			InputStream in = JDBCTools.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			p.load(in);
			// Class.forName(p.getProperty("driver"));
			dataSource = new HikariDataSource();
			dataSource.setDriverClassName(p.getProperty("driver"));
			dataSource.setJdbcUrl(p.getProperty("jdbcUrl"));
			dataSource.setUsername(p.getProperty("user"));
			dataSource.setPassword(p.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
