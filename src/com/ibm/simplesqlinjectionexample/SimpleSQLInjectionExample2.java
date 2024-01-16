package com.ibm.simplesqlinjectionexample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SimpleSQLInjectionExample2 {

	public static void main(String[] args) throws SQLException {

		if (args != null && args.length > 0) {
			String sql = args[0];

			Connection conn = null;
			try {
				conn = someFactory();
			} catch (Exception ignored) {
				ignored.printStackTrace();
			}
			
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
				stmt.close();
			}
		}

	}

	private static Connection someFactory() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("jdbc/someDB");
		Connection conn = ds.getConnection("someuser", "somepassword");
		return conn;
	}

}
