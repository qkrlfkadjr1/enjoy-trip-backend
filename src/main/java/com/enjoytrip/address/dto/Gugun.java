package com.enjoytrip.address.dto;

public class Gugun {
	private int gugunCode;
	private String gugunName;
	
	public Gugun() {
	}

	public Gugun(int gugunCode, String gugunName) {
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "Gugun{" +
				"gugunCode=" + gugunCode +
				", gugunName='" + gugunName + '\'' +
				'}';
	}
}
