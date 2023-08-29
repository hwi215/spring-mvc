package mybatis.ws01.main;

import mybatis.ws01.dao.ProductDao;
import mybatis.ws01.dto.ProductDto;

public class ProductMainView {
	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		/**
		 * [1]. 레코드 삽입
		 * */
		System.out.println("********** [1] 상품 등록하기 ******************");
		//dao.insert(new ProductDto("A08", "홈런볼커스타드", 7, 2500, "홈런쳐봐용")); //성공

		/**
		 * [2]. 전체레코드 검색 
		     ex) select * from productList
		 *        
		 * */
		 System.out.println("********** [2] 모든 게시물 검색 ******************");
		 //dao.selectAll(); // 성공

		/**
		 * [3]. 검색필드 , 검색단어에 해당하는 레코드 검색
		     ex) select * from productList where 검색필드 like  검색단어
		 *        
		 * */
		System.out.println("********** [3] 검색필드 , 검색단어에 해당하는 레코드 검색 ******************");
	    //dao.selectByKeyWord("detail", "맛"); //성공

		/**
		 * [4]. 전달된 컬럼을 기반으로 정렬하기 
		     ex)  ex) select * from productList order by 정렬대상
		 *        
		 * */
		System.out.println("********** [4] 전달된 컬럼을 기반으로 정렬하기  ******************");
		//dao.selectOrder("price"); //성공
	
		/**
		 * [5].  parameter 정보에 따라 레코드 수정한다.
		 *     상품코드에 해당하는 상품의 
		 *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정한다.
		 * 
		 * */
		System.out.println("********** [5] 상품 수정하기 ******************");
		//dao.update(new ProductDto("A01", "프링글스", 7	, 10000, "감자칩의 대왕")); // 성공
		
		
		
		/**
		 * [6].상품코드에 해당하는 레코드 삭제
		 * */
		 System.out.println("********** [6] 상품 삭제하기 ******************");
		 //dao.delete("A08"); // 성공

		/**
		 * [7]. 모든 상품의 개수를 출력한다.

			  select sum(qty) from productList-- 모든상품의 qty의총합계
		 * */
		System.out.println("********** [7] 등록된 총 상품 개수 ******************");
		dao.selectSumQty(); // 성공
	}
}
