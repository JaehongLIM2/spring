# Transaction : 업무 단위
# ** 세부 업무들은 모두 실패하거나 모두 성공
# rollback; 되돌리기
# commit; 반영하기

# A가 B에게 500원 송금
# 1. A의 돈에서 500원 차감
# UPDATE 계좌_table
# SET money = money - 500
# WHERE user = 'a';
#
# # 2. B의 돈에  500원 더함
# UPDATE 계좌_table
# SET money = money + 500
# WHERE user = 'B';

USE mydatabase;

CREATE TABLE table53
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user VARCHAR(10),
    money INT
);

INSERT INTO table53
    (user, money)
VALUES ('A', 10000),
       ('B', 10000);

UPDATE table53
Set money = money - 500
WHERE user = 'A';

UPDATE table53
Set money = money + 500
WHERE user = 'B';

# 현재 트랜잭션을 되돌림(마지막 커밋 상태로 되돌아감)
ROLLBACK;

# 현재 트랜잭션 적용(반영)
COMMIT;

SELECT *
FROM table53;









