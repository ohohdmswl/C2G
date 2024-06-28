
package ABE.C2G.admin.board.service;

import java.util.List;
import java.util.Map;

import ABE.C2G.cmmn.model.BoardVO;

public interface BoardAdService {

	public List<Map<String, Object>> selectBoardAdList();

	public List<BoardVO> selectBoardAdList(BoardVO searchVO);

	public List<Map<String, Object>> selectBoardAdSearchList(BoardVO searchVO);

}
