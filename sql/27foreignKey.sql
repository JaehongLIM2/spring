USE mydatabase;

CREATE TABLE table41
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30),
    price       INT,
    category_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES table42(id)

);
DROP TABLE table41;

# 카테고리 테이블
CREATE TABLE table42
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    info VARCHAR(30),
    PRIMARY KEY (id)
);



INSERT INTO table41
    (name, price, category_id)
VALUES ('몽쉘', 1000, 1),
       ('오예스', 2000, 1),
       ('게토레이', 500, 2),
       ('커피', 600, 2),
       ('가나', 500, 3),
       ('크런키', 500, 3);

INSERT INTO table42
    (name, info)
VALUES ('파이', '크림이 있는 빵'),
       ('음료수', '설탕물'),
       ('초콜릿', '카카오 가공품');

DESC table41;

SELECT *
FROM table41;

SELECT *
FROM table42;

SELECT *
FROM table41 t1
JOIN table42 t2
ON t1.category_id = t2.id;

INSERT INTO table41
    (name, price)
VALUES ('컴퓨터', 10000);

INSERT INTO table42
    (name, info)
VALUES ('전자제품', '전기를 사용함');

UPDATE table41
SET category_id = 4
WHERE id = 8;

# 외래키로 사용되고 있는 테이블은 삭제되지 않음
# DELETE FROM table42
# WHERE id = 4;

DELETE
FROM table41
WHERE category_id = 4;

SELECT *
FROM table41
WHERE category_id = 4;

DELETE
FROM table42
WHERE id = 4;

SELECT *
FROM table42
WHERE id = 4;





