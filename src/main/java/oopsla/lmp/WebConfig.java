package oopsla.lmp;


import oopsla.lmp.web.argumentResolver.LoginMemberArgumentResolver;
import oopsla.lmp.web.interceptor.LoginCheckInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// 이런 필터 적용하는 등의 스프링 내부 로직 때문에 성능을 깎아먹는 정도는 미미하다
// 오히려 데이터베이스 쿼리나 외부 네트워크 같은 게 성능 다 깎아먹고 이런 건 바다의 모래알
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override // 어노테이션 만들었으니 설정정보에 추가해줌
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new LoginCheckInterceptor())
//                .order(2)
//                .addPathPatterns("/**") // 모든 걸 다 검사하지만
//                .excludePathPatterns("/", "/members/add", "/login", "/logout", "/error"); // 얘들은 화이트리스트
    }

}
