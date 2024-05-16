package com.enjoytrip.user.service;

import java.sql.SQLException;

import com.enjoytrip.user.dto.UserDto;

public interface UserService {
	void create(UserDto MemberDto) throws SQLException;
	UserDto findById(String userId) throws SQLException;
	void update(UserDto MemberDto) throws SQLException;
	void delete(String userId) throws SQLException;
	boolean login(String userId, String userPassword) throws SQLException;	
}
