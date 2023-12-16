# anichu(애니 + 추천 = 애니추)
애니메이션의 별점을 매기고 특징을 공유하여 더 다양한 볼거리를 찾는 것을 도와주는 토이프로젝트입니다.

### 디렉토리 구조
```text
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─io
    │  │      └─anichu
    │  │          └─anichu
    │  │              │  AnichuApplication.java
    │  │              │
    │  │              ├─controller
    │  │              │
    │  │              ├─dto
    │  │              │  ├─request
    │  │              │  │
    │  │              │  └─response
    │  │              │
    │  │              ├─entity
    │  │              │
    │  │              ├─repository # DB 접근과 관련된 인터페이스
    │  │              │  │ # JPA Repository를 확장한 인터페이스
    │  │              │  └─mapper # Mybatis사용을 위한 @Mapper가 사용된 인터페이스
    │  │              │
    │  │              └─service
    │  │                  │
    │  │                  └─impl
    │  │
    │  └─resources
    │      │  application.yml
    │      │
    │      ├─mappers
    │      │
    │      ├─static
    │      │
    │      └─templates
    │
    └─test
        └─java
            └─io
                └─anichu
                    └─anichu
                            AnichuApplicationTests.java
```

### application.yml
```text
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: #{USER_NAME}
    password: #{USER_PASSWORD}
    url: #{DATABASE_URL}
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        show-sql: true
  data:
    mongodb:
      database: #{DATABASE_NAME}
      host: #{DATABASE_HOST}
      port: #{DATABASE_PORT}
      username: #{USER_NAME}
      password: #{USER_PASSWORD}
      authentication-database: admin # authentication error 발생 시 필요한 설정

mybatis:
  mapper-locations: classpath:mappers/*.xml

server:
  servlet:
    encoding:
      force-response: true # mustache에서 한글 깨짐현상을 해결하기 위한 설정
```