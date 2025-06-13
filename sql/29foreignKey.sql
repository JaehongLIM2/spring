USE mydatabase;

# 게시물
# 제목, 본문, 작성일시, 회원 ID,
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(255),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);
DROP TABLE table43;

# 회원
# ID, PW, 자기소개
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(255)

);

# 1 대 N, N 대 1
# 1 대 1 (잘 보이진 않음)
# 직원 정보
CREATE TABLE table45
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20)
);

CREATE TABLE table46
(
    id     INT PRIMARY KEY,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);

# N 대 N
# 중간테이블 (연결테이블, 조인테이블) 이 필요함
# 학생
CREATE TABLE table48
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);

# 수업
CREATE TABLE table47
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)
);

#학생 수업
CREATE TABLE table49
(
    table48_id INT,
    table47_id INT,
    PRIMARY KEY (table48_id, table47_id),
    FOREIGN KEY (table48_id) REFERENCES table48(id),
    FOREIGN KEY (table47_id) REFERENCES table47(id)
);

# 연습
CREATE TABLE table50
(
    Movie_id  INT PRIMARY KEY AUTO_INCREMENT,
    title     VARCHAR(255),
    open_date DATE,
    info      VARCHAR(255)
);

CREATE TABLE table51
(
    Actor_id INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255),
    age      VARCHAR(255),
    sex      VARCHAR(255)
);

CREATE TABLE table52
(
    Movie_id INT,
    Actor_id INT,
    PRIMARY KEY (Movie_id, Actor_id),
    FOREIGN KEY (Movie_id) REFERENCES table50 (Movie_id),
    FOREIGN KEY (Actor_id) REFERENCES table51 (Actor_id)
);






















