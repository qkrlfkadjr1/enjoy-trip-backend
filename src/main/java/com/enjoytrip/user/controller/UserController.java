package com.enjoytrip.user.controller;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enjoytrip.user.dto.UserDto;
import com.enjoytrip.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:5173/")
@Slf4j
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	private ResponseEntity<?> create(@RequestBody UserDto userDto) {
		log.info("creat() 메서드 실행");
		log.info("{}",userDto);
		try {
			userService.create(userDto);
			return ResponseEntity.status(HttpStatus.OK).body(userDto);
		} catch (SQLException e) {
			return exceptionHandler(e);
		}

	}

	@GetMapping("{userId}")
	private ResponseEntity<?> findById(@PathVariable("userId") String userId) {

		try {
			UserDto userDto = userService.findById(userId);
			return ResponseEntity.status(HttpStatus.OK).body(userDto);
		} catch (SQLException e) {
			return exceptionHandler(e);
		}

	}

	@PatchMapping("{userId}")
	private ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable("userId") String userId) {

		try {
			userService.update(userDto);
			return ResponseEntity.status(HttpStatus.OK).body(userDto);
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}

	@DeleteMapping("{userId}")
	private ResponseEntity<?> delete(@PathVariable("userId") String userId) {

		try {
			userService.delete(userId);
			return ResponseEntity.status(HttpStatus.OK).body("회원 삭제");
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}

	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody UserDto userDto) {

		try {

			boolean login = userService.login(userDto.getUserId(), userDto.getUserPassword());
			if (login) {
				return ResponseEntity.status(HttpStatus.OK).body("로그인 성공");
			}
			return ResponseEntity.status(HttpStatus.OK).body("로그인 실패");
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}

	@PostMapping("/logout")
	private ResponseEntity<?> signOut() {
		return ResponseEntity.status(HttpStatus.OK).body("로그 아웃");
	}

	private ResponseEntity<?> exceptionHandler(SQLException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}
