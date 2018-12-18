package kr.co.sunnyvale.shop.security;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthUser {
}

// 컨트롤러 메소드에 다음과 같이 작성한다.
// 메소드(@AuthUser LoginUser loginUser)