-- 코드를 작성해주세요
-- 가장 큰 물고기의 길이를 'cm' 를 붙여 출력
--  컬럼명은 'MAX_LENGTH' 로 지정해

SELECT CONCAT(MAX(LENGTH), 'cm')  MAX_LENGTH
FROM FISH_INFO 