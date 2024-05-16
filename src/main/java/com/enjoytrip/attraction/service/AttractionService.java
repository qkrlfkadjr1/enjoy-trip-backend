package com.enjoytrip.attraction.service;

import java.sql.SQLException;
import java.util.List;
	
import com.enjoytrip.attraction.dto.AttractionDto;
import com.enjoytrip.attraction.dto.AttractionSearchDto;

public interface AttractionService {
	List<AttractionDto> findByCriteria(AttractionSearchDto attractionSearchDto) throws SQLException;
	AttractionDto findById(String contentId) throws SQLException;
	void create(AttractionDto attractionDto) throws SQLException;
	void update(AttractionDto attractionDto) throws SQLException;
	void delete(String contentId) throws SQLException;
}
