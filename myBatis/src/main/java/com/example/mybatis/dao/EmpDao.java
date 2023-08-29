package com.example.mybatis.dao;

import com.example.mybatis.common.DBManager;
import com.example.mybatis.dto.EmpDto;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * sal 적게받는 사원 검색하기
     */
    public void selectLessThanSal(int sal) {
        SqlSession session = null;
        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<EmpDto> list = session.selectList(NS + "selectLessThanSal", sal); // namespace.id
            for(EmpDto dto:list) {
                System.out.println(dto);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }

    /**
     * 급여가 Min ~ Max 검색
     */
    public void selectMinMax(int min, int max) {

        SqlSession session = null;

        Map<String, Integer> map = new HashMap<>();
        map.put("min", min); // mapper쪽에서 #{min}
        map.put("max", max);

        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<EmpDto> list = session.selectList(NS + "selectMinMax", map);
            for(EmpDto dto:list) {
                System.out.println(dto);
            }
        }finally {
            DBManager.sessionClose(session);

        }

    }

    /**
     * 인수로 전달된 컬럼을 기준으로 정렬하기
     */
    public void selectOrder(String empno) {

        SqlSession session = null;

        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<EmpDto> list = session.selectList(NS + "selectByOrder", empno);
            for(EmpDto dto:list) {
                System.out.println(dto);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }

    /**
     * 검색필드와 검색단어 또는 사원번호 또는 급여 해당하는 레코드 검색
     * - map을 이용해 다양한 정보들 넣어 퀴리 쉽게 작성 가능
     */
    public void selectWhereMix(String columnName, String keyWord, int empno, int sal) {

        SqlSession session = null;

        Map<String, Object> map = new HashMap<>();
        map.put("columnName", columnName);
        map.put("keyWord", keyWord);
        map.put("dto", new EmpDto(empno, null, null, sal, null));
        map.put("sal", sal);


        try {
            // 로드 연결 실행 닫기
            session = DBManager.getSession();
            List<EmpDto> list = session.selectList(NS + "selectWhereMix", map);
            for(EmpDto dto:list) {
                System.out.println(dto);
            }
        }finally {
            DBManager.sessionClose(session);

        }
    }
}
