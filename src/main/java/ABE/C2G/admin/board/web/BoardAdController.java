package ABE.C2G.admin.board.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ABE.C2G.admin.board.service.BoardAdService;
import ABE.C2G.admin.board.service.impl.BoardAdServiceImpl;
import ABE.C2G.cmmn.model.BoardVO;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/adm/board/")
//@CrossOrigin(origins = "http://localhost:8080")
public class BoardAdController {

	// 관리자-게시판 service
//	@Autowired(name = "boardAdService")
	@Autowired
	private BoardAdService boardAdService;
	
	// 환경변수 의존성 주입
//	@Autowired
//	Environment env; 
	
	private static final Logger logger = LoggerFactory.getLogger(BoardAdController.class);
	
	@ApiOperation(value="관리자 게시판 목록페이지 조회", notes="관리자 게시판 목록 페이지를 조회한다.")
	@RequestMapping(value = "boardAdListView")
	public String boardAdListView(@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 게시판 목록페이지 조회 start ---");

//		logger.info("# DB연결 테스트 : " + boardAdService.selectBoardAdList());
		
//		model.addAttribute("boardList",boardAdService.selectBoardAdList(searchVO));
//		logger.info("# DB연결 테스트2 : " + boardAdService.selectBoardAdList(searchVO));
		model.addAttribute("boardList",boardAdService.selectBoardAdList(searchVO));
		
		logger.info("--- 관리자 게시판 목록페이지 조회 end ---");
		return "admin/board/boardList";
//		return "admin/board/pagnationExample";
	}
	
//	@RequestMapping(value = "boardAdSearchList", method = RequestMethod.POST)
	@ApiOperation(value="관리자 게시판 검색결과 목록 조회", notes="관리자 게시판 검색결과 목록 조회한다.")
	@ResponseBody
	@PostMapping("boardAdSearchList")
//	@GetMapping("boardAdSearchList")
//	public List<Map<String, Object>> boardAdSearchListView(@ModelAttribute("searchVO") BoardVO searchVO, 
			public Map<String, Object> boardAdSearchListView(@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 게시판 검색결과 목록 조회 start ---");
		logger.info("# 검색결과 ajax 파람1 : {}" , searchVO);
		logger.info("# 검색결과 ajax 파람2 : {}" , paramMap);
		
		Map<String, Object> SearchList1 = new HashMap<String, Object>(); 
		// list로 보냈을 때 json이 제대로 읽혀질지가 문제긴 해
		List<Map<String, Object>> searchList2 = boardAdService.selectBoardAdSearchList(searchVO); 
		
		
		SearchList1.put("searchList2", searchList2);
		logger.info("--- 관리자 게시판 검색결과 목록 조회 end ---");
		return SearchList1; //map
//		return searchList2;
	}

	
	
}
