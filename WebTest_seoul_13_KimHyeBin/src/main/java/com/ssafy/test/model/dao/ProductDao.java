package com.ssafy.test.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Product;

public interface ProductDao {

	/**
	 * 제품 전체 목록 조회
	 */
	List<Product> selectAll() throws SQLException;
	
	/**
	 * 제품 상세 조회
	 */
	Product selectByCode(String code) throws SQLException;
	
	/**
	 * 제품 정보 추가
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * 제품 정보 삭제
	 */
	int deleteByCode(String code) throws SQLException;

	/**
	 * 제품 정보 수정
	 */
	int update(Product product) throws SQLException;
}
