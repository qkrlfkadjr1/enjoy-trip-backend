package com.enjoytrip.address.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.address.dto.Gugun;
import com.enjoytrip.address.dto.Sido;
import com.enjoytrip.address.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/address")
@CrossOrigin("http://localhost:5173/")
public class AddressController {
    
	private AddressService addressService;
	
    public AddressController(AddressService addressService) {
    	this.addressService = addressService;
    }


    @GetMapping("/getSido")
	private ResponseEntity<?> getSido() {
		try {
			List<Sido> sidos = addressService.findByAll();
			return ResponseEntity.status(HttpStatus.OK).body(sidos);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/getGugun/{sidoCode}")
	private ResponseEntity<?> getGugun(@PathVariable("sidoCode") int sidocode) {
		System.out.println("반응");
		try {
			List<Gugun> guguns = addressService.findBySidoCode(sidocode);
			return ResponseEntity.status(HttpStatus.OK).body(guguns);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
