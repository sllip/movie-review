## 도메인 설명
### Movie
- 속성 : 제목, 감독, 장르
- 영화 정보 등록 및 조회
### Review
- 속성 : 별점, 내용, 스포일러 유무
- 영화에 대한 리뷰 작성 및 조회
## ERD
<p align="center">
<img width="1018" height="608" alt="스크린샷 2026-05-24 221211" src="https://github.com/user-attachments/assets/32114969-e6e6-4a5b-977a-97349dc41e23" />
하나의 영화에는 여러 리뷰가 작성될 수 있지만 리뷰 하나는 하나의 영화에 대한 내용만 작성할 수 있다. 따라서 영화와 리뷰의 관계를 1:N으로 구현하였다.
## API 명세
| 기능 | Method | Endpoint | Request | Response | 상태코드 |
|---|---|---|---|---|---|
| 영화 등록 | POST | /api/movie | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>}</pre> | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 OK |
| 영화 전체 조회 | GET | /api/movie | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 OK |
| 영화 단건 조회 | GET | /api/movie/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"director": "Christopher Nolan",<br>&nbsp;&nbsp;&nbsp;&nbsp;"genre": "SF"<br>} | 200 OK |
| 영화 삭제 | DELETE | /api/movie/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"message ": "영화가 삭제되었습니다."<br>} | 200 OK |
| 리뷰 등록 | POST | /api/review | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieTitle": "Interstellar",<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 OK |
| 리뷰 전체 조회 | GET | /api/review | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 OK |
| 리뷰 단건 조회 | GET | /api/review/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"reviewId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"movieId": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"rating": 4.5,<br>&nbsp;&nbsp;&nbsp;&nbsp;"content": "재미있어요",<br>&nbsp;&nbsp;&nbsp;&nbsp;"spoilerContains": false<br>} | 200 OK |
| 리뷰 삭제 | DELETE | /api/review/{id} | - | {<br>&nbsp;&nbsp;&nbsp;&nbsp;"message": "리뷰가 삭제되었습니다."<br>} | 200 OK |
