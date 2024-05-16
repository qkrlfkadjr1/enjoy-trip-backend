package com.enjoytrip.user.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.enjoytrip.user.dto.UserDto;
import com.enjoytrip.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserMapper userMapper;
	
	public UserServiceImpl (UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void create(UserDto userDto) throws SQLException{
		String encryptPassword = BCrypt.hashpw(userDto.getUserPassword(), BCrypt.gensalt());
		userDto.setUserPassword(encryptPassword);
		userMapper.create(userDto);
	}

	@Override
	public void update(UserDto userDto) throws SQLException{
		String encryptPassword = BCrypt.hashpw(userDto.getUserPassword(), BCrypt.gensalt());
		userDto.setUserPassword(encryptPassword);
		userMapper.update(userDto);
	}

	@Override
	public void delete(String userId) throws SQLException{
		userMapper.delete(userId);
	}


	@Override
	public UserDto findById(String userId) throws SQLException{
		return userMapper.findById(userId);
	}

	@Override
	public boolean login(String userId, String userPassword) throws SQLException{
		UserDto memberDto = userMapper.findById(userId);
		if (BCrypt.checkpw(userPassword, memberDto.getUserPassword())) return true;
		return false;
	}
}
