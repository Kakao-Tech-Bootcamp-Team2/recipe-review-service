# Recipe Review Service

Recipe Review Service는 Zipbob 프로젝트의 서비스 중 하나로, LLM이 추천한 레시피에 대한 리뷰를 관리하는 기능을 제공합니다. 사용자들은 이 서비스를 통해 레시피에 대한 리뷰를 작성하고, 조회하고, 수정하고, 삭제할 수 있습니다.

## REST API

| Endpoint	        | Method   | Req. body    | Status | Description    		   	    |
|:-----------------|:---------|:-------------|:-------|:---------------------------|
| `/reviews`       | `POST`   | Review       | 201    | 새로운 리뷰를 생성합니다         |
| `/reviews/recipe`| `GET`    | recipeId     | 200    | 특정 레시피의 모든 리뷰를 조회합니다 |
| `/reviews/member`| `GET`    | memberId     | 200    | 특정 회원의 모든 리뷰를 조회합니다  |
| `/reviews`       | `PATCH`  | Review       | 200    | 기존 리뷰를 수정합니다          |
| `/reviews`       | `DELETE` | reviewId     | 204    | 리뷰를 삭제합니다              |

## API 요청/응답 예시

### 리뷰 생성
```json
// POST /reviews
{
  "memberId": 1,
  "recipeId": "recipe_6789032",
  "content": "좋은 레시피입니다 ~!",
  "rating": 4.5,
  "authorNickname": "covy"
}
```

### 레시피별 리뷰 조회
```json
// GET /reviews/recipe?recipeId=recipe_6789012
Response:
{
  "reviews": [
    {
      "id": "67621bdc3ff6720bb5640b76",
      "memberId": 1,
      "recipeId": "recipe_6789012",
      "content": "좋은 레시피입니다 ~!",
      "rating": 4.5,
      "authorNickname": "covy",
      "createdDate": "2024-01-25T14:30:00",
      "updatedDate": "2024-01-25T14:30:00"
    }
  ]
}
```

### 회원별 리뷰 조회
```json
// GET /reviews/member?memberId=1
Response:
{
  "reviews": [
    {
      "id": "67621bdc3ff6720bb5640b76",
      "memberId": 1,
      "recipeId": "recipe_6789012",
      "content": "좋은 레시피입니다 ~!",
      "rating": 4.5,
      "authorNickname": "covy",
      "createdDate": "2024-01-25T14:30:00",
      "updatedDate": "2024-01-25T14:30:00"
    }
  ]
}
```

### 리뷰 수정
```json
// PATCH /reviews
Request:
{
  "reviewId": "67621bdc3ff6720bb5640b76",
  "content": "괜찮은 레시피입니다 ~!",
  "rating": 3.5
}
```

### 리뷰 삭제
```json
// DELETE /reviews
Request:
{
  "reviewId": "67621bdc3ff6720bb5640b76"
}
```

## 기술 스택
- Java 17
- Spring Boot 3.3.5
- Spring Cloud
- MongoDB
- Gradle

## 프로젝트 실행 방법

### 애플리케이션 빌드
\```bash
./gradlew build
\```

### 도커 이미지 빌드
\```bash
./gradlew bootBuildImage
\```

### 필요한 서비스 실행
MongoDB, Vault 등의 서비스 실행 방법은 [zipbob-deployment](https://github.com/Kakao-Tech-Bootcamp-Team2/zipbob-deployment/tree/main/docker) 저장소를 참고해주세요.

## 인증
모든 API 요청에는 Authorization 헤더에 Bearer 토큰이 필요합니다:
\```
Authorization: Bearer {accessToken}
\```

## 주요 의존성
- spring-boot-starter-web
- spring-boot-starter-data-mongodb
- spring-cloud-starter-config
- spring-boot-starter-validation
- spring-cloud-starter-vault-config