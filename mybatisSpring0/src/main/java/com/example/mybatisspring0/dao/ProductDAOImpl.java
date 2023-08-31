package com.example.mybatisspring0.dao;

import com.example.mybatisspring0.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //����
public class ProductDAOImpl implements ProductDAO {
	
	public static final String NS = "productMapper.";
	
    @Autowired
	 private SqlSession session; 
	
    @Override
	public int insert(ProductDTO productDTO) {
		return session.insert(NS+"insert", productDTO) ;
	}

	@Override
	public List<ProductDTO> selectAll() {
		return session.selectList(NS+"selectAll");
	}

	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		Map<String, String> map = new HashMap<>();
		map.put("field", keyField);
		map.put("keyword", keyWord);
		
		return session.selectList(NS+"selectByKeyword", map);
	}
	

	@Override
	public List<ProductDTO> selectOrder(String columnName) {
		return session.selectList(NS+"selectByOrder", columnName);
	}

	@Override
	public int update(ProductDTO productDTO) {
		return session.update(NS+"update", productDTO);
	}

	@Override
	public int delete(String code) {
		return session.delete(NS+"delete", code);
	}

	@Override
	public int selectSumQty() {
		return session.selectOne(NS+"selectSumQty");
	}
}
