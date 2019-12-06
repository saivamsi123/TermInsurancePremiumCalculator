package com.insurancecalculator.terminsurancecalculator.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.dao.support.Dao;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBTermInsurance;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

public class DBTermInsuraceDAO extends Dao {

	public DBTermInsuraceDAO(DBUtility dbUtility) {
		super(dbUtility);
	}

	public List<DBTermInsurance> getAllTermInsurance() {
		Connection conn;
		PreparedStatement pst;
		try {
			List<DBTermInsurance> termInsuranceList = new ArrayList<DBTermInsurance>();
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("select * from terminsurance");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				DBTermInsurance termInsurance = new DBTermInsurance();
				termInsurance.setId(rs.getInt(1));
				termInsurance.setName(rs.getString(2));
				termInsurance.setPerCentOfSumAssured(rs.getDouble(3));
				termInsuranceList.add(termInsurance);
			}
			return termInsuranceList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DBTermInsurance getTermInsurance(int id) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("select * from terminsurance where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			DBTermInsurance termInsurance = new DBTermInsurance();
			while (rs.next()) {
				termInsurance.setId(rs.getInt(1));
				termInsurance.setName(rs.getString(2));
				termInsurance.setPerCentOfSumAssured(rs.getDouble(3));
			}
			return termInsurance;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addTermInsurance(DBTermInsurance termInsurance) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("insert into terminsurance(id, name, perCentOfSumAssured) values(?,?,?)");
			pst.setInt(1, termInsurance.getId());
			pst.setString(2, termInsurance.getName());
			pst.setDouble(3, termInsurance.getPerCentOfSumAssured());
			return pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public int[] addAllTermInsurance(List<DBTermInsurance> termInsurance) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("insert into terminsurance(name, perCentOfSumAssured) values(?,?)");
			for (DBTermInsurance termInsurancee : termInsurance) {
				pst.setString(1, termInsurancee.getName());
				pst.setDouble(2, termInsurancee.getPerCentOfSumAssured());
				pst.addBatch();
				pst.clearParameters();
			}
			return pst.executeBatch();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new int[] {};
	}
	
	public int updateTermInsurance(DBTermInsurance dbTermInsurance)
	{
		Connection conn;
		PreparedStatement pst;
		try {
			conn = getDbUtility().getConnection();
			pst = conn.prepareStatement("update terminsurance set name=?, perCentOfSumAssured=? where id=?");
			pst.setString(1, dbTermInsurance.getName());
			pst.setDouble(2, dbTermInsurance.getPerCentOfSumAssured());
			pst.setInt(3, dbTermInsurance.getId());
			return pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
