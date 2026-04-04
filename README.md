## 🧩 [미션] FrontController 패턴 도입하기

## 🎯 목표

기존 Servlet MVC 구조를 기반으로

**FrontController 패턴을 적용하여 구조를 개선**하는 것을 목표로 합니다.

---

## 📌 배경

현재 제공된 코드는 다음과 같은 구조입니다:

- URL마다 개별 Servlet이 존재
- 각 Servlet이 직접 요청을 처리
- View(JSP)로 직접 forward

---

## 🚨 문제점

현재 구조는 다음과 같은 한계를 가집니다:

- Servlet 개수가 많아짐 (URL마다 하나씩 필요)
- 공통 로직 처리 어려움
- 확장성 낮음
- 코드 중복 발생

---

## 🛠️ 미션 요구사항

### 1️⃣ FrontControllerServlet 구현

- 하나의 Servlet이 모든 요청을 받도록 구현
- URL에 따라 적절한 Controller를 호출하는 HandlerMapping 구조 구현
    - **if/else 또는 switch로 URL 분기 처리 금지**

### 2️⃣ Controller 분리

- 기존 Servlet 로직을 Controller 클래스로 분리
    - **Controller는 공통 인터페이스를 구현하도록 설계할 것**
- FrontController에서 호출하도록 변경

### 3️⃣ View 처리

- Controller에서 viewName 반환
- Controller는 Model 데이터를 생성하여 View에 전달할 것
- FrontController에서 JSP로 forward

**⚠️ 제공된 패키지 구조는 수정하지 말 것**

---

### ⚙️ 설정 방법

### 1. Preferences → Gradle 설정

- Build and run using : `IntelliJ IDEA`로 변경
- Run tests using : `IntelliJ IDEA`로 변경

<img width="1502" height="907" alt="image" src="https://github.com/user-attachments/assets/171caad7-209b-4392-892a-b5de517c5f69" />


### 2. **WebServerLauncher 수정**

- 아래 주석 제거

<img width="1652" height="172" alt="image" src="https://github.com/user-attachments/assets/0959dd93-5a39-46af-a06e-5daba55141ae" />


→ 이제 모든 요청은 `/front-controller/*` 로 들어오게 됩니다.

### 3. JSP 경로 수정

- 모든 버튼 및 form action 경로에 `/front-controller` prefix 추가

ex) /home → /front-controller/home으로 경로 수정

<img width="1044" height="256" alt="image" src="https://github.com/user-attachments/assets/65f6409b-44ed-452c-973c-aefa5e68a809" />


---

## 📦 제출 방식

### 1️⃣ 코드 제출

- FrontController 패턴 적용 코드

### 2️⃣ PR 작성

- PR 내용에 반드시 포함: FrontController 기반 MVC 요청 처리 흐름을 그림 그려서 첨부
