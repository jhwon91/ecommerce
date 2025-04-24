
## 📌 상품 조회
- **메소드**: GET
- **엔드포인트**: `/api/products`
### **Request**
Query parameter
- sortBy: name, price, stock
- sortOrder: asc, desc
- limit: 조회할 개수

### **Response**
- productId: 상품 ID
- name: 상품 이름
- price : 상품 각격
- stock : 재고 수량
```json
  {
    "code": "200",
    "message:": "null",
    "data": [
       {
         "productId": 1,
         "name": "상품A",
         "price": 10,
         "stock": 100
       },
       {
         "productId": 2,
         "name": "상품B",
         "price": 20,
         "stock": 100
       }  
    ]  
  }
```
---


## 📌 인기 상품 조회
- **메소드**: GET
- **엔드포인트**: `/api/products/popular`

### **Request**
❌

### **Response**
- productId: 상품 ID
- name: 상품 이름
- price : 상품 각격
- stock : 재고 수량
```json
  {
    "code": "200",
    "message:": "null",
    "data": [
       {
         "productId": 1,
         "name": "상품A",
         "price": 10,
         "stock": 100
       },
       {
         "productId": 2,
         "name": "상품B",
         "price": 20,
         "stock": 100
       },
      ...
    ]  
  }
```
### **Error**

---