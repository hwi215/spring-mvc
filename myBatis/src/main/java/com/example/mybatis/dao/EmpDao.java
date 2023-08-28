package com.example.mybatis.dao;

import com.example.mybatis.common.DBManager;
import com.example.mybatis.dto.EmpDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpDao {
    /**
     * 사원이름 검색
     */
    public void selectByEname(){
        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<String> list = session.selectList("EmpMapper.selectName"); // namespace.id
            for(String name:list) {
                System.out.println(name);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }

    public void insert(EmpDto empDto){
        SqlSession session = null;
        boolean state = false;
        try {
            session = DBManager.getSession(); // 세션 얻어오기
            state = session.insert("EmpMapper.insert", empDto) > 0 ? true : false;
            System.out.println("state: " + state);
        }finally {
            DBManager.sessionClose(session, state);
        }


    }

}
