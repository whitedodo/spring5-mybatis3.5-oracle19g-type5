package com.example.spbatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spbatis.model.CompUsers;

@Component
public class CompUsersDao {
	
	/* 동작 안함1
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
	*/
	
	/* 동작 안함2 */
	@Autowired
	private SqlSession sqlSession;
	/* */
	
    public CompUsersDao() {
    	
    }
    
    // SQL 세션 열기
    public List<CompUsers> selectAddress() {
    	
    	/* 동작 안함2 */
    	return sqlSession.selectList("com.example.spbatis.mapper.allCompUsers");
    	
    	
    	/* 동작 안함1
    	SqlSession session = sqlSessionFactory.openSession();
	    try 
	    {
	    	return session.selectList("com.example.spbatis.mapper.allCompUsers");
	    }
	    finally
	    {
	        session.close();
	    }
	    */
    	// return null;

    }
    
}
