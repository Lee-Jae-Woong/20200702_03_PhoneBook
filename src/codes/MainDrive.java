package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
		
//		Git과 연동해서 전화번호부를 만들 예정

		printMenu();
		
	}
	
	public static void printMenu() {
		
//		메뉴 1, 2, 0번 => 0번을 누르면 프로그램 종료
//		0번을 누를때까지는 무한으로 반복
		
		Scanner myScan = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("******* 전화번호부 *******");
			System.out.println("* 1) 전화번호 추가 등록          *");
			System.out.println("* 2) 전체 전화번호 번호 조회   *");
			System.out.println("* 0) 종료                              *");
			System.out.println("**********************");
			
			System.out.println("메뉴 선택");
			int inputMenu = myScan.nextInt();
			
			
			
			if (inputMenu == 0) {
				
				System.out.println("종료합니다.");
				break;
				
			}
			
			else if (inputMenu == 1) {
//				전화번호 추가 기능 구현 필요
			}
			
			else if (inputMenu == 2) {
//				전화번호 전체 조회 기능
				
			}
				
			else {
//				0, 1, 2외의 값이 들어온 경우 대응
				
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}
		
	}
	
//	전화번호 + 이름 + 생년 정보 저장기능.
	public static void addUserInfoToFile() {
		
//		저장된 데이터를 입력받자
		Scanner myScan = new Scanner(System.in);
		
//		이름(String) => 폰번 (String) => 생년월일 (int) 순서대로 저장
		
		System.out.println("이름 입력 : ");
		
		String name = myScan.nextLine();
				
		System.out.println("전화번호 입력: ");
		String phoneNum = myScan.nextLine();
		
		System.out.println("생년 입력");
		int birthYear = myScan.nextInt();
		
//		변수에 저장한 데이터를 묶어서 파일로 저장.
//		java => 보조기억장치 내보내기 => 파일 출력
		
		
	}
	
}
