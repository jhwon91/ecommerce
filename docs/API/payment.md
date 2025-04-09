
## 📌 결제
- **메소드**: POST
- **엔드포인트**: `/api/payments`
### **Request**
Body parameter
- orderId: 주문 ID
- userId: 사용자 ID
```json
  {
    "orderId": 1,
    "userId": 1
  }
```
### **Response**
```json
{
  "code": "201",
  "message": null,
  "data": {
    "paymentId": 1,
    "orderId": 1,
    "amount": 10000,
    "status": "PAID",
    "transactionId": "1asdwer",
    "createdAt": "2025-01-01T00:00:00"
  }
}
```
---