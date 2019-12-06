package com.insurancecalculator.terminsurancecalculator.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.dao.support.Dao;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

public class DBRiderDAO extends Dao {

	public DBRiderDAO(DBUtility dbUtility) {
		super(dbUtility);
	}

	public List<DBRider> getAllRiders() {
		Connection conn;
		PreparedStatement pst;
		try {
			List<DBRider> riders = new ArrayList<DBRider>();
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("select * from rider");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				DBRider rider = new DBRider();
				rider.setId(rs.getInt(1));
				rider.setName(rs.getString(2));
				rider.setPerCentOfPremium(rs.getDouble(3));
				riders.add(rider);
			}
			return riders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DBRider getRider(int id) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("select * from rider where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			DBRider rider = new DBRider();
			while (rs.next()) {
				rider.setId(rs.getInt(1));
				rider.setName(rs.getString(2));
				rider.setPerCentOfPremium(rs.getDouble(3));
			}
			return rider;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addRider(DBRider dbRider) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("insert into rider(name, percentOfPremium) values(?,?)");
			pst.setString(1, dbRider.getName());
			pst.setDouble(2, dbRider.getPerCentOfPremium());
			return pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public int[] addAllRiders(List<DBRider> dbRider) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("insert into rider(name, percentOfPremium) values(?,?)");
			for (DBRider rider : dbRider) {
				pst.setString(1, rider.getName());
				pst.setDouble(2, rider.getPerCentOfPremium());
				pst.addBatch();
				pst.clearParameters();
			}
			return pst.executeBatch();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new int[] {};
	}
	
	public int updateRider(DBRider dbRider)
	{
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("update rider set name=?, percentOfPremium=? where id=?");
			pst.setString(1, dbRider.getName());
			pst.setDouble(2, dbRider.getPerCentOfPremium());
			pst.setInt(3, dbRider.getId());
			return pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
