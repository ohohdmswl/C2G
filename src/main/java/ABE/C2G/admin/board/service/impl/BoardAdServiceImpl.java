package ABE.C2G.admin.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.stereotype.Service;

import ABE.C2G.admin.board.service.BoardAdService;
import ABE.C2G.cmmn.dao.CmmnDAO;
import ABE.C2G.cmmn.model.BoardVO;
import jakarta.annotation.Resource;

@Service("boardAdService")
public class BoardAdServiceImpl implements BoardAdService{

	// 공통 DAO 사용
	@Resource(name = "cmmnDAO")
	private CmmnDAO cmmnDAO;
	
	// 환경변수 설정
//	@Autowired
//	EnvironmentCapable env;

	@Override
//	public List<BoardVO> selectBoardAdList(BoardVO searchVO) {
	public List<Map<String, Object>> selectBoardAdList() {
		return cmmnDAO.selectList("board.selectBoardAdList0");
	}
	
	@Override
	public List<BoardVO> selectBoardAdList(BoardVO searchVO) {
		return cmmnDAO.selectList("board.selectBoardAdList1", searchVO);
	}
	
	@Override
	public List<Map<String, Object>> selectBoardAdSearchList(BoardVO searchVO) {
		return cmmnDAO.selectList("board.selectBoardAdSearchList", searchVO);
	}
}
