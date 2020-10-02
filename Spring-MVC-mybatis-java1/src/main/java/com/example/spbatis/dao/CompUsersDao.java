package com.example.spbatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spbatis.db.SqlMapSessionFactory;
import com.example.spbatis.mapper.CompUsersMapper;
import com.example.spbatis.model.CompUsers;


public class CompUsersDao {

    SqlSessionFactory factory = SqlMapSessionFactory.getSqlSessionFactory();
    
    public CompUsersDao() {
        
    }
    
    // SQL 세션 열기
    public List<CompUsers> selectAddress() {

    	List<CompUsers> user = null;
		try (SqlSession session = factory.openSession()) {
			CompUsersMapper mapper = session.getMapper(CompUsersMapper.class);
			user = mapper.selectAll();
			// System.out.println("계정명:" + user.getUsername());

		}
		
		return user;

    }
    
}
