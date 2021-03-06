package com.kh.spring.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.common.Pagination;
import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.member.model.vo.Member;
import com.kh.spring.notice.model.service.NoticeService;
import com.kh.spring.notice.model.vo.Notice;

@Controller
@RequestMapping("/notice/*")
@SessionAttributes({"loginMember", "msg", "detailUrl"})
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	
	/*
	 * ModelAndView 객체
	 * - Model : 응답 페이지에 값(data)을 전달할 때 Map 형식으로 저장하여 전달하는 객체
	 * - View : requestDispatcher를 이용한 페이지 이동 시 이동할 페이지의 정보(url)를 담는 객체 // MVC에서의 View와 다름 (이건 views폴더 밑의 사용자가 볼 수 있는 화면을 뜻함)
	 * 
	 * - ModelAndView : 컨트롤러 응답 처리 후 응답할 View와 View에 전달할 값을 저장하는 객체 (model level에서 속성 추가 -> view level에서 페이지 이동)
	 */
	
	
	// 공지사항 목록 출력
	@RequestMapping("list")
	public ModelAndView noticeList(ModelAndView mv,
								@RequestParam(value = "searchKey", required=false) String searchKey,
								@RequestParam(value = "searchValue", required=false) String searchValue,
								@RequestParam(value = "currentPage", required=false) Integer currentPage) { // parameter는 String 타입인데, @RequestParam으로 받아올 때 Wrapper클래스 타입으로 받아오면 형변환되어 넘어옴
		// currentPage
		// searchKey
		// searchValue
		
		try {
			// 검색 조건이 있는지 확인하여 map에 세팅
			Map<String, String> map = null;
			if(searchKey != null && searchValue != null) {
			
				map = new HashMap<String, String>();
				map.put("searchKey", searchKey);
				map.put("searchValue", searchValue);
				
			}
			
			// 1. 전체 공지사항 게시글 수 조회 (페이징 처리를 위해서)
			int listCount = noticeService.getListCount(map);
			
			// 현재 페이지 계산
			if(currentPage == null) currentPage = 1;
			
			// 페이지 정보 저장
			PageInfo pInf = Pagination.getPageInfo(10, 10, currentPage, listCount);
				
			
			// 2. 공지사항 목록 조회
			List<Notice> list = noticeService.selectList(map, pInf);
			
			mv.addObject("list", list);
			mv.addObject("pInf", pInf);
			mv.setViewName("notice/noticeList");
			
			
		} catch (Exception e) {
			// catch에서 ExceptionForward 사용하지 않는 이유 : requestMapping의 경우 받아오는 parameter가 전부 달라서 처리 불가능 (?)
			e.printStackTrace();
			mv.addObject("errorMsg", "공지사항 목록 조회중 오류 발생");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	
// 	---------------------- My version -----------------------------
	
//	// 공지사항 상세 조회
//	@RequestMapping("detail")
//	public ModelAndView noticeDetail(ModelAndView mv, 
//			@RequestParam(value = "searchKey", required=false) String searchKey,
//			@RequestParam(value = "searchValue", required=false) String searchValue,
//			@RequestParam(value = "currentPage", required=false) Integer currentPage,
//			@RequestParam("no") Integer no) {
//		
//		try {
//			
//			int noticeNo = no;
//			
//			Notice notice = noticeService.selectNotice(noticeNo);
//			
//			mv.addObject("notice", notice);
//			
//			mv.setViewName("notice/noticeDetail");
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("errorMsg", "공지사항 상세조회 과정 중 오류 발생");
//			mv.setViewName("common/errorPage");
//		}
//		
//		return mv;
//	}
//	
//	
//	
//	
//	
//	// 공지사항 삭제
//	@RequestMapping("delete")
//	public ModelAndView deleteNotice (ModelAndView mv, @RequestParam("no") Integer no, RedirectAttributes rdAttr) {
//		
//		int noticeNo = no;
//		
//		String msg = null;
//		
//		try {
//			
//			int result = noticeService.deleteNotice(noticeNo);
//			
//			if(result>0) msg = "공지사항 삭제 성공";
//			else		msg = "공지사항 삭제 실패";
//			
//			rdAttr.addFlashAttribute("msg", msg);
//			mv.setViewName("redirect:list");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("errorMsg", "공지사항 삭제 과정 중 오류 발생");
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
//	
//	
//	
//	
//	
//	
//	// 공지사항 수정 화면 이동
//	@RequestMapping("updateForm")
//	public ModelAndView updateForm (ModelAndView mv, @RequestParam("no") Integer no) {
//		
//		int noticeNo = no;
//			
//		try {
//			Notice notice = noticeService.selectNotice(noticeNo);
//			notice.setNoticeContent(notice.getNoticeContent().replace("<br>", "\r\n"));
//			
//			mv.addObject("notice", notice);
//			mv.setViewName("notice/noticeUpdate");
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("errorMsg", "공지사항 수정 조회 과정 중 오류 발생");
//			mv.setViewName("common/errorPage");
//		}
//		
//		mv.setViewName("notice/noticeUpdate");
//		return mv;
//	}
//	
//	
//	
//	// 공지사항 수정
//	@RequestMapping("update")
//	public ModelAndView updateNotice(ModelAndView mv, @RequestParam("no") Integer no, Notice notice, RedirectAttributes rdAttr) {
//		
//		notice.setNoticeNo(no);
//		notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));
//		String msg = null;
//		String path = null;
//		
//		try {
//			
//			int result = noticeService.updateNotice(notice);
//			
//			if(result>0) {
//				msg = "공지사항 수정 성공";
//			}
//			else	{
//				msg = "공지사항 수정 실패";
//			}
//			
//			rdAttr.addFlashAttribute("msg", msg);
//			mv.setViewName("redirect:detail?no=" + no);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("errorMsg", "공지사항 수정 과정 중 오류 발생");
//			mv.setViewName("common/errorPage");
//		}
//		
//		return mv;
//	}
//	
//	
//	
//	
//	
//	
//	// 공지사항 작성 화면 이동 
//	@RequestMapping("insertForm")
//	public ModelAndView insertForm (ModelAndView mv) {
//		mv.setViewName("notice/noticeInsert");
//		return mv;
//	}
//	
//	
//	
//	// 공지사항 작성
//	@RequestMapping("insert")
//	public String insertNotice(Model model, Notice notice, RedirectAttributes rdAttr) {
//		
//		notice.setNoticeWriter(((Member)model.getAttribute("loginMember")).getMemberId());
//		notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));
//		String msg = null;
//		String path = null;
//		
//		try {
//			int result = noticeService.insertNotice(notice);
//			if(result > 0) {
//				msg = "공지사항 등록 성공";
//				path = "redirect:/notice/detail?no=" + result;
//			}
//			else {
//				msg = "공지사항 등록 실패";
//				path = "redirect:list";
//			}
//			
//			rdAttr.addFlashAttribute("msg", msg);
//			
//			return path;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("errorMsg", "공지사항 등록 과정 중 오류 발생");
//			return "common/errorPage";
//		}
//		
//	}
	
	
	
	
	
	
	
//	------------------------------ 선생님 version ----------------------------------
	// 공지사항 상세보기
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String noticeDetail(Model model, Integer no, RedirectAttributes rdAttr) {

		try {
			// 공지사항 상세 조회 서비스 호출
			Notice notice = noticeService.selectNotice(no);

			if (notice != null) { // DB 조회 결과가 있을 경우

				model.addAttribute("notice", notice);
				return "notice/noticeDetail";
			} else {
				rdAttr.addFlashAttribute("msg", "공지사항 상세조회 실패");
				return "redirect:list";
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 상세 조회 과정에서 오류 발생");
			return "common/errorPage";
		}
	}

	// 공지사항 등록 화면 이동
	@RequestMapping("insertForm")
	public String insertForm(HttpServletRequest request, Model model) {
		return "notice/noticeInsert";
	}

	// 공지사항 등록
	@RequestMapping("insert")
	public String insertNotice(Notice notice, Model model, RedirectAttributes rdAttr) {
		// 작성자를 얻어오기 위한 세션값 얻어오기
		Member loginMember = (Member) model.getAttribute("loginMember");

		// 커맨드 객체 notice에 작성자(id) 세팅
		notice.setNoticeWriter(loginMember.getMemberId());

		try {
			// 공지사항 등록 서비스 호출
			int result = noticeService.insertNotice(notice);

			String msg = null;
			String url = null;
			if (result > 0) {
				msg = "공지사항 등록 성공";
				url = "detail?no=" + result;
			} else {
				msg = "공지사항 등록 실패";
				url = "list";
			}
			rdAttr.addFlashAttribute("msg", msg);
			return "redirect:" + url;

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 등록 과정에서 오류 발생");
			return "common/errorPage";
		}
	}

	// 공지사항 수정 화면 이동
	@RequestMapping("updateForm")
	public String updateForm(Integer no, HttpServletRequest request, Model model, RedirectAttributes rdAttr) {

		// 이전 페이지의 주소를 detailUrl에 저장
		String detailUrl = request.getHeader("referer");
		System.out.println("detailUrl : " + detailUrl);

		try {
			// 수정 화면에 보여질 게시글 내용 조회 서비스 호출
			Notice notice = noticeService.updateView(no);

			if (notice != null) {

				// @SessionAttributes에 "detailUrl" 등록하여 Session scope로 사용
				// --> update 화면에 출력될 이전 글 내용 조회 실패
				// 또는 update 후 상세조회 화면으로 돌아올 때 사용할 수 있음.
				model.addAttribute("detailUrl", detailUrl);

				model.addAttribute("notice", notice);
				return "notice/noticeUpdate";
			} else {
				rdAttr.addFlashAttribute("msg", "공지사항 내용 조회 실패");

				return "redirect:" + detailUrl;
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 수정 화면으로 전환하는 과정에서 오류 발생");
			return "common/errorPage";
		}

	}

	// 공지사항 수정
	@RequestMapping("update")
	public String updateNotice(Integer no, Notice notice, Model model, RedirectAttributes rdAttr,
			HttpServletRequest request) {

		// session scope에서 detailUrl을 얻어옴
		String detailUrl = (String) model.getAttribute("detailUrl");
		notice.setNoticeNo(no);

		try {
			// 공지사항 수정용 Service 호출
			int result = noticeService.updatetNotice(notice);

			String msg = null;
			if (result > 0)
				msg = "공지사항이 수정되었습니다.";
			else
				msg = "공지사항 수정 실패";

			model.addAttribute("msg", msg);

			// 수정 후 상세조회 화면 요청
			return "redirect:" + detailUrl;

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 수정 과정에서 오류 발생");
			return "common/errorPage";
		}
	}

	// 공지사항 삭제
	@RequestMapping("delete")
	public String deleteNotice(Integer no, Model model, HttpServletRequest request, RedirectAttributes rdAttr) {
		try {
			// 공지사항 삭제 서비스 호출
			int result = noticeService.deletetNotice(no);

			String msg = null;
			String url = null;
			if (result > 0) {
				msg = "공지사항이 삭제되었습니다.";
				url = "redirect:list";
			} else {
				msg = "공지사항 수정 실패";

				// 이전페이지(상세조회 페이지) 주소 저장
				String oldUrl = request.getHeader("referer");
				url = "redirect:" + oldUrl;
			}

			rdAttr.addFlashAttribute("msg", msg);
			return url;

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "공지사항 삭제 과정에서 오류 발생");
			return "common/errorPage";
		}
	}
	
}
