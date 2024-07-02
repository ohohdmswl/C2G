package ABE.C2G.admin.group.service.impl;

import org.springframework.stereotype.Service;

import ABE.C2G.admin.group.service.GroupAdService;
import ABE.C2G.cmmn.dao.CmmnDAO;
import jakarta.annotation.Resource;

@Service("groupAdService")
public class GroupAdServiceImpl implements GroupAdService {

	// 공통 DAO 사용
	@Resource(name = "cmmnDAO")
	private CmmnDAO cmmnDAO;
	
	
	
}
