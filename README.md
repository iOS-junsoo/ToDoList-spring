# [TodoList]

이 프로젝트는 스프링부트를 사용해서 TodoList 서버를 구현한 iOS 앱입니다. 
이 앱의 서버는 H2 데이터베이스와 연결되어 있고, 사용자가 할 일을 관리할 수 있는 기능을 제공합니다.

## 기능 🏗️

- **할 일 추가**: 사용자가 새로운 할 일을 추가할 수 있습니다.
- **할 일 조회**: 사용자가 추가한 할 일을 조회할 수 있습니다.
- **할 일 완료**: 사용자가 수행한 할 일을 완료 처리 할 수 있습니다.
- **할 일 삭제**: 사용자가 할 일을 삭제할 수 있습니다.

## 기술 스택 🛠️

- **프레임워크**: Spring Boot
- **데이터베이스**: H2
- **빌드 도구**: Gradle
- **기타 라이브러리**: Spring Data JPA, H2 Database, JUnit

## API 문서 📃

- **POST /todo**: 새로운 할 일을 추가합니다.
  - 요청 바디: `{"title": "할 일 제목", "description": "할 일 설명"}`
  - 응답: 추가된 할 일 객체

- **GET /todo**: 모든 할 일을 조회합니다.
  - 응답: 할 일 객체 배열

- **PUT /todo/{id}/complete**: 특정 할 일을 완료 처리합니다.
  - 응답: 수정된 할 일 객체

- **DELETE /todo/{id}/delete**: 특정 할 일을 삭제합니다.
  - 응답: 삭제 성공 메시지

## 화면 구성 📱

<p align="center">
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fboyduu%2FbtsJi4Monrm%2FOtY2vitoORSvahX0dly5Gk%2Fimg.png" width="200" height="auto" alt="Image 1" style="display:inline-block; margin:5px;">
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FckaC1Y%2FbtsJjysyRzF%2FmrkZmkjrLZJ2QSCjssREUK%2Fimg.png" width="200" height="auto" alt="Image 2" style="display:inline-block; margin:5px;">
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcd1Geh%2FbtsJi6ceLpP%2FdgdDog3NKZ2SUMyDEIVj61%2Fimg.png
" width="200" height="auto" alt="Image 3" style="display:inline-block; margin:5px;">
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fm3TCL%2FbtsJjj3DdaP%2FkGJB9rAn7zYkYEQjiAGksk%2Fimg.png" width="200" height="auto" alt="Image 4" style="display:inline-block; margin:5px;">
</p>

