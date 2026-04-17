# YumYumCoach

식단 분석을 활용한 개인 맞춤형 건강 코칭 서비스 콘솔 프로젝트입니다.

이 프로젝트는 Java 콘솔 환경에서 회원 관리, 식단 관리, 식단 분석을 기본으로 제공하고, 문자열 탐색 알고리즘을 적용한 검색 기능을 확장해 자료구조/알고리즘 프로젝트 형태로 구성했습니다.

---

## 1. 프로젝트 개요

- 프로젝트명: YumYumCoach
- 개발 언어: Java
- 실행 환경: Java 17+, STS/Eclipse/콘솔
- 형태: 콘솔 기반 CRUD + 알고리즘 검색 기능

핵심 목표
- 회원/식단 데이터를 적절한 자료구조로 관리한다.
- 문자열 탐색 알고리즘을 실제 기능에 적용한다.
- 식단 분석을 통해 총 영양 정보와 목표 적합 점수를 제공한다.

---

## 2. 실행 방법

### 2-1. 실행 파일
다음 파일을 실행하면 됩니다.

```text
src/com/ssafy/yumyumcoach/Main.java
```

### 2-2. STS / Eclipse 실행
1. 프로젝트 import
2. `Main.java` 열기
3. `Run As → Java Application`

### 2-3. 터미널 실행
```bash
cd src
javac com/ssafy/yumyumcoach/Main.java
java com.ssafy.yumyumcoach.Main
```

---

## 3. 샘플 계정

프로그램 시작 시 아래 샘플 계정이 자동으로 로드됩니다.

- `sample / 1234`
- `coach / 1234`

또한 샘플 식단, 음식 DB, 커뮤니티 게시글도 함께 로드됩니다.

---

## 4. 패키지 구조

```text
com.ssafy.yumyumcoach
 ├─ Main.java
 ├─ algorithms
 │   ├─ BruteForceMatcher.java
 │   ├─ KMPMatcher.java
 │   ├─ RabinKarpMatcher.java
 │   └─ BoyerMooreMatcher.java
 ├─ domain
 │   ├─ User.java
 │   ├─ Food.java
 │   ├─ MealItem.java
 │   ├─ MealRecord.java
 │   ├─ AnalysisResult.java
 │   ├─ GoalType.java
 │   └─ CommunityPost.java
 ├─ repository
 │   ├─ UserRepository.java
 │   ├─ FoodRepository.java
 │   ├─ MealRepository.java
 │   └─ CommunityRepository.java
 ├─ manager
 │   ├─ AuthManager.java
 │   ├─ UserManager.java
 │   ├─ MealManager.java
 │   ├─ AnalysisManager.java
 │   ├─ FoodSearchManager.java
 │   └─ CommunityManager.java
 ├─ ui
 │   ├─ MainMenu.java
 │   ├─ UserMenu.java
 │   └─ MealMenu.java
 └─ util
     ├─ InputUtil.java
     ├─ IdGenerator.java
     ├─ SeedDataLoader.java
     └─ MenuCommandResolver.java
```

---

## 5. 전체 기능 설명

## 5-1. 기본 기능

### 회원 기능
- 회원가입
- 로그인 / 로그아웃
- 내 정보 조회
- 내 정보 수정
- 회원 탈퇴(비활성화)

### 식단 기능
- 식단 작성
- 식단 전체 조회
- 식단 상세 조회
- 식단 수정
- 식단 삭제
- 식단 분석

### 식단 분석 결과
- 총 칼로리
- 총 단백질
- 총 탄수화물
- 총 지방
- 사용자 목표(DIET / BALANCE / BULKUP) 기준 점수
- 평가 메시지

---

## 5-2. 알고리즘 확장 기능

### 식단 키워드 검색 - KMP
식단에 포함된 음식명을 기준으로 키워드 검색을 수행합니다.

예시
- `고구마` 검색 → `고구마`, `고구마샐러드`가 포함된 식단 조회
- `바나나` 검색 → `바나나`, `바나나스무디`가 포함된 식단 조회

메뉴 경로
```text
로그인 → 2. 식단 관리 → 7. 키워드 검색(알고리즘)
```

### 음식 DB 검색 - Boyer-Moore
음식명 부분 검색 기능입니다.

메뉴 경로
```text
메인 메뉴 → 3. 음식 DB 검색(Boyer-Moore)
```

### 커뮤니티 검색 - Rabin-Karp
게시글 제목과 본문을 합쳐 키워드를 검색합니다.

메뉴 경로
```text
메인 메뉴 → 4. 커뮤니티 검색(Rabin-Karp)
```

### 메뉴 명령어 해석 - Brute Force
숫자 입력뿐 아니라 한글 명령어 입력도 일부 허용합니다.

예시
- `로그인`
- `회원관리`
- `식단관리`
- `키워드검색`

---

## 6. 사용한 자료구조

### 회원 정보
- `HashMap<String, User>`
- 사용자 ID 기반 빠른 조회를 위해 사용

### 식단 정보
- `LinkedHashMap<Integer, MealRecord>`
- 식단 ID 기반 CRUD와 입력 순서 유지를 위해 사용

### 음식 정보
- `LinkedHashMap<Integer, Food>`
- 음식 ID 기반 조회 및 목록 출력 순서 유지를 위해 사용

### 게시글 정보
- `ArrayList<CommunityPost>`
- 데이터 규모가 작고 전체 순회 기반 검색에 적합

---

## 7. 사용한 알고리즘

| 알고리즘 | 적용 기능 | 이유 |
|---|---|---|
| Brute Force | 메뉴 명령 해석 | 입력 후보 수가 적고 문자열이 짧아 단순 구현이 유리 |
| KMP | 식단 키워드 검색 | 동일 패턴을 여러 음식명에 반복 탐색하는 구조에 적합 |
| Rabin-Karp | 커뮤니티 검색 | 여러 게시글 텍스트에 같은 패턴을 반복 비교하기 좋음 |
| Boyer-Moore | 음식 DB 검색 | 대표 문자열 탐색 알고리즘 적용 사례 확보 |

---

## 8. 예시 사용 흐름

### 예시 1. 식단 검색
1. `sample / 1234` 로그인
2. `2. 식단 관리`
3. `7. 키워드 검색(알고리즘)`
4. `고구마` 입력
5. 고구마가 포함된 식단 출력

### 예시 2. 음식 검색
1. 메인 메뉴에서 `3. 음식 DB 검색(Boyer-Moore)` 선택
2. `바나나` 입력
3. `바나나`, `바나나스무디` 검색 결과 확인

### 예시 3. 게시글 검색
1. 메인 메뉴에서 `4. 커뮤니티 검색(Rabin-Karp)` 선택
2. `식단` 또는 `단백질` 입력
3. 관련 게시글 출력

---

## 9. 주의사항

- 현재 데이터는 `SeedDataLoader`를 통해 메모리에 로드됩니다.
- 프로그램 종료 시 데이터는 초기화됩니다.
- 최신 버전 ZIP을 실행해야 샘플 식단 검색이 정상 동작합니다.

---

## 10. 향후 개선 사항

- JSON/XLSX 실제 파일 로딩 연동
- 검색 알고리즘 성능 최적화
- 게시판/챌린지 기능 CRUD 확장
- 사용자 건강 통계 기반 분석 고도화
