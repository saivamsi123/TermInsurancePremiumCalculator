package com.insurancecalculator.terminsurancecalculator.support.dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	protected String url;
	protected String driver;
	protected String userName;	
	protected String password;

	protected Connection connection;

	public DBUtility(String url, String driver, String userName, String password) {
		setUrl(url);
		setDriver(driver);
		setUserName(userName);
		setPassword(password);
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		if (connection == null)
			setConnection(createConnection());
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
