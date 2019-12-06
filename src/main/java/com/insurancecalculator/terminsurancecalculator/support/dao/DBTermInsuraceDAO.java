package com.insurancecalculator.terminsurancecalculator.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBTermInsurance;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

public class DBTermInsuraceDAO {
	public List<DBTermInsurance> getAllTermInsurance() {
		Connection conn;
		PreparedStatement pst;
		try {
			List<DBTermInsurance> termInsuranceList = new ArrayList<DBTermInsurance>();
			conn = DBUtility.getConnection();
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

	public int addAllTermInsurance(DBTermInsurance termInsurance) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = DBUtility.getConnection();
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
}
