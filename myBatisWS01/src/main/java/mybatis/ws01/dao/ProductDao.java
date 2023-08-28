package mybatis.ws01.dao;

import mybatis.ws01.common.DBManager;
import mybatis.ws01.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

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
}
