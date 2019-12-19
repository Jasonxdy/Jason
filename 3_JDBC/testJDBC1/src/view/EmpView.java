package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.EmpController;
import model.vo.EMP;

public class EmpView {
	
	// View 전체에서 공용으로 사용될 Scanner 객체 생성
	private Scanner sc = new Scanner(System.in);
	
	
	// 메인 메뉴
	public void mainMenu() {
		
		// 클라이언트 요청을 DAO에 알맞은 메소드로 전달하고 DB 
		// 처리 결과를 반환받는 역할을 할 Controller 객체 생성
		EmpController controller = new EmpController();
		
		int select = 0; // 메뉴 선택을 위한 변수
		
		do {
			System.out.println("=================================");
			System.out.println("[Main Menu]");
			System.out.println("1. 전체 사원 정보 조회");
			System.out.println("2. 사번으로 사원 정보 조회");
			System.out.println("3. 새로운 사원 정보 추가");
			System.out.println("4. 사번으로 사원 정보 수정");
			System.out.println("5. 사번으로 사원 정보 삭제");
			System.out.println("6. 조회 하고자 하는 급여 범위를 입력받아 해당하는 모든 사원 정보 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("=================================");
			
			System.out.print("메뉴 선택>> ");
			select = sc.nextInt();
			sc.nextLine(); // 스캐너 버퍼에 남아있는 개행문자 제거
			
			switch(select) {
			case 1 : controller.selectAll(); break;
			case 2 : controller.selectEmp(); break;
			case 3 : controller.insertEmp(); break;
			case 4 : controller.updateEmp(); break;
			case 5 : controller.deleteEmp(); break;
			case 6 : selectSalary(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); 
			}
			System.out.println();
			
		} while (select != 0);
	}
	
	// -----------------------------------------------------------------------------
	// sub menu
	
	// 1_15. 전체 사원 정보 출력용 View
	public void selectAll(ArrayList<EMP> empList) {
		System.out.println("사번\t이름\t직책\t\t직속상사\t"
				+ "고용일\t급여\t커미션\t부서번호");
		
		// 향상된 for문으로 empList 출력
		for (EMP emp : empList) {
			System.out.println(emp);
		}
	}
	
	
	// 1_18. Error 메세지 출력용 View
	public void displayError(String msg) {
		System.out.println("서비스 요청 실패 : " + msg);
	}
	
	// 2_3. 사번 입력용 View(2, 4, 5 메뉴에 필요함)
	// 사번 입력은 반복되는 동작으로
	// 별도의 메소드로 추상화하여 사용 -> 코드 길이 감소, 재사용성 증가
	public int selectEmpNo() {
		System.out.print("사번을 입력하세요 : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		
		return empNo;
	}
	
	
	// 2_16. 사원 한 명의 정보를 출력하는 View
	public void selectEMP (EMP emp) {
		System.out.println("사번 : " + emp.getEmpNo());
		System.out.println("이름 : " + emp.geteName());
		System.out.println("직책 : " + emp.getJob());
		System.out.println("직속상사 : " + emp.getMgr());
		System.out.println("고용일 : " + emp.getHireDate());
		System.out.println("급여 : " + emp.getSal());
		System.out.println("커미션 : " + emp.getComm());
		System.out.println("부서번호 : " + emp.getDeptNo());
	}
	
	
	
	
	
	
	// 3_3. 새로운 사원 정보 추가 View
	
	public EMP insertEmp() {
		System.out.println("[새로운 사원 정보 추가]");
		
		System.out.print("사번 : ");
		int empNo = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		System.out.print("이름 : ");
		String eName = sc.nextLine();
		
		System.out.print("직책 : ");
		String job = sc.nextLine();
		
		System.out.print("직속 상사 번호 : ");
		int mgr = sc.nextInt();
		
		
		// HIREDATE는 오늘 날짜 입력  -> DB INSERT시 SYSDATE로 처리 가능
		
		System.out.print("급여 : ");
		int sal = sc.nextInt();

		System.out.print("커미션 : ");
		int comm = sc.nextInt();
		
		System.out.print("부서 번호 : ");
		int deptNo = sc.nextInt();
		sc.nextLine(); // 개행문자
		
		return new EMP(empNo, eName, job, mgr, sal, comm, deptNo);
		
	}
	
	
	// 3_18. DML 구문 성공 메세지 출력 View
	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
	}
	
	
	
	
	
	
	// 4_4. 사원 정보 수정 내용 입력용 View
	public EMP updateEmp() {
		System.out.println("[사원 정보 수정]");
		
		System.out.print("직책 : ");
		String job = sc.nextLine();
		
		System.out.print("직속 상사 번호 : ");
		int mgr = sc.nextInt();
		
		System.out.print("급여 : ");
		int sal = sc.nextInt();

		System.out.print("커미션 : ");
		int comm = sc.nextInt();
		
		System.out.print("부서 번호 : ");
		int deptNo = sc.nextInt();
		sc.nextLine(); // 개행문자
		
		return new EMP(job, mgr, sal, comm, deptNo);
	}
	
	
	
	
	
	
	// 5_4. 사원 정보 삭제 확인 View 
	
	public char deleteEmp() {
		
		System.out.print("정말로 삭제 하시겠습니까? (Y/N) : ");
		char check = sc.nextLine().charAt(0);
		return check;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 조회 하고자 하는 급여 범위를 입력받아 해당하는 모든 사원 조회
	/*
	 * 최저 급여 : 800
	 * 최고 급여 : 1000
	 * (800 이상 1000 이하의 급여를 받는 사원 모두 조회)
	 * 
	 * 사번	이름	직책		직속상사	고용일	급여	커미션	부서번호
	 */
	
	public void selectSalary() {
		
		EmpController controller = new EmpController();
		
		System.out.print("최저 급여 : ");
		int lowSal = sc.nextInt();
		sc.nextLine();
		System.out.print("최고 급여 : ");
		int highSal = sc.nextInt();
		sc.nextLine();
		
		controller.selectSalary(lowSal,highSal);
		
		
		
	}
	
	
}