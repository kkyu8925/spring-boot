## 5. 스프링 MVC 2편 - 백엔드 웹 개발 활용 기술

### 섹션 0. 소개

### 섹션 1. 타임리프 - 기본 기능

### 섹션 2. 타임리프 - 스프링 통합과 폼

### 섹션 3. 메시지, 국제화

### 섹션 4. 검증1 - Validation

- [spring-roadmap/spring-mvc2-validation](https://github.com/spring-roadmap/spring-mvc2-validation) (V1, V2)

### 섹션 5. 검증2 - Bean Validation

- [spring-roadmap/spring-mvc2-validation](https://github.com/spring-roadmap/spring-mvc2-validation) (V3, V4)

### 섹션 6. 로그인 처리1 - 쿠키, 세션

- [spring-roadmap/spring-mvc2-login](https://github.com/spring-roadmap/spring-mvc2-login)

### 섹션 7. 로그인 처리2 - 필터, 인터셉터

#### 서블릿 필터

- 공통 관심사는 스프링의 AOP로도 해결할 수 있지만, 웹과 관련된 공통 관심사는 지금부터 설명할 서블릿 필터 또는 스프링 인터셉터를 사용하는 것이 좋다.
- 웹과 관련된 공통 관심사를 처리할 때는 HTTP의 헤더나 URL의 정보들이 필요한데, 서블릿 필터나 스프링 인터셉터는 HttpServletRequest 를 제공한다.

#### 서블릿 필터 흐름

- HTTP 요청 -> WAS-> 필터 -> 서블릿 -> 컨트롤러

#### 인터셉터

- 스프링 인터셉터도 서블릿 필터와 같이 웹과 관련된 공통 관심 사항을 효과적으로 해결할 수 있는 기술이다.
- 서블릿 필터가 서블릿이 제공하는 기술이라면, 스프링 인터셉터는 스프링 MVC가 제공하는 기술이다.
- 둘다 웹과 관련된 공통 관심 사항을 처리하지만, 적용되는 순서와 범위, 그리고 사용방법이 다르다.

#### 인터셉터 흐름

- HTTP 요청 -> WAS-> 필터 -> 서블릿 -> 스프링 인터셉터 -> 컨트롤러
- 스프링 인터셉터는 디스패처 서블릿과 컨트롤러 사이에서 컨트롤러 호출 직전에 호출 된다.
- 스프링 인터셉터는 스프링 MVC가 제공하는 기능이기 때문에 결국 디스패처 서블릿 이후에 등장하게 된다.
- 스프링 MVC의 시작점이 디스패처 서블릿이라고 생각해보면 이해가 될 것이다.
- 스프링 인터셉터에도 URL 패턴을 적용할 수 있는데, 서블릿 URL 패턴과는 다르고, 매우 정밀하게 설정할 수 있다.
- 스프링 인터셉터는 서블릿 필터보다 편리하고, 더 정교하고 다양한 기능을 지원한다.

### 섹션 8. 예외 처리와 오류 페이지

- [spring-roadmap/spring-mvc2-exception](https://github.com/spring-roadmap/spring-mvc2-exception)

### 섹션 9. API 예외 처리

- [spring-roadmap/spring-mvc2-exception](https://github.com/spring-roadmap/spring-mvc2-exception)

### 섹션 10. 스프링 타입 컨버터

### 섹션 11. 파일 업로드

### 섹션 12. 다음으로
