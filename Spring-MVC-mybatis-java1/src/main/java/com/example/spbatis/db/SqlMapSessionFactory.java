package com.example.spbatis.db;


import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.example.spbatis.mapper.CompUsersMapper;
import com.example.spbatis.model.CompUsers;

import oracle.jdbc.pool.OracleDataSource;

public class SqlMapSessionFactory {

	private static SqlMapSessionFactory factory = new SqlMapSessionFactory();
	
	private final static String driverName = "oracle.jdbc.driver.OracleDriver";
	private final static String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private final static String userName = "사용자계정";
	private final static String userPassword = "비밀번호";
	
	public static SqlSessionFactory ssf;
	

	public static SqlMapSessionFactory getInstance() {
		return factory;
	}
	
	private SqlMapSessionFactory () {    }
	
	static {
		
		/* 방법1
		DataSource dataSource = getOracleDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(CompUsersMapper.class);
		
		ssf = new SqlSessionFactoryBuilder().build(configuration);
		*/
		
	}
    
    public static SqlSessionFactory getSqlSessionFactory(){
    	

		/* 방법2: 공식 메뉴얼 참고 */
		DataSource dataSource = getOracleDataSource();

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();	// Spring Framework만 지원
		factoryBean.setDataSource(dataSource);
		
		try {
			//쿼리가 정의된 xml 파일들의 위치 지정
			/*
	        factoryBean.setMapperLocations(
	                new PathMatchingResourcePatternResolver().getResources("com/example/spbatis/mapper/*.xml")
	        );
	        */
		    
			ssf = factoryBean.getObject();
			
			// 클래스 등록
			ssf.getConfiguration().addMapper(CompUsersMapper.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	// 방법 1, 방법 2 공통
        return ssf;
    }
    
    /*
	 * Description: 순정 오라클 데이터소스
	 */
    private static DataSource getOracleDataSource(){

    	OracleDataSource oracleDS = null;

    	try {
            oracleDS = new OracleDataSource();
            oracleDS.setURL(dbUrl);
            oracleDS.setUser(userName);
            oracleDS.setPassword(userPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oracleDS;

    }
    
}
