package com.example.mybatisspring0.dao;

import com.example.mybatisspring0.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 생성
public class ProductDAOImpl implements ProductDAO {
	
	public static final String NS = "productMapper.";


	@Override
	public List<ProductDTO> selectAll() {
		return null;
	}

	@Override
	public int insert(ProductDTO productDTO) {
		return 0;
	}

	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		return null;
	}

	@Override
	public List<ProductDTO> selectOrder(String columnName) {
		return null;
	}

	@Override
	public int update(ProductDTO productDTO) {
		return 0;
	}

	@Override
	public int delete(String code) {
		return 0;
	}

	@Override
	public int selectSumQty() {
		return 0;
	}
}
