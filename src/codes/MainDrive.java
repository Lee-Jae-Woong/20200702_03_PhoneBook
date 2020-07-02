package codes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
				
//				전화번호 추가 기능 실행
				addUserInfoToFile();
			}
			
			else if (inputMenu == 2) {
//				전화번호 전체 조회 기능
				
				readAllPhoneNum();
			}
				
			else {
//				0, 1, 2외의 값이 들어온 경우 대응
				
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}
		
	}

// 파일에 저장된 전화번호 목록 출력
	
	public static void readAllPhoneNum() {

//	파일에 저장된 데이터를 => 자바 프로그램에 활용 (File Input)
//		File Reader / BufferedReader 활용
		
//		불러올 파일의 위치 지정  => 저장할때 사용하는 파일명과 동일하게.
		
		File file =new File("phoneBook.txt");
		
//		파일을 실제로 불러오는 클래스
		
		try {
			
			FileReader fr = new FileReader(file);
			
			
//			한줄씩 한꺼번에 불러오게 하는 클래스 => fr은 한글자씩. fr을 보조해서 한문장 로드
			BufferedReader br = new BufferedReader(fr);
			
//			모든 연락처를 불러올때까지 반복
			
			while (true) {
//				
//				한줄을 통째로 불러오기
				String line = br.readLine();
				
				
				if(line == null) {
					
//					떠이상 불러올 내용이 없어서 null이 들어옴
//					=> 다 읽었다. => 무한반복 탈출
					
					System.out.println("연락처를 모두 불러왔습니다.");
					break;
					
				}
				
//				이 줄의 코드가 실행된다 : break를 안만났다. => 불러온 내용이 null이 아니다.
				
				System.out.println(line);
				
			}
			
//			while 빠져나옴 : 파일을 다 읽었으니 빠져나왔다. ㅎㅎ
//			파일 사용을 종료. br부터 닫고 fr을 닫자
			
			br.close();
			fr.close();
			
			
			
		} catch (FileNotFoundException e) {
			
//			읽어올 파일이 없는 경우. (삭제 or 아직 안만든 경우)
			
			System.out.println("불러올 파일이 없습니다");
			System.out.println("연락처를 저장하고 다시 시도해주세요.");
			
			
			
//			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("연락처를 읽어오는중에 문제가 발생했다.");
			e.printStackTrace();
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
		
//		어느 파일을 이용할지 파일명 설정
		File phoneBookFile = new File("phoneBook.txt");
		
		try {
			FileWriter fw = new FileWriter(phoneBookFile, true);
			
//			fw는 개발자가 다루기 불편함. => 보조도구 : bw
			
			BufferedWriter bw = new BufferedWriter(fw);
			
//			실제로 bw를 이용해서 연락처 정보 저장.
//			저장내용 : 3가지 정보를 한 줄로 묶어서.
//			ex :  조경진, 010-0000-0000, 2000
			
			String infoStr = String.format("%s, %s, %d", name, phoneNum, birthYear);
			
//			묶인 한 줄을 파일에 기록
			bw.append(infoStr);
//			파일에 기록하고 나면, 줄이 바뀌지 않는다. => System.out.print 처럼 동작
			bw.newLine();
			
//			작업완료=> 열어둔 bw, fw를 닫아주자
			
			bw.close();
			fw.close();
			
			System.out.println("연락처 저장이 완료되었습니다.");
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
