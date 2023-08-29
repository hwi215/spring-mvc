package mybatis.ws01.dao;

import mybatis.ws01.common.DBManager;
import mybatis.ws01.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductDao {

    private static final String NS = "ProductMapper.";

    /**
     * [1]. 레코드 삽입 - 상품 등록
     * */
    public void insert(ProductDto productDto) {
        SqlSession session = null;
        boolean state = false;
        try{
            session = DBManager.getSession();
            state = session.insert(NS + "insert", productDto) > 0 ? true : false;
            System.out.println(productDto + " 상품 등록완료.");

        }finally {
            DBManager.sessionClose(session, state);

        }


    }

    /**
     * [2]. 전체레코드 검색
     ex) select * from productList
     *
     * */
    public void selectAll() {
        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<ProductDto> list = session.selectList(NS + "selectAll");
            for(ProductDto productDto : list) {
                System.out.println(productDto);
            }
            System.out.println("전체 상품 조회 완료.");
        }finally {
            DBManager.sessionClose(session);

        }
    }

    /**
     * [5].  parameter 정보에 따라 레코드 수정한다.
     *     상품코드에 해당하는 상품의
     *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정한다.
     *
     * */
    public void update(ProductDto productDto) {
        SqlSession session = null;
        boolean state = false;
        try{
            session = DBManager.getSession();
            state = session.insert(NS + "update", productDto) > 0 ? true : false;
            System.out.println(productDto + " 상품 수정완료.");

        }finally {
            DBManager.sessionClose(session, state);

        }
    }

    /**
     * [6].상품코드에 해당하는 레코드 삭제
     * */
    public void delete(String code) {
        SqlSession session = null;
        boolean state = false;
        try{
            session = DBManager.getSession();
            state = session.delete(NS + "delete", code) > 0 ?  true : false;
        }finally {
            DBManager.sessionClose(session, state);
        }
    }

    /**
     * [7]. 모든 상품의 개수를 출력한다.
     select sum(qty) from productList-- 모든상품의 qty의총합계
     * */
    public void selectSumQty() {
        SqlSession session = null;
        int count = 0;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            count = session.selectOne(NS + "selectSumQty");

            System.out.println("모든 상품의 개수: " + count);
        }finally {
            DBManager.sessionClose(session);

        }
    }
}
