package com.ktds.board.support;

import javax.servlet.http.HttpServletRequest;

public class Param {
	public static String getStringParam(HttpServletRequest request , String paramName){
		return getStringParam(request, paramName, "");
	}
	
	//오버 로딩
	public static String getStringParam(HttpServletRequest request, String paramName
			, String defaultValue){
		//문자열을 받는다.
		String value = request.getParameter(paramName);
		
		//문자열이 null이면 기본 값 ""을 넣어준다. 
		if(value ==null || value.length() ==0){
			value = defaultValue;
		}
		
		//값을 리턴한다.
		return value;
	}
	
	public static int getIntParam(HttpServletRequest request , String paramName){
		return getIntParam(request, paramName,0);
	}
	
	public static int getIntParam(HttpServletRequest request, String paramName
			, int defaultValue){
		//문자열을 받는다.
		String value = getStringParam(request, paramName);
		
		//value가 문자열이면 NumberFormatException의 위험이 있기 때문에
		//try~catch로 작성한다.
		try {	
			//문자열을 int타입으로 저장하고 값을 리턴한다.
			int intValue = Integer.parseInt(value);
			return intValue;
			
		} catch (NumberFormatException nfe){
			//문자열을 입력받으면 기본값 0을 넣어준다.
			return defaultValue;
		}
	}
}
