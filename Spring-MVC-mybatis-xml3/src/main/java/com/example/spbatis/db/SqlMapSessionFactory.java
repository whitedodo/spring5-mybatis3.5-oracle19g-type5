package com.example.spbatis.db;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.spbatis.mapper.CompUsersMapper;

public class SqlMapSessionFactory {
	public SqlSessionFactory ssf;
	
	public SqlMapSessionFactory () {

        String resource = "com/example/spbatis/mapper/mybatis-config.xml";
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ssf = new SqlSessionFactoryBuilder().build(is);
        ssf.getConfiguration().addMapper(CompUsersMapper.class);

    }
    
    public SqlSessionFactory getSqlSessionFactory(){
        return ssf;
    }
    
}
