package ABE.C2G.admin.board.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ABE.C2G.admin.board.service.BoardAdService;
import ABE.C2G.admin.board.service.impl.BoardAdServiceImpl;
import ABE.C2G.cmmn.model.BoardVO;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardAdController {

	// 관리자-게시판 service
//	@Autowired(name = "boardAdService")
	@Autowired
	private BoardAdService boardAdService;
	
	// 환경변수 의존성 주입
//	@Autowired
//	Environment env; 
	
	private static final Logger logger = LoggerFactory.getLogger(BoardAdController.class);
	
	@ApiOperation(value="관리자 게시판 목록 조회", notes="관리자 게시판 목록을 조회한다.")
	@RequestMapping(value = "boardAdListView")
	public String boardAdListView(@ModelAttribute("searchVO") BoardVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		
//		model.addAttribute("test",boardAdService.selectBoardAdList(searchVO));
		logger.info("test : " + boardAdService.selectBoardAdList());
		
		return "admin/board/boardList";
	}
	

	
	
}
