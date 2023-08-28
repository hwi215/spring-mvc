package com.example.mybatis.dao;

import com.example.mybatis.common.DBManager;
import com.example.mybatis.dto.EmpDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpDao {

    private static final String NS = "EmpMapper.";
    /**
     * 사원이름 검색
     */
    public void selectByEname(){
        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<String> list = session.selectList(NS + "selectName"); // namespace.id
            for(String name:list) {
                System.out.println(name);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }

    /**
     * 등록하기
     */
    public void insert(EmpDto empDto){
        SqlSession session = null;
        boolean state = false;
        try {
            session = DBManager.getSession(); // 세션 얻어오기
            state = session.insert(NS + "insert", empDto) > 0 ? true : false;
            System.out.println("state: " + state);
        }finally {
            DBManager.sessionClose(session, state);
        }


    }

    /**
     * 삭제하기
     */
    public void delete(int empno) {
        SqlSession session = null;
        boolean state = false;
        try{
            session = DBManager.getSession();
            state = session.delete(NS + "delete", empno) > 0 ?  true : false;
        }finally {
            DBManager.sessionClose(session, state);
        }
    }

    /**
     * 전체 검색하기
     */
    public void selectAll() {
        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<EmpDto> list = session.selectList(NS + "selectAll"); // namespace.id
            for(EmpDto empDto:list) {
                System.out.println(empDto);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }

    /**
     *  사원번호 검색하기
     */
    public void selectByEmpno(int empno) {

        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            EmpDto dto = session.selectOne(NS + "selectByEmpNo", empno);
            System.out.println("dto: " + dto);
        }finally {
            DBManager.sessionClose(session);

        }

    }
}
