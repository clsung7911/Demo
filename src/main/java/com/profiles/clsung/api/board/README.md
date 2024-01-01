# Board(게시판) 관련 API 패키지

## 기본 구조
* controller : RESTfull API 지원
* data : 
  * entity : 실 DB 테이블과 매칭되는 클래스 
  * request : 요청 객체, 자주 변경될 수 있어 entity 와 분리
  * response : 응답 객체, 자주 변경될 수 있어 entity 와 분리
* repository : DB에 실제로 접근하는 객체, service와 DB를 연결하는 고리 역할(Mybtis의 DAO 역할)
* service : 비지니스 로직 수행
  * impl : 인터페이스와 구현체를 분리함으로써 구현체를 독립적으로 확장

