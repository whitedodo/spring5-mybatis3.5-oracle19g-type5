package com.example.spbatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.spbatis.db.SqlMapSessionFactory;
import com.example.spbatis.model.CompUsers;


public class CompUsersDao {

    SqlSessionFactory factory = SqlMapSessionFactory.getSqlSessionFactory();
    
    public CompUsersDao() {
        
    }
    
    // SQL 세션 열기
    public List<CompUsers> selectAddress() {

    	List<CompUsers> user = null;
		try (SqlSession session = factory.openSession()) {
 
			user = session.selectList("com.example.spbatis.mapper.allCompUsers");
			session.close();
			// System.out.println("계정명:" + user.getUsername());

		}
		
		return user;

    }
    
}
