# DATABASE : 테이블을 모아놓은 공간
# CREATE DATABASE : 데이터 베이스 만들기
CREATE DATABASE mydatabase;

# database(schema) 사용하기
USE mydatabase;

# CREATE TABLE : 테이블 만들기
CREATE TABLE table1
(
    id int
);

# DROP TABLE : 테이블 삭제하기 ***매우 주의 ***
DROP TABLE table1;


SELECT *
FROM w3schools.Customers;

USE mydatabase;

CREATE TABLE table2 # 테이블 명
(
    # ( 컬럼명 타입 나열 )
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
)

INSERT INTO table2
    (name, country, phone)
VALUES ('임재홍', '한국', '010-3340-2747');

SELECT *
FROM table2;

#테이블명, 컬럼명 작성 규칙
#소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            varchar(255),
    address         varchar(255),
    last_name       varchar(255),
    nick_name       varchar(255),
    home_address    varchar(255),
    my_work_address varchar(255)
);

# 연습
# table3 만들기
# id, name, address, team
# 2개의 레코드 입력
CREATE TABLE table3
(
    id      varchar(255),
    name    varchar(255),
    address varchar(255),
    team    varchar(255)
);

INSERT INTO table3
    (id, name, address, team)
VALUES ('s1', '손흥민', '영국', '토트넘');

INSERT INTO table3
    (id, name, address, team)
VALUES ('s2', '김민재', '독일', '뮌헨');

SELECT *
FROM table3;

# RENAME TABLE my_table2 TO table3;

# DROP TABLE : 테이블 삭제 하기
DROP TABLE my_table1;

# 연습
# table3 삭제하기
DROP TABLE table3;





