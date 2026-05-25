##도메인 설명
---
#Movie
- 속성 : 제목, 감독, 장르
- 영화 정보 등록 및 조회
#Review
- 속성 : 별점, 내용, 스포일러 유무
- 영화에 대한 리뷰 작성 및 조회
##ERD
---
<img width="1018" height="608" alt="스크린샷 2026-05-24 221211" src="https://github.com/user-attachments/assets/84b95e44-19fe-466f-9fa4-93c184ec80ae" />
하나의 영화에는 여러 리뷰가 작성될 수 있지만 리뷰 하나는 하나의 영화에 대한 내용만 작성할 수 있다. 따라서 영화와 리뷰의 관계를 1:N으로 구현하였다.
##API 명세
---
| 기능 | Method | Endpoint | Request | Response | Status Code |
|---|---|---|---|---|---|
| 영화 등록 | POST | /api/movie | {
    "title": "Interstellar",
    "director": "Christopher Nolan",
    "genre": "SF"
} | {
    "movieId": 1,
    "title": "Interstellar",
    "director": "Christopher Nolan",
    "genre": "SF"
} | 200 OK |
