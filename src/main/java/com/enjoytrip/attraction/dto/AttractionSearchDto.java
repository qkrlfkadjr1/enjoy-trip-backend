package com.enjoytrip.attraction.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AttractionSearchDto {
	private int sidoCode;
	private int contentTypeId;
	private String keyword;
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	@Builder
	public AttractionSearchDto(int sidoCode, int contentTypeId, String keyword, BigDecimal latitude,
			BigDecimal longitude) {
		this.sidoCode = sidoCode;
		this.contentTypeId = contentTypeId;
		this.keyword = keyword;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
}
