package codes.datas;

import java.util.Calendar;

public class User {

	private String name;
	private String phonNum;
	private int birthYear;
	
//	현재 한국 나이 구하기
	
	
	public int GetKoreanAge(){
		
		Calendar now = Calendar.getInstance();
		
//		현재 나이를 계산해서 리턴
		return now.get(Calendar.YEAR) - this.birthYear +1;
		
	}
	
	
	public String toString() {
		
//		가공된 양식의 String을 이 메소드의 결과로 지정.
//		String.format으로 가공한 문장을 리턴하자.
		
//		아이유(28세) : 010-7777-0000
		
		return String.format("%s(%d)세  : %s", this.name, this.GetKoreanAge(), this.phonNum);
	}
	
	public User(String name, String phonNum, int birthYear) {
		super();
		this.name = name;
		this.phonNum = phonNum;
		this.birthYear = birthYear;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonNum() {
		return phonNum;
	}
	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	
	
}
