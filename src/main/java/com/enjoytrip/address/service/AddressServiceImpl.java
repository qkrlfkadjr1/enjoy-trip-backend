package com.enjoytrip.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoytrip.address.dto.Gugun;
import com.enjoytrip.address.dto.Sido;
import com.enjoytrip.address.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	private AddressMapper addressDao;
	
	public AddressServiceImpl(AddressMapper addressDao) {
		this.addressDao = addressDao;
	}
	
	@Override
	public List<Sido> findByAll() throws Exception {
		return addressDao.findByAll();
	}

	@Override
	public List<Gugun> findBySidoCode(int sidoCode) throws Exception {
		return addressDao.findBySidoCode(sidoCode);
	}

}
