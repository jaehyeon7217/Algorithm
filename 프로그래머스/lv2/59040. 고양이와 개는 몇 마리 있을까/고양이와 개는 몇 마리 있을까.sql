-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(*)
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Cat'or ANIMAL_TYPE = 'Dog'
group by ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;
