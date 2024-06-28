package ABE.C2G.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


// @Configuration		: 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션
// @EnableWebSecurity	: 내부적으로 SecurityFilterChain 동작하여 URL 필터 적용됨 
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
				// 현재 사용하는 시큐리티 버전 -> 6.3.1
				// 시큐리티 5는  .csrf().disable() 사용 가능
				// 시큐리티 6은  .csrf(csrf -> csrf.disable()) -> authorizeHttpRequests 밑 위치에서는 에러
				// .csrf().disable()  // CSRF 보호 비활성화
				.csrf(csrf -> csrf.disable())
				
				.authorizeHttpRequests((authorizeRequests)->
						authorizeRequests
//								.requestMatchers(PathRequest.toH2Console()).permitAll()		// H2 콘솔 접근 허용
								.requestMatchers("/").permitAll()							// 홈("/") 경로 접근 허용
//								.anyRequest().authenticated()								// 나머지 요청은 인증 요구
								
								// (개발하는 동안 모든 요청 접근 허용 설정 -> 시큐리티 로그인 화면 skip 설정)
								.anyRequest().permitAll() 									// 모든 요청에 대해 접근 허용
								
								

				);
		
		return http.build();
		
	}
	
	// 람다식으로 파라미터 전달
	
	// requestMatchers() : 특정 요청과 일치하는 url 대한 엑세스 설정
	// ignoring() : requestMatchers에 적힌 url 대해 인증, 인가 하지 않음
	// csrf : 공격자가 인증된 브라우저에 저장된 쿠키의 세션 정보 활용해 웹 서버에 사용자가 의도하지 않은 요청 전달하는 것
	//		  정상적인 사용자가 의도치 않은 위조요청 보내는 것
	//		  REST API 환경은 Session 기반 인증과 다르므로 서버에 인증보관 하지 않고 권한 요청시 필요 정보(Oauth2, JWT 토큰 등) 요청 포함하므로 csrf 보안 활성화 필요 없음
	// authorizeHttpRequests : 인증, 인가가 필요한 url 지정
	// anyRequest() : requestMatchers에서 지정된 url외의 요청에 대한 설정
	// authenticated() : 해당 url에 진입 위해 인증 필요
	// requestMatchers("url').permitAll() : requestMatchers에서 지정된 url은 인증, 인가 없어도 접근 가능
	// hasAuthority() : 해당 url에 진입 위해 Authorization(인가, admin만 진입 가능 등) 필요 / .hasAuthority(UserRole.ADMIN.name()) 와 같이 사용 가능
	
	
	

}
