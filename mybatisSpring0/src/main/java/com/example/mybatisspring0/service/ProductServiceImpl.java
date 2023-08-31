package com.example.mybatisspring0.service;


import com.example.mybatisspring0.dao.ProductDAO;
import com.example.mybatisspring0.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mvc.exception.MyException;

import java.util.List;

/**
 * service에서 조건 처리 하기(ex. 예외처리 등)
 */
@Service // 생성
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	/**
	 * 1. 전체검색
	 */
	@Override
	public List<ProductDTO> selectAll() {
		return productDAO.selectAll();
	}

	/**
	 * 2. 등록하기
	 */
	@Override
	public int insert(ProductDTO productDTO) {
		int result = 0;
		try {
			result = productDAO.insert(productDTO);
		}catch (Exception e) {
			//e.printStackTrace();
			throw new MyException("등록에 예외가 발생했습니다.");
		}

		return result;

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
