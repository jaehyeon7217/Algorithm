-- 코드를 입력하세요
--  '네비게이션' 옵션이 포함된 자동차 리스트
-- 결과는 자동차 ID를 기준으로 내림차순 정렬해주세요.
SELECT *
FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC;