
## 📌 잔액 조회
- **메소드**: GET
- **엔드포인트**: `/api/users/{userId}/balance`
### **Request**
❌
### **Response**

```json
{
  "code": "200",
  "message:": "null",
  "data": {
    "userId": 1,
    "balance": 20000  
  }
}
```
---

## 📌 잔액 충전
- **메소드**: POST
- **엔드포인트**: `/api/users/{userId}/balance/charge`
### **Request**
Request Body
```json
{
  "amount": 10000
}
```
### **Response**

```json
{
  "code": "200",
  "message:": "null",
  "data": {
    "userId": 1,
    "chargedAmount": 10000,
    "totalBalance": 20000 
  }
}
```
---