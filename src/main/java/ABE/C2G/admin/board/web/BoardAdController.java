package ABE.C2G.admin.board.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BoardAdController {

	// 관리자-게시판 service
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

		model.addAttribute("boardList",boardAdService.selectBoardAdList(searchVO));
		
		logger.info("--- 관리자 게시판 목록페이지 조회 end ---");
		return "admin/board/boardList";
//		return "admin/board/pagnationExample";
	}
	
	@ApiOperation(value="관리자 게시판 검색결과 목록 조회", notes="관리자 게시판 검색결과 목록 조회한다.")
	@ResponseBody
	@PostMapping("boardAdSearchList")
	public Map<String, Object> boardAdSearchListView(@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 게시판 검색결과 목록 조회 start ---");
		logger.info("# 검색결과 ajax 파람1 : {}" , searchVO);
		logger.info("# 검색결과 ajax 파람2 : {}" , paramMap);
		
		Map<String, Object> SearchList1 = new HashMap<String, Object>(); 
		List<Map<String, Object>> searchList2 = boardAdService.selectBoardAdSearchList(searchVO); 
		SearchList1.put("searchList2", searchList2);
		
		logger.info("--- 관리자 게시판 검색결과 목록 조회 end ---");
		return SearchList1; //map
	}

	@ApiOperation(value="관리자 게시판 삭제", notes="관리자 게시판을 삭제한다.")
	@ResponseBody
	@PostMapping("boardAdListDel")
	public Map<String, Object> boardAdListDel(@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam(value="arr[]") String[] delArr, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 게시판 리스트 삭제 start ---");

		// 삭제할 게시판 id를 배열에 추가
	    ArrayList<String> delArray = new ArrayList<String>();
	    for (String element : delArr) {
	    	logger.info("# ajax arr[] element : {}", element);
	    	delArray.add(element);
	    }
		logger.info("# delArray : {}" , delArray);
		
		Map<String, Object> resultData = new HashMap<String, Object>(); 
		boolean delResult = boardAdService.deleteBoardAdList(delArray);
		logger.info("# del result : {}" , delResult);
		resultData.put("delResult", delResult);
		
		logger.info("--- 관리자 게시판 리스트 삭제 end ---");
		return resultData; //map
	}
	
	
	
}
