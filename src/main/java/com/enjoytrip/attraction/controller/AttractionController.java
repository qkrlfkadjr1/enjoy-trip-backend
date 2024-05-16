package com.enjoytrip.attraction.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.attraction.dto.AttractionDto;
import com.enjoytrip.attraction.dto.AttractionSearchDto;
import com.enjoytrip.attraction.service.AttractionService;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
	private AttractionService service;
	
	public AttractionController(AttractionService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<?> findByCriteria(@ModelAttribute AttractionSearchDto attractionSearchDto) {
		System.out.println(attractionSearchDto);
		try {
			List<AttractionDto> attractions = service.findByCriteria(attractionSearchDto);
			return ResponseEntity.status(HttpStatus.OK).body(attractions);
		} catch (Exception e) {
			System.out.println(attractionSearchDto);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}
	}
	
	@GetMapping("{contentId}")
	public ResponseEntity<?> findById(@ModelAttribute AttractionSearchDto attractionSearchDto, @PathVariable("contentId") String contentId) {
		System.out.println(attractionSearchDto);
		try {
			AttractionDto attraction = service.findById(contentId);
			return ResponseEntity.status(HttpStatus.OK).body(attraction);
		} catch (Exception e) {
			System.out.println(attractionSearchDto);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}
	}
	
	@PostMapping
	private ResponseEntity<?> create(@RequestBody AttractionDto attractionDto) {
		try {
			service.update(attractionDto);
			return ResponseEntity.status(HttpStatus.OK).body(attractionDto);
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}
	
	@PatchMapping("{contentId}")
	private ResponseEntity<?> update(@RequestBody AttractionDto attractionDto, @PathVariable("contentId") String contentId) {
		try {
			service.update(attractionDto);
			return ResponseEntity.status(HttpStatus.OK).body(attractionDto);
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}
	
	@DeleteMapping("{contentId}")
	private ResponseEntity<?> delete(@PathVariable("contentId") String contentId) {
		try {
			service.delete(contentId);
			return ResponseEntity.status(HttpStatus.OK).body("관광지 삭제");
		}
		catch (SQLException e) {
			return exceptionHandler(e);
		}
	}
	
	private ResponseEntity<?> exceptionHandler(SQLException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}
