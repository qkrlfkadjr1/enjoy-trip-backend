package com.enjoytrip.address.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.address.dto.Gugun;
import com.enjoytrip.address.dto.Sido;

@Mapper
public interface AddressMapper {
	List<Sido> findByAll() throws Exception;
	List<Gugun> findBySidoCode(int sidoCode) throws Exception;
}	
