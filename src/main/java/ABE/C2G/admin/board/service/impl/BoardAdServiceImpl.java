package ABE.C2G.admin.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.stereotype.Service;

import ABE.C2G.cmmn.dao.CmmnDAO;
import jakarta.annotation.Resource;

@Service("boardAdService")
public class BoardAdServiceImpl {

	// 공통 DAO 사용
	@Resource(name = "cmmnDAO")
	private CmmnDAO cmmnDAO;
	
	// 환경변수 설정
//	@Autowired
//	EnvironmentCapable env;

	
}
