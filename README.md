## 도메인 설명
### Movie
- 속성 : 제목, 감독, 장르
- 영화 정보 등록 및 조회
### Review
- 속성 : 별점, 내용, 스포일러 유무
- 영화에 대한 리뷰 작성 및 조회
## ERD
<p ><img width="1018" height="608" alt="스크린샷 2026-05-24 221211" src="https://github.com/user-attachments/assets/32114969-e6e6-4a5b-977a-97349dc41e23" /></p>
하나의 영화에는 여러 리뷰가 작성될 수 있지만 리뷰 하나는 하나의 영화에 대한 내용만 작성할 수 있다. 따라서 영화와 리뷰의 관계를 1:N으로 구현하였다.

## API 명세
| 기능 | Method | Endpoint | Request | Response | 상태코드 |
|---|---|---|---|---|---|
| 영화 등록 | POST | /api/movie | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>}</pre> | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 |
| 영화 전체 조회 | GET | /api/movie | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 |
| 영화 단건 조회 | GET | /api/movie/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 |
| 영화 삭제 | DELETE | /api/movie/{id} | - | - | 204 |
| 리뷰 등록 | POST | /api/review | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 |
| 리뷰 전체 조회 | GET | /api/review | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 |
| 리뷰 단건 조회 | GET | /api/review/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 |
| 리뷰 삭제 | DELETE | /api/review/{id} | - | - | 204 |
## Postman으로 API 호출 결과
<img width="1919" height="694" alt="스크린샷 2026-05-25 234327" src="https://github.com/user-attachments/assets/cb970064-5908-48b8-aeeb-5c799e096125" />
## 강의에서 배운 내용 중 이번에 직접 써본 것 3가지

## Controller에서 엔티티를 직접 받지 않고 DTO로 분리한 이유
엔티티를 그대로 사용하면 필요하지 않은 데이터도 함께 전달될 수 있기 때문에 DTO로 분리했다. 또한 DTO를 따로 사용하면 Request와 Response의 역할을 분리할 수 있어서 관리하기 쉽다.
## 막혔던 부분 1가지와 해결 방법
Review와 Movie의 연관관계를 설정하는 부분에서 어려움을 겪었다. 처음에는 review.getMovieId()로 movieId를 바로 가져오려고 했더니 에러가 발생하였다.
실제로는 Review가 Movie 객체를 참조하고 있기 때문에 Movie 객체를 먼저 조회한 뒤 review.setMovie(movie)로 연결하고, review.getMovie().getMovieId()로 접근해서 해결할 수 있었다.
