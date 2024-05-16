package com.enjoytrip.address.service;

import java.util.List;

import com.enjoytrip.address.dto.Gugun;
import com.enjoytrip.address.dto.Sido;

public interface AddressService {
	List<Sido> findByAll() throws Exception;
	List<Gugun> findBySidoCode(int sidoCode) throws Exception;
}
