package com.enjoytrip.user.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.user.dto.UserDto;

@Mapper
public interface UserMapper {
	
	void create(UserDto userDto) throws SQLException;
	
	UserDto findById(String userId) throws SQLException;
	
	void update(UserDto userDto) throws SQLException;
	
	void delete(String userId) throws SQLException;
	
	boolean login(String userId, String userPassword) throws SQLException;	
	
}
