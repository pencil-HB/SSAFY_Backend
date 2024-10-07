package com.ssafy.test.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Product;
import com.ssafy.test.model.dao.ProductDao;
import com.ssafy.test.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao dao = new ProductDaoImpl();
	
	@Override
	public List<Product> selectAll() throws SQLException {
		
		return dao.selectAll();
	}

	@Override
	public Product selectByCode(String code) throws SQLException {
		return dao.selectByCode(code);
	}

	@Override
	public int insert(Product product) throws SQLException {
		return dao.insert(product);
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		return dao.deleteByCode(code);
	}

	@Override
	public int update(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
