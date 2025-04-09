
## 📌 주문
- **메소드**: POST
- **엔드포인트**: `/api/orders`

### **Request**
Body parameter
- userId: 사용자 ID
```json
  {
    "userId": 1,
    "couponIssueId": 1
  }
```

### **Response**
- orderId: 주문 ID
- amount: 결제 금액
- orderStatus: 주문 상태
```json
  {
    "code": "201",
    "message:": "null",
    "data":{
         "orderId": 1,
         "amount": 10000,
         "orderStatus": "COMPLETE"
     }
  }
```
### **Error**
```json
{
  "code": 404,
  "message": "고객을 찾을 수 없습니다.",
  "data": {
    "errorType": "CUSTOMER_NOT_FOUND",
    "payload": 1
  }
}
```

```json
{
  "code": 404,
  "message": "활성화된 장바구니가 없습니다.",
  "data": {
    "errorType": "ACTIVE_CART_NOT_FOUND",
    "payload": 1
  }
}
```

```json
{
  "code": 404,
  "message": "장바구니에 상품이 없습니다.",
  "data": {
    "errorType": "PRODUCT_IN_CART_NOT_FOUND",
    "payload": "cart"
  }
}
```

```json
{
  "code": 404,
  "message": "제품이 존재하지 않습니다.",
  "data": {
    "errorType": "PRODUCT_NOT_FOUND",
    "payload": 1
  }
}
```

```json
{
  "code": 404,
  "message": "상품 재고가 충분하지 않습니다.",
  "data": {
    "errorType": "INSUFFICIENT_PRODUCT_STOCK",
    "payload": 1
  }
}
```
- - -