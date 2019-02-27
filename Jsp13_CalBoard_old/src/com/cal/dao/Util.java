package com.cal.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Util {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	public void setToDates(String mDate) {
		//yyyyMMddhhmm -> 12자리
		//yyyy-MM-dd hh:mm:00
		String m=mDate.substring(0, 4)+"-"
				+mDate.substring(4,6)+"-"
				+mDate.substring(6,8)+" "
				+mDate.substring(8,10)+":"
				+mDate.substring(10)+":00";
		
		//It allows for formatting (date → text), parsing (text → date) , date를 내가 원하는대로 출력하도록
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		// date를 string object로 바꿔준다 : yyyy-mm-dd hh:mm:ss
		Timestamp tm=Timestamp.valueOf(m);	
		// sdf에서 지정해준 포맷으로
		toDates=sdf.format(tm);
	}

	// 한자리수를 두자리수로 변환
	public static String isTwo(String msg) {
		
		
		return (msg.length()<2)?"0"+msg:msg;
		
		/*
		String str="";
		
		if(msg.length()==1) {
			str="0"+msg;
		}else{
			str=msg;
		}
		return str;
		*/
	}
	
}











