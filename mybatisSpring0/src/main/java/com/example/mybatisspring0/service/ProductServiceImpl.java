package com.example.mybatisspring0.service;


import com.example.mybatisspring0.dao.ProductDAO;
import com.example.mybatisspring0.dto.ProductDTO;
import com.example.mybatisspring0.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 * */
	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		List<ProductDTO> list;
		try{
			list = productDAO.selectByKeyWord(keyField, keyWord);
		}catch (Exception e){
			throw new MyException("조건에 해당하는 레코드를 찾지 못했습니다.");
		}
		return list;
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
