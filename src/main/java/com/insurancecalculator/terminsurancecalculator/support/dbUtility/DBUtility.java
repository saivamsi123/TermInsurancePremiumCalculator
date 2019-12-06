package com.insurancecalculator.terminsurancecalculator.support.dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class DBUtility {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/terminsurancecalculator?serverTimezone="
					+ TimeZone.getDefault().getID(), "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
