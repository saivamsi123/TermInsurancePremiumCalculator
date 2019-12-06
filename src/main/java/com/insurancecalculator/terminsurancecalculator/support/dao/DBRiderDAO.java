package com.insurancecalculator.terminsurancecalculator.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;
import com.insurancecalculator.terminsurancecalculator.support.entities.Rider;

public class DBRiderDAO {

	public List<DBRider> getAllRiders(){
		Connection conn;
		PreparedStatement pst;
		try {
			List<DBRider> riders = new ArrayList<DBRider>();
			conn = DBUtility.getConnection();
			pst = conn.prepareStatement("select * from rider");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				DBRider rider = new DBRider(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				riders.add(rider);
			}
			return riders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addAllRiders(DBRider dbRider) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = DBUtility.getConnection();
			pst = conn.prepareStatement("insert into rider(id, name, percentOfPremium) values(?,?,?)");
			pst.setInt(1, dbRider.getId());
			pst.setString(2, dbRider.getName());
			pst.setDouble(3, dbRider.getPerCentOfPremium());
			int i = pst.executeUpdate();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
}
