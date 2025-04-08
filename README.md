# 🛒 이커머스 서비스

---

## 1. 서비스 개요
### 목적
- 사용자가 상품을 선택하고 충전된 잔액을 이용해 결제할 수 있는 e-커머스 주문 서비스 구현 
### 핵심 기능
- 잔액 관리 
- 상품 관리
- 쿠폰 관리
- 장바구니 관리
- 주문/결제
- 인기 상품 추천

## 1. 프로젝트 문서
- ### [요구사항](docs/01.RequirementsAnalysis)
- ### [시퀀스 다이어그램](docs/02.SequenceDiagram)
- ### [ERD 설계서](docs/03.ERD)
- ### [API 정의서](docs/04.API)

## 2. 서버 환경

- ### Programming Language: Kotlin 1.9
- ### Framework: Spring Boot 3.4
- ### ORM: Spring Data JPA
- ### DataBase: mysql:8.0
- ### Test: Spring Boot Test

## 3. 패키지 구조
```
📦 MarketService
├─ user
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
├─ coupon
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
├─ product
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
├─ cart
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
├─ order
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
├─ payment
│  ├─ application
│  ├─ domain
│  ├─ infra
│  └─ presentation
└─ global
```
