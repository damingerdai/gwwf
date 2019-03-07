package com.sun.demo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC�����࣬����ʵ����ɾ�Ĳ�
 * 
 * @author daming
 * 
 */
public class JDBCTools {
	/**
	 * ������ݿ������
	 * 
	 * @return ���ݿ�����
	 */
	public static Connection getConnection() {
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		try {
			Properties p = new Properties();
			InputStream in = JDBCTools.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			p.load(in);
			driverClass = p.getProperty("driver");
			jdbcUrl = p.getProperty("jdbcUrl");
			user = p.getProperty("user");
			password = p.getProperty("password");
			Class.forName(driverClass);
			return DriverManager.getConnection(jdbcUrl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �ر����ݿ������
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
	 * �ر����ݿ������
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
	 * �ر����ݿ������
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
	 *  �ύ����
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
	 * �ع�����
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
	 * ��ʼ����
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
}
