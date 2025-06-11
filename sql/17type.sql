USE mydatabase;

# STRING
# VARCHAR(길이)
CREATE TABLE table4
(
    col1 varchar(1),
    col2 varchar(3),
    col3 varchar(5)
);

INSERT INTO table4
    (COL1, COL2, COL3)
VALUES ('a', 'abc', 'abcde');

# 실패
INSERT INTO table4
    (COL1, COL2, COL3)
VALUES ('ab', 'abc', 'abcde');

INSERT INTO table4
    (COL1, COL2, COL3)
VALUES ('악', 'abc', 'abcde');

# 실패
INSERT INTO table4
    (COL1, COL2, COL3)
VALUES ('두글', 'abc', 'abcde');

# 연습
# table5 만들기
# id(최대 8글자), name(최대 20글자)
# 두 개의 레코드 입력(성공)
# 실패하는 레코드 입력 시도
CREATE TABLE table5
(
    id   varchar(8),
    name varchar(20)
);

INSERT INTO table5
    (id, name)
VALUES ('nu0044', '이름이20글자인이름을지어보자아졸리다');

INSERT INTO table5
    (id, name)
VALUES ('nu0022', '한글자이름');

INSERT INTO table5
    (id, name)
VALUES ('12dow11', '20자리가넘어가는이름은보통존재하지않는다그렇지않을까?');

SELECT *
FROM table5;
# NUMBER
# INTEGER (소숫점 없는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT # 2^62 - 1 / java의 long타입과 같음
);

INSERT INTO table6
    (col1, col2)
VALUES (231312414, 1231231231);

INSERT INTO table6
    (col1, col2)
VALUES (2147483647, 2147483647);

INSERT INTO table6
    (col1, col2)
VALUES (2147483641, 2147483647);

# 연습
# score(정수), length(큰 정수) 컬럼이 있는 table7 만들기
# 두 개의 레코드 입력(성공)
CREATE TABLE table7
(
    score  INT,
    length BIGINT
);

INSERT INTO table7
    (score, length)
VALUES (98, 102035491);

INSERT INTO table7
    (score, length)
VALUES (153, 295610235);

# BIGINT 최댓값 : 9,223,372,036,854,775,807
INSERT INTO table7
    (score, length)
VALUES (123, 9223372036854775808);

# DECIMAL (총 길이, 소숫점 이하 길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);

INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (231, 1234.5, 1234567.123, null, null);

SELECT *
FROM table8;

INSERT INTO table8
(col1, col2, col3, col4, col5)
VALUES (231, 1234.56, 1234567.1234, null, null);

SELECT *
FROM table8;

# 길이 초과로 실행안됨
INSERT INTO table8
(col1, col2, col3, col4, col5)
VALUES (231, 1234.56, 12345678.1234, null, null);

# 길이 초과로 실행안됨
INSERT INTO table8
(col1, col2, col3, col4, col5)
VALUES (231, 12345.56, 12345678.1234, null, null);

# 연습
# score(총 길이 4, 소숫점 이하 2), money(총 길이 10, 소숫점 이하 3) table9
CREATE TABLE table9
(
    score DEC(4, 2),
    money DEC(10, 3)
);

INSERT INTO table9
    (score, money)
VALUES (14.23, 1230424.231);

INSERT INTO table9
    (score, money)
VALUES (2.41, 203994.2);

INSERT INTO table9
    (score, money)
VALUES (2.333333, 123.23);

INSERT INTO table9
    (score, money)
VALUES (11123.2, 21314.23);

SELECT *
FROM table9;
# DATE, TIME