package com.example.mybatisspring0.dao;

import com.example.mybatisspring0.dto.ProductDTO;

import java.util.List;


public interface ProductDAO {

	/**
	 * 1.���ڵ� ����
	 * */
	 int insert(ProductDTO productDTO) ;
	
	/**
	 * 2. ��ü�˻�
	 * */
	List<ProductDTO> selectAll() ;
	
	/**
	 * 3. �˻��ʵ� , �˻��ܾ �ش��ϴ� ���ڵ� �˻�
	 * */
	List<ProductDTO> selectByKeyWord(String keyField, String keyWord) ;
	
	/**
	 * 4. ���Ĵ�� �÷��� �μ��� �޾� ����
	 * */
	List<ProductDTO> selectOrder(String columnName) ;
	
	/**
	 * 5. �Ķ���� ���� �޾� ������Ʈ�ϱ�
	 * */
	int update(ProductDTO productDTO);
	
	/**
	 * 6.�����ϱ�
	 * */
	int delete(String code) ;
		
	/**
	 * 7. qty ��ü ���� ���ϱ�
	 * */
	int selectSumQty() ;

}
