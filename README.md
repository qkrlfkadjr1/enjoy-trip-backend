# Enjoy! Trip

본 프로젝트는 SSAFY 11기 Spring 관통 프로젝트 제출을 위해 개발되었다.

## 팀 소개

SSAFY 11기 서울 18반 <br>
개발 기간 : 2024.03.15 ~ 2024.04.05 <br>
팀장 : 이규빈<br>
팀원 : 김지원

## 프로젝트 소개

- 전국 지역별 여행 정보를 제공한다. 여행지 정보는 관광지, 문화시설, 축제공연행사 등으로 분류되며 카카오맵 api를 활용하여 마커를 통해 위치를 나타낸다. 회원가입 및 로그인 기능을 제공한다.

### 기본 기능

1. 한국관광공사 국문 관광정보 서비스의 json api를 활용하여 지역별 여행지 검색 기능 제공
2. 카카오맵 api를 활용하여 지도 및 마커 표시
3. 회원가입, 로그인 및 마이페이지(회원 수정, 회원 삭제) 기능 제공
4. 회원가입 시에 비밀번호를 알고리즘을 활용해 암호화 한다.

### 추가 기능

1. 마커 클릭 시 해당 여행지 사진 및 이름 정보 제공

### 심화 기능

## 기본 기능 구현

- ### 메인 화면
  ![main](https://github.com/qkrlfkadjr1/qkrlfkadjr1.github.io/assets/78300809/59919cfa-196f-4035-99ad-9228bb15bc80)
- ### 여행지 정보 화면
  ![tourinfo](https://github.com/qkrlfkadjr1/qkrlfkadjr1.github.io/assets/78300809/341d5d57-46b0-4877-8ceb-cf9997064a01)
- ### 로그인 화면

![login](https://github.com/Lee9Bin/Java_study/assets/116883491/94000ce0-f4e7-4db8-a898-cbec70cd8604)
![로그인성공](https://github.com/Lee9Bin/Java_study/assets/116883491/1056475d-6b93-431a-bb8a-445e84259b5d)
![로그인실패](https://github.com/Lee9Bin/Java_study/assets/116883491/46d852ed-0cd0-458f-a19a-5cc17ee48f68)

- ### 회원가입 화면

![회원가입](https://github.com/Lee9Bin/Java_study/assets/116883491/f71c1a21-4e47-4020-97c3-1736c3b5c073)
![passwordencryption](https://github.com/Lee9Bin/python_algorism/assets/116883491/18a72ca0-60d1-4dcf-9a93-8aed0945fd95)

- ### 마이 페이지 화면
  ![회원수정](https://github.com/Lee9Bin/Java_study/assets/116883491/431a3ac9-c431-41b2-be63-6f016ae98024)

## 추가 기능 구현

- ### 여행지 정보 화면 2
  ![tourinfo2](https://github.com/qkrlfkadjr1/qkrlfkadjr1.github.io/assets/78300809/e1e60f9c-770e-4b68-b8cf-99ad5c3fff1e)

## 심화 기능 구현

## 알고리즘 적용 기획

### JBCrypt를 활용해 사용자 정보 암호화 서비스

1. 사용자가 가입시 비밀번호를 암호화 시킨다.
   ```java
    String encryptPassword = BCrypt.hashpw(MemberDto.getUserPassword(), BCrypt.gensalt());
   	MemberDto.setUserPassword(encryptPassword);
   ```
2. 로그인 시에 평문과 암호문을 비교한다.
   ```java
   MemberDto memberDto = memberDao.findById(userId);
   	if (BCrypt.checkpw(userPassword, memberDto.getUserPassword())) return true;
   ```

### Geolocation을 활용한 관광지 정보 거리 순 정렬

1. 현재 사용자의 위치(위도, 경도) 정보를 request 변수로 전달한다.
  ```java
    BigDecimal lat = new BigDecimal(request.getParameter("lat"));
    BigDecimal lon = new BigDecimal(request.getParameter("lon"));
  ```

2. 사용자의 위도, 경도에 대한 관광지들의 거리 순서로 정보가 출력되도록 SQL Query를 수행한다.
  ```java
    String sql = new StringBuilder("SELECT *, (POW((?-lat), 2) + POW((?-lon),2) AS distance)")
        		.append("FROM attraction_info ")
        		.append("WHERE sido_code = ? AND content_type_id = ? AND (title LIKE ? OR addr1 LIKE ?)  ")
				    .append("ORDER BY distance LIMIT 15;")
				    .toString();
  ```

## API
  ### 명세서
  ![명세서](https://github.com/Lee9Bin/Java_study/assets/116883491/6d81e79f-456c-4921-a07d-3949d361c1a8)

  ### Swagger
  ![swagger](https://github.com/Lee9Bin/Java_study/assets/116883491/8cddbb26-49d9-4900-8048-7900767e5129)
