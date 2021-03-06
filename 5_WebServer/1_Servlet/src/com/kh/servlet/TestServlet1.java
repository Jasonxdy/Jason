package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 객체의 직렬화와 연관이 있음 (통로는 작고 객체는 클때 객체를 잘라서 지나가게 하는데 객체 전후를 비교하게 해줌: 그냥 참고만)
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Servlet 초기화 메소드
		System.out.println("init() 메소드 실행 !!");
		
		// init() 메소드가 없을 경우 자동적으로 다음 순서인 service() 메소드 실행
		
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메소드 실행!!");
		doPost(request, response);
		// service() 메소드가 없어도 전송된 방식(GET, POST)를 알아서 따져
		// doGet() 또는 doPost() 호출함.
//		예전에는 get방식, post 방식을 판단해야했는데 요즘엔 그냥 post로 넘기고 get으로 넘겨서 같이 처리해줘도 됨..?ㅋ
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// HttpServletRequest : 웹 브라우저에서 사용자가 요청한 내용을 받아주는 용도 
		// + 각종 클라이언트 정보
		
		// HttpServletResponse : HttpServletRequest 처리한 결과를 다시 클라이언트 웹 브라우저에 보여주기 위한 용도로 사용
		
		String name = request.getParameter("name");
				// input 태그 중 name 속성이 "name"인 요소의 값을 얻어옴.
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		
		// 체크박스 등 복수 개의 정보를 전달 받을 때는 배열로 받아야 함
		String[] foodArr = request.getParameterValues("food");
		
		System.out.println("입력받은 name : " + name);
		System.out.println("입력받은 gender : " + gender);
		System.out.println("입력받은 age : " + age);
		System.out.println("입력받은 city : " + city);
		System.out.println("입력받은 height : " + height);
		System.out.print("입력받은 food : " + Arrays.toString(foodArr));
//		for (String s : foodArr) {
//			System.out.print(s + ", ");
//		}
		
		
		
		
		// 응답(Response) 화면 출력 준비
		
		// 응답 페이지에 사용할 문자 인코딩 지정
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 문자열 (HTML 코드)을 사용자 응답 화면에 출력할 스트림을
		// HttpServletResponse 객체에서 얻어와 응답화면과
		// 해당 Servlet 연결
		PrintWriter out = response.getWriter();
		// 출력 스트림을 얻어와, out이라는 이름으로 사용하겠다
		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"UTF-8\">");
//		out.println("<title>개인 정보 출력 화면</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h2>개인 정보 출력 화면 (GET)</h2>");
//		out.println("</body>");
//		out.println("</html>");
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"ko\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <title>개인 정보 출력 화면</title>\r\n" + 
				"    <style>\r\n" + 
				"        h2 {\r\n" + 
				"            color: red;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        span.name {\r\n" + 
				"            color: orange;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"        span.gender {\r\n" + 
				"            color: yellow; background-color: black;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"        span.age {\r\n" + 
				"            color: green;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"        span.city {\r\n" + 
				"            color: blue;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"        span.height {\r\n" + 
				"            color: navy;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"        span.food {\r\n" + 
				"            color: purple;\r\n" + 
				"            font-weight: bold;\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <h2>개인 정보 입력 결과 (GET)</h2>");
		
		out.printf("    <span class=\"name\">%s</span>님은\r\n" + 
				"    <span class=\"age\">%s</span>이시며,\r\n" + 
				"    <span class=\"city\">%s</span>에 사는\r\n" + 
				"    키 <span class=\"height\">%s</span>cm인\r\n" + 
				"    <span class=\"gender\">%s</span>입니다.<br>\r\n" + 
				"    좋아하는 음식은\r\n" + 
				"    <span class=\"food\">%s</span>입니다.\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>", name, age, city, height, gender, String.join("/", foodArr));
				// String.join() : 배열의 각 요소들을 구분자를 이용해 한 문자열로 합침.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy() 메소드 실행!!");
	}

}
