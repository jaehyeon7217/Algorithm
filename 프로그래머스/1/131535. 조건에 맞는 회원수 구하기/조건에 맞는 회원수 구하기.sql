-- 코드를 입력하세요
SELECT COUNT(*)
FROM USER_INFO
WHERE TO_CHAR(JOINED, 'yyyy') = '2021' AND age between 20 and 29