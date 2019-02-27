package com.spring.saisiot.model.dto;

import java.util.Date;

public class visitDto {
	
	private int userno;
    private String visit_ip;
	private Date visit_time;
     
	public visitDto() {
		
	}
     
	public visitDto(int userno, String visit_ip, Date visit_time) {
		this.userno = userno;
		this.visit_ip = visit_ip;
		this.visit_time = visit_time;
	}


	public int getUserno() {
		return userno;
	}


	public void setUserno(int userno) {
		this.userno = userno;
	}


	public String getVisit_ip() {
		return visit_ip;
	}


	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}


	public Date getVisit_time() {
		return visit_time;
	}


	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}


	@Override
	public String toString() {
		return "visitDto [userno=" + userno + ", visit_ip=" + visit_ip + ", visit_time=" + visit_time + "]";
	}
     
}
