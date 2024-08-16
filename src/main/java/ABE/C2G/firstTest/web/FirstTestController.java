package ABE.C2G.firstTest.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ABE.C2G.admin.board.service.BoardAdService;
import ABE.C2G.admin.board.web.BoardAdController;
import ABE.C2G.cmmn.model.BoardVO;
import ABE.C2G.firstTest.service.FirstTestService;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "")
public class FirstTestController {

	// 프러젝트 연결 확인 service
	@Autowired
	private FirstTestService firstTestService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(FirstTestController.class);

	
//	@RequestMapping(value = "/testFirst", method = RequestMethod.GET)
	@GetMapping(value = "/testFirst")
	public String firstTest() {
		System.out.println("jsp호출");
		
		return "firstTest";
	}
	
	
	
	@GetMapping(value = "/testFirstDB")
	public String firstTestDB(ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
) throws IOException, SQLException {

		System.out.println("DB 테스트 조회");
		logger.info("--- 프로젝트 DB 접속여부 확인페이지 조회 start ---");
		model.addAttribute("DBtest",firstTestService.selectDBtest());
		logger.info("--- 프로젝트 DB 접속여부 확인페이지 조회 end ---");

		return "firstTestDB";
	}
	/*
	@ApiOperation(value="프로젝트 DB 접속여부 확인페이지 조회", notes="프로젝트 DB 접속여부 확인페이지 조회한다.")
	@RequestMapping(value = "testFirstDB")
	public String firstTestDB(//@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 게시판 목록페이지 조회 start ---");

		model.addAttribute("boardList",boardAdService.selectBoardAdList(searchVO));
		
		logger.info("--- 관리자 게시판 목록페이지 조회 end ---");
		return "admin/board/boardList";
//		return "admin/board/pagnationExample";
	}
	*/
	
}
