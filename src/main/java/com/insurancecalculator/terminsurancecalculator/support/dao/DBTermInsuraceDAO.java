package com.insurancecalculator.terminsurancecalculator.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBtermInsurance;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

public class DBTermInsuraceDAO {
	public List<DBtermInsurance> getAllTermInsurance(){
		Connection conn;
		PreparedStatement pst;
		try {
			List<DBtermInsurance> termInsuranceList = new ArrayList<DBtermInsurance>();
			conn = DBUtility.getConnection();
			pst = conn.prepareStatement("select * from terminsurance");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				DBtermInsurance termInsurance = new DBtermInsurance(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				termInsuranceList.add(termInsurance);
			}
			return termInsuranceList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addAllTermInsurance(DBtermInsurance termInsurance) {
		Connection conn;
		PreparedStatement pst;
		try {
			conn = DBUtility.getConnection();
			pst = conn.prepareStatement("insert into terminsurance(id, name, perCentOfSumAssured) values(?,?,?)");
			pst.setInt(1, termInsurance.getId());
			pst.setString(2, termInsurance.getName());
			pst.setDouble(3, termInsurance.getPerCentOfSumAssured());
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
