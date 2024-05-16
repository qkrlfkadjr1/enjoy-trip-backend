package com.enjoytrip.attraction.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoytrip.attraction.dto.AttractionDto;
import com.enjoytrip.attraction.dto.AttractionSearchDto;
import com.enjoytrip.attraction.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	private AttractionMapper mapper;
	
	public AttractionServiceImpl(AttractionMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<AttractionDto> findByCriteria(AttractionSearchDto attractionSearchDto) throws SQLException {
		return mapper.findByCriteria(attractionSearchDto);
	}
	
	@Override
	public AttractionDto findById(String contentId) throws SQLException {
		return mapper.findById(contentId);
	}

	@Override
	public void update(AttractionDto attractionDto) throws SQLException {
		// TODO Auto-generated method stub
		mapper.update(attractionDto);
	}

	@Override
	public void create(AttractionDto attractionDto) throws SQLException {
		// TODO Auto-generated method stub
		mapper.create(attractionDto);
	}
	
	@Override
	public void delete(String contentId) throws SQLException{
		mapper.deleteAttractionDescription(contentId);
		mapper.deleteAttractionInfo(contentId);
	}
}
