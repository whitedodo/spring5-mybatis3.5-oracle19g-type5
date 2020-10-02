package com.example.spbatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spbatis.db.SqlMapSessionFactory;
import com.example.spbatis.model.CompUsers;


public class CompUsersDao {
	
    private SqlMapSessionFactory ssfc;
    private SqlSessionFactory factory;
    
    public CompUsersDao() {
    	
        ssfc = new SqlMapSessionFactory();
        factory = ssfc.getSqlSessionFactory();
        
    }
    
    // SQL 세션 열기
    public List<CompUsers> selectAddress() {

        SqlSession session = factory.openSession();

        List<CompUsers> compDTO = session.selectList("com.example.spbatis.mapper.allCompUsers");
        session.close();
        return compDTO;

    }
    
}
