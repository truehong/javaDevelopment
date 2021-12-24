# javaDevelopment
실전 자바 소프트웨어 개발 에제 정리

## 2장 입출금 내역 분석기 

- KISS 원칙 
  - keep it short and simple



- 단일 책임 원칙 (SRP)
  - 한 클래스는 한 기능만 책임 진다. 
  - 한 클래스가 바뀌어야 하는 이유는 오직 하나여야 한다. (로버트 마틴)

  - SRP 는 일반적으로 클래스와 메서드에 적용한다. 
  - SRP 는 특정 동작, 개념, 카테고리와 관련된다. 
  - SRP 를 적용하면 코드가 바뀌어야 하는 이유가 한 가지로 제한되므로 더 튼튼한 
    코드를 만들 수 있다. 이유가 한가지가 아니라면, 여러 장소에서 코드 변경이 발생하므로 코드 유지보수가 더 어려워 진다.
  
 
[ 단일 책임  분리 예시 ]
  1) 입력 읽기 
  2) 주어진 형식의 입력 파싱
  3) 결과 처리 
  4) 결과 요약 리포트

