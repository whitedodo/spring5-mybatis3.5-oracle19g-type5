package com.example.spbatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.spbatis.model.CompUsers;

@Mapper
public interface CompUsersMapper {
	
	@Select("SELECT * FROM comp_users")
	List<CompUsers> selectAll();
}