package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.dto.Product;
import com.ssafy.test.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	DBUtil util = DBUtil.getInstance();
	
	@Override
	public List<Product> selectAll() throws SQLException {
		List<Product> list = new ArrayList<>();
		Connection con = util.getConnection();
		String q = "Select * from tproducts";
		PreparedStatement pstat = con.prepareStatement(q);
		
		ResultSet rs = pstat.executeQuery();
		
		while(rs.next()) {
			String code = rs.getString(1);
			String name = rs.getString(2);
			Integer quantity = rs.getInt(3);
			String category = rs.getString(4);
			
			Product np = new Product(code, name, quantity, category);
			
			list.add(np);
		}
		System.out.println(list.size());
		return list;
	}

	@Override
	public Product selectByCode(String code) throws SQLException {
		Connection con = util.getConnection();
		String q = "Select * from tproducts where pcode=?";
		PreparedStatement pstat = con.prepareStatement(q);
		
		pstat.setString(1, code);
		
		ResultSet rs = pstat.executeQuery();
		
		rs.next();
		
		String pcode = rs.getString(1);
		String name = rs.getString(2);
		Integer quantity = rs.getInt(3);
		String category = rs.getString(4);
		
		Product np = new Product(pcode, name, quantity, category);
		
		return np;
	}

	@Override
	public int insert(Product product) throws SQLException {
		Connection con = util.getConnection();
		String q = "Insert into tproducts values(?, ?, ?, ?)";
		
		PreparedStatement pstat = con.prepareStatement(q);
		
		pstat.setString(1, product.getCode());
		pstat.setString(2, product.getName());
		pstat.setInt(3, product.getQuantity());
		pstat.setString(4, product.getCategory());
		
		return pstat.executeUpdate();
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		Connection con = util.getConnection();
		String q = "delete from tproducts where pcode=?";
		
		PreparedStatement pstat = con.prepareStatement(q);
		
		pstat.setString(1, code);
		
		return pstat.executeUpdate();
	}

	@Override
	public int update(Product product) throws SQLException {
//		Connection con = util.getConnection();
//		String q = "update tproducts set ";
//		
//		PreparedStatement pstat = con.prepareStatement(q);
//		
//		pstat.setString(1, code);
//		
//		return pstat.executeUpdate();
		return 0;
	}

}
