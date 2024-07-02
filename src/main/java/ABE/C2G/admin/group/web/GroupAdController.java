package ABE.C2G.admin.group.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ABE.C2G.admin.group.service.GroupAdService;
import ABE.C2G.cmmn.model.BoardVO;
import ABE.C2G.cmmn.model.GroupVO;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/adm/group/")
public class GroupAdController {

	// 관리자-스터디그룹 service
	@Autowired
	private GroupAdService groupAdService;
	
	private static final Logger logger = LoggerFactory.getLogger(GroupAdController.class);
	
	
	@ApiOperation(value="관리자 스터디그룹 목록페이지 조회", notes="관리자 스터디그룹 목록 페이지를 조회한다.")
	@RequestMapping(value = "groupAdListView")
	public String groupAdListView(@ModelAttribute("searchVO") GroupVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 스터디그룹 목록페이지 조회 start ---");

//		model.addAttribute("groupList",groupAdService.selectGroupAdList(searchVO));
		
		logger.info("--- 관리자 스터디그룹 목록페이지 조회 end ---");
		return "admin/group/groupList";
	}
	
	@ApiOperation(value="관리자 스터디그룹 목록페이지 조회", notes="관리자 스터디그룹 목록 페이지를 조회한다.")
	@RequestMapping(value = "groupAdDetail")
	public String groupAdDetail(@ModelAttribute("searchVO") GroupVO searchVO, 
			ModelMap model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response
			) throws IOException, SQLException {
		logger.info("--- 관리자 스터디그룹 상세페이지 조회 start ---");
		
//		model.addAttribute("groupList",groupAdService.selectGroupAdList(searchVO));
		
		logger.info("--- 관리자 스터디그룹 상세페이지 조회 end ---");
		return "admin/group/groupDetail";
	}
	
	
}
