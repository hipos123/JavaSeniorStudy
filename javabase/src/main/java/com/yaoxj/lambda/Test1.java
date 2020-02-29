package com.yaoxj.lambda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Test1 {
	public static void main(String[] args){
		
		//可变对象和不可变对象
		//====day属于可变对象=============
		Date date=new Date();
		System.out.println("date add year before===="+date);
		date.setYear(date.getYear()+1);
		System.out.println("date add year after===="+date);
		
		
		//String BigDecimal属于不可变对象 LocalDateTime LocalDate
		String test=new String("test123");
		
		BigDecimal b=new BigDecimal("100");
		System.out.println("b===="+b);
		BigDecimal c=b.add(new BigDecimal("200"));
		System.out.println("b===="+b);
		
		LocalDate day=LocalDate.now();
		System.out.println("day===="+day);
		LocalDate day2=day.plusDays(1);
		System.out.println("day2===="+day2);
		LocalDateTime dateTime=LocalDateTime.now();
		try {
		             Thread.sleep(5000);
		       } catch (Exception e) {
			            e.printStackTrace();
	         }
		
		
		LocalDateTime dateTime2=LocalDateTime.now();
		
		System.out.println("dateTime===="+dateTime2.minusSeconds(dateTime.getSecond()).getSecond());
	}

}
