
## 📌 장바구니 상품 추가
- **메소드**: POST
- **엔드포인트**: `/api/cars`
### **Request**
Body parameter
- productId: 상품 ID
- userId: 사용자 ID
- quantity: 수량
```json
  {
    "productId": "1",
    "userId": "1",
    "quantity": 5
  }
```
### **Response**
- cartId: 장바구니 ID
- cartDetailId: 장바구니 세부 ID
- status: 장바구니 상태
- productId: 상품 ID
- name: 상품 이름
- description: 상품 설명
- price: 상품 가격
- totalPrice: 상품 총 가격
- totalQuantity: 상품 총 수량
```json
  {
    "code": "201",
    "message:": "null",
    "data":{
         "cartId": 1,
         "cartDetailId": 1,
         "status": "ACTIVE",
         "productId": 1,
         "name": "상품A",
         "description": "상품A 설명",
         "price": 100,
         "totalPrice": 1000,
         "totalQuantity": 10
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
  "message": "해당 제품은 재고가 없습니다.",
  "data": {
    "errorType": "PRODUCT_OUT_OF_STOCK",
    "payload": 1
  }
}
```

```json
{
  "code": 500,
  "message": "상품 재고가 충분하지 않습니다.",
  "data": {
    "errorType": "INSUFFICIENT_PRODUCT_STOCK",
    "payload": 10
  }
}
```
- - -