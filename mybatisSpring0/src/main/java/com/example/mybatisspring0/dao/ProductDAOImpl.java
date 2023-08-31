package com.example.mybatisspring0.dao;

import com.example.mybatisspring0.dto.ProductDTO;
import com.example.mybatisspring0.exception.MyException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository // 생성
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession session;

	public static final String NS = "ProductMapper.";
	/**
	 * 전체 검색
	 */
	@Override
	public List<ProductDTO> selectAll() { // productMapper, selectAll

		return session.selectList(NS + "selectAll");
	}

	/**
	 * 2. 레코드 등록
	 */
	@Override
	public int insert(ProductDTO productDTO) {
		return session.insert(NS + "insert", productDTO);

	}

	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 */
	@Override
	public List<ProductDTO> selectByKeyWord(String keyField, String keyWord) {
		// map에 값 넣어서 전달
		Map<String, String> map = new HashMap<>();
		map.put("field", keyField);
		map.put("keyword", keyWord);
		
		return session.selectList(NS + "selectByKeyWord", map);

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
