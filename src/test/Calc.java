package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calc {
	
	/** 시간문자열(24:00)와 기준숫자(분단위)를 
	 * 	더한 값을 출력 날짜 24시가 넘으면 내일로 문자열출력 (2019-12-11 01:00:05) // hour은 0~12
	 * */
	
	@SuppressWarnings("deprecation")
	public static String calcNextMinute(String time, int minute) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date d = new Date();
		d.setHours(Integer.parseInt(time.substring(0,2)));
		d.setMinutes(Integer.parseInt(time.substring(3,5))+minute);
		
		Calendar c = Calendar.getInstance();
		
		result = sdf.format(d);
		String sub1 = result.substring(11,13);
		String sub2 = result.substring(14,16);
		
		if(Integer.parseInt(sub1+sub2) > 1259) {
			result = result + " PM";
			
			String oldS = sub1 + ":";
			String newS = "";
			int i = Integer.parseInt(sub1);
			int j = i-12;
			if(j<10) {
				newS = "0" + j + ":";
			}else {
				newS = j + ":";
			}
			result = result.replace(oldS, newS);
		}else {
			result = result + " AM";
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(calcNextMinute("22:00", 90));
		System.out.println(calcNextMinute("23:00", 90));
		System.out.println(calcNextMinute("24:00", 90));
		System.out.println(calcNextMinute("13:00", 90));
		System.out.println(calcNextMinute("15:00", 90));
		System.out.println(calcNextMinute("17:00", 90));
		System.out.println(calcNextMinute("19:00", 90));
	}
}