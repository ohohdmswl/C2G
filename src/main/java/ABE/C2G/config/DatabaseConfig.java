package ABE.C2G.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@MapperScan(basePackages = "ABE.C2G.mapper")
@EnableTransactionManagement
public class DatabaseConfig {

    /**
     * SqlSessionFactory 구성
     * - MyBatis 설정 파일을 읽어들여 SqlSession을 생성하는 팩토리 클래스
     * 1. DataSource 지정
     * 2. Mapper.xml 파일 연결
     * 3. 최종 구성 객체 반환
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        
		// SqlSessionFactoryBean 인스턴스 생성
		// -> 마이바티스와 스프링 통합해 db와의 연결, sql 매퍼 파일 관리하는데 사용되는 클래스 (마이바티스와 스프링을 연결하는 역할)
		// -> 스프링의 FactoryBean 인터페이스 구현해 마이바티스 SqlSessionFactory 객체를 생성 관리
		// -> 생성시 db연결 정보(datasource)설정하고 sql 매퍼 파일 위치 지정 등 설정 가능
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		
		// setDataSource()
		// -> SqlSessionFactoryBean 객체에 dataSource 설정
		
		// dataSource
		// -> dataSource 인터페이스를 구현한 객체로 db연결 정보 포함
		// -> @Configuration 클래스에서 @Bean 어노테이션을 사용하여 등록된 데이터 소스 빈을 가리킴
		// -> 현재 application.properties 에 dataSource 정보 작성해둠
		// -> 스프링 부트는 application.properties에서 dataSource 프로퍼티를 자동인식한다고 함
        sessionFactory.setDataSource(dataSource);
        
        // PathMatchingResourcePatternResolver
        // -> 스프링에서 classpath 기반으로 리소스 로드, 검색시 사용하는 유틸리티 클래스(리소스 로드, 검색, 외부 파일 시스템 리소스 로드, Ant 스타일 패턴 매칭(/** 와 같은 패턴/))
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        
        sessionFactory.setConfigLocation(pathMatchingResourcePatternResolver.getResource("classpath:/mapper/config/mapperConfig.xml"));
        
        // sql 매퍼 파일 위치 설정위한 메소드 호출
        // setMapperLocations() -> SQL 매퍼 파일 위치 설정
        // PathMatchingResourcePatternResolver 객체 사용해 classpath 내의 mapper 디렉토리에서 확장자가 .xml인 모든 파일을 찾음(마이바티스의 매퍼 파일 위치한 곳 지정)
        // classpath: -> classpath내 리소스 접근 가능하게 하는 접두어
        sessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources("/mapper/*.xml"));
        return sessionFactory.getObject();    
	}
	
    /**
     * SqlSessionTemplate 구성
     * - SQL 실행과 트랜잭션 관리를 담당하며, SqlSession 인스턴스의 생명주기를 관리하고 필요한 설정을 자동으로 수행
     * 데이터베이스와 세션을 관리하는 sqlSessionTemplate 빈 생성
     * 마이바티스를 사용해 db에 접근하는 데 필요한 기본 세션 관리 기능 제공
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
    	
    	// SqlSessionFactory -> 마이바티스에서 db와의 세션을 관리하는 객체
    	// SqlSessionTemplate 
    	// -> 마이바티스의 sqlSession 인터페이스를 구현할 클래스, db와의 세션을 효율적으로 관리하도록 도와줌
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        
        // SqlSessionTemplate 반환
        //-> 스프링 컨테이너에서 관리하며 다른 컴포넌트에서 주입하여 마이바티스를 사용해 db에 접근하고 쿼리 실행 가능하게 함
        return sqlSessionTemplate;
    }
	
}
