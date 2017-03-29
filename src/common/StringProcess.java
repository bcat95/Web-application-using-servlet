package common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * className
 *
 * Version 1.0
 *
 * Date: 7-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 7-3-2017         DonNA            Create
 */

public class StringProcess {
	
	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if("0".equals(val)){
			return "Nữ";
		}
		return "Nam";
	}
	
	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if(s==null) return "";
		return s;
	}
	/**
	 * Ham kiem tra
	 * @param item
	 * @return boolean
	 */
	public static boolean notNull(String item)
	{
		return item != null && !item.equals("");
	}
	public static boolean equals(String item, String value)
	{
		return item != null && item.equals(value);
	}
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s){
		if(notVaild(s)) return true;
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return false;
		return true;
	}
	/**
	 * Ham kiem tra xem truong nha co trong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean checkRong(String str){
		if("".equals(str) || str == null || str.length() == 0)
			return true;
		return false;
	}
	private static SimpleDateFormat sdf;
	public static SimpleDateFormat getSdf()
	{
		if(sdf == null)
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf;
	}
	/**
	 * Ham lay ngay hien tai
	 * @param s
	 * @return Date
	 */
	public static Date getNgayDangDate() 
	{
		Date date=new Date();
		String str= getSdf().format(date);
		
		Date currentDate=null;
		try {
			currentDate = getSdf().parse(str);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}
	/**
	 * Ham kiem tra xem xau co ky tu dac biet hay khong
	 * @param s
	 * @return boolean
	 */
	public boolean notDB(String s){
		String r = "^[a-zA-Z0-9]*$";
		if(s.matches(r)) return false;
		return true;
	}
	/**
	 * Ham kiem tra xem xau co phai mail hay ko
	 * @param s
	 * @return boolean
	 */
	public static boolean notEmail(String s){
		String r = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(s.matches(r)) return false;
		return true;
	}
	/**
	 * Ham kiem tra so dien thoai
	 * @param s
	 * @return boolean
	 */
	public boolean notSDT(String s){
		String r = "^(\\+84|0)[0-9]*$";
		if(s.matches(r) && (s.length() == 10 || s.length() == 11)) return false;
		return true;
	}

}

