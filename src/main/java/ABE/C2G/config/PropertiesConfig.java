package ABE.C2G.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {
	
	// application.properties을 환경변수로 사용하기 위한 congif class
	// 프로젝트 내 활용 방법
	// 1. @Value
	// 2. @Autowired

}
