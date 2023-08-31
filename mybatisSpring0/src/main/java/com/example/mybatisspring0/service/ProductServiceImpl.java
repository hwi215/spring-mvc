package com.example.mybatisspring0.service;


import com.example.mybatisspring0.dao.ProductDAO;
import com.example.mybatisspring0.dto.ProductDTO;
import com.example.mybatisspring0.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //����
public class ProductServiceImpl implements ProductService {
	
	@Autowired //����
	private ProductDAO productDAO;
	
	@Override
	public int insert(ProductDTO productDTO) {
		int result = 0;
		try {
		  result = productDAO.insert(productDTO);
		}catch (Exception e) {
			//e.printStackTrace();
			throw new MyException("��Ͽ� ���ܰ� �߻��߽��ϴ�.");
		}
		
		return result;
	}

	@Override
	public List<ProductDTO> selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		return productDAO.selectByKeyWord(keyField, keyWord);
	}

	@Override
	public List<ProductDTO> selectOrder(String columnName) {
		return productDAO.selectOrder(columnName);
	}

	@Override
	public int update(ProductDTO productDTO) {
		return productDAO.update(productDTO);
	}

	@Override
	public int delete(String code) {
		int result = productDAO.delete(code);
		if (result==0)throw new MyException(code+"�� �ش��ϴ� ������ ���� �Ҽ� �����ϴ�.");
		return result;
	}

	@Override
	public int selectSumQty() {
		return productDAO.selectSumQty();
	}

}
