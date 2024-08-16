package ABE.C2G.firstTest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ABE.C2G.cmmn.dao.CmmnDAO;
import ABE.C2G.firstTest.service.FirstTestService;
import jakarta.annotation.Resource;

@Service("firstTestService")
public class FirstTestServiceImpl implements FirstTestService{

	// 공통 DAO 사용
	@Resource(name = "cmmnDAO")
	private CmmnDAO cmmnDAO;
	
	@Override
	public List<Map<String, Object>> selectDBtest() {
		// TODO Auto-generated method stub
		return cmmnDAO.selectList("firstTest.selectDBtest");
	}

}
