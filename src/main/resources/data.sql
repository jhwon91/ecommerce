INSERT INTO users (name, created_at, updated_at)
VALUES
    ('사용자_A',NOW(), NOW()),
    ('사용자_B',NOW(), NOW()),
    ('사용자_C',NOW(), NOW());


INSERT INTO product(name, price, quantity, created_at, updated_at)
VALUES
    ('상품_A', 1000, 0, NOW(), NOW()),
    ('상품_B', 2000, 0, NOW(), NOW()),
    ('상품_C', 3000, 0, NOW(), NOW());

INSERT INTO stock (product_id, quantity, created_at, updated_at)
VALUES
    (1, 100, NOW(), NOW()),
    (2, 200, NOW(), NOW()),
    (3, 300, NOW(), NOW());

INSERT INTO ecommerce.coupon (name, discount_type, discount_value, total_quantity, issued_quantity, expiry_date, created_at, updated_at)
VALUES
    ('testCoupon1', 'FIXED_AMOUNT', 1000, 10, 0, '2100-01-01 00:00:00', NOW(), NOW()),
    ('testCoupon2', 'PERCENTAGE', 10, 20, 0, '2100-01-01 00:00:00', NOW(), NOW());