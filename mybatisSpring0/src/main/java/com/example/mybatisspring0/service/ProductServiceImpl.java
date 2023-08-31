package com.example.mybatisspring0.service;


import com.example.mybatisspring0.dao.ProductDAO;
import com.example.mybatisspring0.dto.ProductDTO;
import com.example.mybatisspring0.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // 생성
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	/**
	 * 전체검색
	 */
	@Override
	public List<ProductDTO> selectAll() {
		productDAO.selectAll();
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
