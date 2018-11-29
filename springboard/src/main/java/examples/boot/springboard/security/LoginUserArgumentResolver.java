package examples.boot.springboard.security;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

public class LoginUserArgumentResolver
        implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        //@AuthUser 어노테이션이 있으면서
        //클래스 타입이 AuthUser면 true를 리턴

        AuthUser authUser = methodParameter.getParameterAnnotation(AuthUser.class);

        if( authUser != null
            && methodParameter.getParameterType() == LoginUser.class ) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        // 로그인한 정보를 리턴

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if( authentication == null )
            return null;

        LoginUser loginUser = (LoginUser)authentication.getPrincipal();

        return loginUser;
    }
}
