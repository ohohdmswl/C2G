package ABE.C2G.cmmn.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("cmmnDAO")
public class CmmnDAO extends SqlSessionTemplate{

	public CmmnDAO(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

//    @Autowired
//    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
//        super.setSqlSessionTemplate(sqlSessionTemplate);
//    }
}
