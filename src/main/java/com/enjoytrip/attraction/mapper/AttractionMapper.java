package com.enjoytrip.attraction.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.attraction.dto.AttractionDto;
import com.enjoytrip.attraction.dto.AttractionSearchDto;
import com.enjoytrip.user.dto.UserDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> findByCriteria(AttractionSearchDto attractionSearchDto) throws SQLException;
	AttractionDto findById(String contentId) throws SQLException;
	void create(AttractionDto attractionDto) throws SQLException;
	void update(AttractionDto attractionDto) throws SQLException;
	void deleteAttractionDescription(String contentId) throws SQLException;
	void deleteAttractionInfo(String contentId) throws SQLException;
}
